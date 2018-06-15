import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: April 19, 2017 (Wednesday)
 * File: ElectionData.java
 * 
 *  
 * This file builds a class that can parse election results 
 * from a csv file containing results from 2012 and 2016, by county.
 * This file holds many methods and creates the different objects
 * being used. Methods such as parsing the election file,
 * finding the most lopsided ratio, finding the number of counties
 * that voted for the winner of that year, finding the state with the
 * most third party votes, and lastly I created a method that
 * totaled the number of votes for that year.
 */

/**
 * A class to parse a specifically formatted CSV file containing election
 * results.
 *
 */
public class ElectionData {
	
	// A list of results at the county level in 2012
	ArrayList<CountyElectionResult> countyResults2012;
	
	// A list of results at the county level in 2016
	ArrayList<CountyElectionResult> countyResults2016;

	// Lists of results at the state level in 2012 and 2016
	// YOU DO NOT HAVE TO USE THESE LISTS, BUT MIGHT FIND
	// THEM USEFUL.
	ArrayList<StateElectionResult>  stateResults2012;
	ArrayList<StateElectionResult>  stateResults2016;
	
	ArrayList<CountyElectionResult> getCountyResults2012() {
		return countyResults2012;
	}

	ArrayList<CountyElectionResult> getCountyResults2016() {
		return countyResults2016;
	}

	ArrayList<StateElectionResult> getStateResults2012() {
		return stateResults2012;
	}

	ArrayList<StateElectionResult> getStateResults2016() {
		return stateResults2016;
	}
	
	/**
	 * Initialize all the results lists to be empty.
	 */
	public ElectionData() {
		countyResults2012 = new ArrayList<CountyElectionResult>();
		countyResults2016 = new ArrayList<CountyElectionResult>();

		stateResults2012 = new ArrayList<StateElectionResult>();
		stateResults2016 = new ArrayList<StateElectionResult>();
	}
	
	
	/**
	 * Parse a file of election results containing results from 
	 * two years of elections: 2012 and 2016
	 * 
	 * Each line in the file has the following fields, separated by commas:
	 * 
	 * state_abbr,county_name,fips,state_fips,county_fips,
	 * total_votes_2012,votes_dem_2012,votes_gop_2012,total_votes_2016,
	 * votes_dem_2016,votes_gop_2016
	 * 
	 * See the PA2 writeup for an explanation of each of these fields.
	 * 
	 * This function does not need to handle incorrectly formatted files.
	 * It can simply throw an exception if there is a problem with the file
	 * or if any of the lines are not formatted correctly.
	 * 
	 * @param filename The file containing the election results, 
	 * in the format described above.
	 */
	
	public void parseElectionFile(String filename) throws IOException {
		File allData = new File(filename);
		// TODO: Complete this file to read in the data from the file
		// to populate the lists countyResults2012 and countyResults2016.
		// You may also populate the lists stateResults2012 and 
		// stateResults2016 if that is helpful, but you do not have to.
		
		//Read input file into text
		Scanner readFile = new Scanner(allData);

		
		//For each line in the scanner, put results into a string array list
		//create the arraylist
		ArrayList<String> fileArray = new ArrayList<String>();
	
		//Read file
		while (readFile.hasNextLine()){
			fileArray.add(readFile.nextLine());
		}
		
		//Go through each index of fileArray and parse the lines
		//skip the first line/ header because it just has a description
		// in the file
		for (int i= 1; i < fileArray.size(); i++){
			//Get value(Each line) at index 
			parseLine(fileArray.get(i));

		}
		
		
		
		//Each one of these lines will be strings that are in respective indexes
		//You can then pass in each of these lines by getting the arraylist.get(index)
		//Take each of those and use in the fileparse method
			readFile.close();
				
			}
		
	/*
	private void stateArrayListCreator (){
		
		//make a states list with empty values for the votes
		//sum Dem, Rep, and other votes for each state as the loop runs
		//if state is missing in list, add it
		//Initialize respective StateElectionResult objects
		StateElectionResult resultState2012 = new StateElectionResult("","",0,0,0);
		StateElectionResult resultState2016 = new StateElectionResult("","",0,0,0);


		//Set the state ArrayList 2012
		for (int i = 1; i < countyResults2012.size(); i++){
			if (countyResults2012.get(i).getState() != countyResults2012.get(i-1).getState()){
				resultState2012.setState(countyResults2012.get(i).getState());
				resultState2012.setYear("2012");
			}
	
			else{
				resultState2012.setNumVotesDem
					(countyResults2012.get(i).getNumVotesDem());
				resultState2012.setNumVotesGop
					(countyResults2012.get(i).getNumVotesGop());
				resultState2012.setNumVotesOther
					(countyResults2012.get(i).getNumVotesOther());
					
				}
				
				System.out.println(resultState2012.getState());
			}
			
		
					
		//Set the state ArrayList 2016
		for (int i = 1; i < countyResults2016.size(); i++){
			if (countyResults2016.get(i).getState() != countyResults2016.get(i-1).getState()){
				resultState2016.setState(countyResults2012.get(i).getState());
				resultState2016.setYear("2016");
			}
		
		else {
		resultState2016.setNumVotesDem
			(countyResults2016.get(i).getNumVotesDem());
		resultState2016.setNumVotesGop
			(countyResults2016.get(i).getNumVotesGop());
		resultState2016.setNumVotesOther
			(countyResults2016.get(i).getNumVotesOther());
			
			}
		}
	

		
		stateResults2012.add(resultState2012);
		stateResults2016.add(resultState2016);
		
		System.out.println("resultState2012: " + resultState2012.getState());
		System.out.println("stateArrayList: " + stateResults2012.get(0).getState());
				
	}
*/
	
	
	
	/**
	 * Part 2C: Method 1
	 * Method takes String representing the year of the election and
	 * returns the CountyElectionResult object for the most lopsided county
	 * between the democratic and republican votes (the greatest difference
	 * in absolute value between te ratios of republican and democratic).
	 * If there is a tie, the method should return the first county in the
	 * list with the highest difference. if invalid year (null) return null.
	 * 
	 * @return CountyElectionResult object with the most lopsided results
	 *          between dem and gop
	 */
	
	
	CountyElectionResult mostLopsidedCounty(String year) {
		// TODO: Implement this method and replace the return statement below
		// See PA2 writeup for description of this method.
		
		//Create integer place holders
		String state = "";
		String county = "";
		String fips = "";
		int demVote = 0;
		int repVote = 0;
		int otherVote = 0;
		int totalVote = 0;
		double currRatio = 0.0;
		double tempRatio = 0.0;
		int test = 0;
	
		//Create CountyElectionResult object to hold lopsidedCounty result
		CountyElectionResult lopsidedCounty = new CountyElectionResult("","","","",0,0,0);
		
		//If year is 2012 get 2012 county array list
		if(year == "2012"){
			//Loop through 2012 array list
			for(int i = 0; i < getCountyResults2012().size(); i++){
				//Get votes from 2012 array list
				state = getCountyResults2012().get(i).getState();			
				county = getCountyResults2012().get(i).getCounty();
				fips = getCountyResults2012().get(i).getFips();
				demVote = getCountyResults2012().get(i).getNumVotesDem();	
				repVote = getCountyResults2012().get(i).getNumVotesGop();			
				otherVote = getCountyResults2012().get(i).getNumVotesOther();
				
				//Calculate total vote
				totalVote = demVote + repVote + otherVote;
				
				
				//Get ratio to see which one is highest
				tempRatio = ((double)Math.abs(demVote - repVote))/totalVote;
				
				//Update currRatio to be highest ratio
				if(tempRatio > currRatio){
					//Update curr ratio for comparison
					currRatio = tempRatio;
					//Set values of result CountyElectionResult object with parameters of highest ratio county
					lopsidedCounty.setState(state);
					lopsidedCounty.setCounty(county);
					lopsidedCounty.setFips(fips);
					lopsidedCounty.setNumVotesDem(demVote);
					lopsidedCounty.setNumVotesGop(repVote);
					lopsidedCounty.setNumVotesOther(otherVote);
				}
				else if(tempRatio == currRatio){
					continue;
				}
			}
			

		}
		
		//If year is 2016 get 2016 county array list
		else if(year == "2016"){
			//Loop through 2016 array list
			for(int i = 0; i < getCountyResults2016().size(); i++){
				//Get votes from 2016 array list
				state = getCountyResults2016().get(i).getState();
				county = getCountyResults2016().get(i).getCounty();
				fips = getCountyResults2016().get(i).getFips();
				demVote = getCountyResults2016().get(i).getNumVotesDem();
				repVote = getCountyResults2016().get(i).getNumVotesGop();
				otherVote = getCountyResults2016().get(i).getNumVotesOther();
				//Calculate total vote
				totalVote = demVote + repVote + otherVote;
				
				//Get ratio to see which one is highest
				tempRatio = ((double)Math.abs(demVote - repVote))/totalVote;
				
				//Update currRatio to be highest ratio
				if(tempRatio > currRatio){
					//Update curr ratio for comparison
					currRatio = tempRatio;
					//Set values of result CountyElectionResult object with parameters of highest ratio county
					lopsidedCounty.setState(state);
					lopsidedCounty.setCounty(county);
					lopsidedCounty.setFips(fips);
					lopsidedCounty.setNumVotesDem(demVote);
					lopsidedCounty.setNumVotesGop(repVote);
					lopsidedCounty.setNumVotesOther(otherVote);
				}
				else if(tempRatio == currRatio){
					continue;
				}
			}
		}
		else{
			return null;
		}
		
		return lopsidedCounty;
	}

	/**
	 * Part 2C: Method 2
	 * Takes in two strings (state abbreviation and year) and returns
	 * the number of counties whose majority vote aligned with the
	 * presidential winner. If a state had majority democratic
	 * (demo > gop) and democratic nomiee was elected for 
	 * 2012 or 2016, then california would be included. method 
	 * returns an integer.
	 * if year input is invalid (include null) method returns -1
	 * if state input is invalid (include null) method reuturns 0
	 * 
	 * in the arraylist of countyResults, objects are grouped by state
	 * 
	 * @return number of counties in that state that align with the winner
	 *          of that year
	 */
	
	//DEMOCRATIC WON 2012, GOP WON 2016
	int numCountiesVotedForWinner(String stateAbbr, String year) {
		// TODO: Implement this method and replace the return statement
		//Return value
		int numCountyWinners = 0;
		int demVote = 0;
		int repVote = 0;
		
		
		if(year == "2012"){
			for(int i = 0; i < getCountyResults2012().size(); i++){
				//Check each state with input state and see if they equal
				//If not go to next one and if i = 50 without a match then return 0;
				
				if(getCountyResults2012().get(i).getState().equals(stateAbbr)){
					//Get votes to compare total
					demVote = getCountyResults2012().get(i).getNumVotesDem();
					repVote = getCountyResults2012().get(i).getNumVotesGop();
					
					if(demVote > repVote){
						//Increment democrat winners because dem won 2012
						numCountyWinners++;
					}
				}
				else{
					//If you run through the whole array then state doesn't exist
					if(i == getCountyResults2012().size()){
						return 0;
					}
					//If you haven't ran through the whole array then keep checking for states
					else{
						continue;	
					}
				}
			}
		}
		else if(year == "2016"){
			for(int i = 0; i < getCountyResults2016().size(); i++){
				//Check each state with input state and see if they equal
				//If not go to next one and if i = 50 without a match then return 0;
				
				if(getCountyResults2016().get(i).getState().equals(stateAbbr)){
					//Get votes to compare total
					demVote = getCountyResults2016().get(i).getNumVotesDem();
					repVote = getCountyResults2016().get(i).getNumVotesGop();
					
					if(repVote > demVote){
						//Increment democrat winners because rep won 2016
						numCountyWinners++;
					}
				}
				else{
					//If you run through the whole array then state doesn't exist
					if(i == getCountyResults2016().size()){
						return 0;
					}
					//If you haven't ran through the whole array then keep checking for states
					else{
						continue;	
					}
				}
			}
		}
		else{
			return -1;
		}

		return numCountyWinners;
	}

	
	
	
	/**
	 * Part 2C: Method 3
	 * Takes in a string representing the year of the election and
	 * returns the string representing the state abbreviation for the 
	 * state with the max percentage of voters for the 3rd party
	 * candidate of that year.
	 * if there is a tie, he method should return the first state among
	 * the tied states, if the year is invalid (include null) 
	 * method returns an empty string
	 * 
	 * @return the state with the highest % of 3rd party votes
	 */
	
	
	
	String mostThirdParty(String year) {
		// TODO: Complete this method and replace the return statement below
		String stAbbr = "";
		int otherVote = 0;
		int demVote = 0;
		int repVote = 0;
		int totalVote = 0;
		double currPerc = 0.0;
		double tempPerc = 0.0;
		
		//Check if year 2012
		if(year == "2012"){
			//Loop through each county result
			for(int i = 0; i < getCountyResults2012().size(); i++){
				//Get required variables
				otherVote = getCountyResults2012().get(i).getNumVotesOther();
				demVote = getCountyResults2012().get(i).getNumVotesDem();
				repVote = getCountyResults2012().get(i).getNumVotesGop();
				
				//Calculate total votes
				totalVote = demVote + repVote;
				
				//Calculate other vote percentage
				tempPerc = ((double)(otherVote))/totalVote;
				
				if(tempPerc > currPerc){
					//Update current percentage of other votes
					currPerc = tempPerc;
					//Update return value with max percentage other vote state
					stAbbr = getCountyResults2012().get(i).getState();

					
				}
				//If equal, keep it the same
				else if(currPerc == tempPerc){
					continue;
				}
				
				
			}
		}
		//Check if year 2016
		else if (year == "2016"){
			//Loop through each county result
			for(int i = 0; i < getCountyResults2016().size(); i++){
				//Get required variables
				otherVote = getCountyResults2016().get(i).getNumVotesOther();
				
				demVote = getCountyResults2016().get(i).getNumVotesDem();
				repVote = getCountyResults2016().get(i).getNumVotesGop();
				
				//Calculate total votes
				totalVote = demVote + repVote;
				
				//Calculate other vote percentage
				tempPerc = ((double)(otherVote))/totalVote;
				
				if(tempPerc > currPerc){
					//Update current percentage of other votes
					currPerc = tempPerc;
					//Update return value with max percentage other vote state
					stAbbr = getCountyResults2016().get(i).getState();
				}
				//If equal, keep it the same
				else if(currPerc == tempPerc){
					continue;
				}
				
			}
		}
		//Check if anything other than year or null
		else{
			stAbbr = "";
		}

		return stAbbr;
	} 

		
		
	/**
	 * Part 2C: Method 4
	 * Complete this header comment
	 * 
	 * @return Return list of two lists (dem->rep, rep->dem) which states
	 *          switched party affiliation between 2012 -> 2016
	 *			0 index is demToRep
	 *			1 index is repToDem
	 */
	/*
	ArrayList<ArrayList<String>> switchedParties() {
		// TODO: The code below returns a list of two empty lists. 
		// you need to complete the code to fill in the two lists.
		
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		ArrayList<String> demToRep = new ArrayList<String>();
		ArrayList<String> repToDem = new ArrayList<String>();

		results.add(demToRep);
		results.add(repToDem);

		return results;
	}
	*/
	
	/**
	 * Part 2C: Method 5
	 * Takes in a string representing the year of the election and 
	 * returns an integer of the total number of votes for that year
	 * also known as the voter turn out. 
	 * it does the checks to make sure the year
	 * is valid when inputting it.
	 * if the year is invalid (include null) 
	 * method returns an empty string
	 * @return Return total number of voters for certain year.
	 */
	
	int voterTurnout(String year){
		//Return result
		int totalVotes = 0;
		int tempVotes = 0;
		int otherVote = 0;
		int demVote = 0;
		int repVote = 0;

		
		//Check if year 2012
		if(year == "2012"){
			
			//Loop through each county result
			for(int i = 0; i < getCountyResults2012().size(); i++){
				//Get required variables
				otherVote = getCountyResults2012().get(i).getNumVotesOther();
				demVote = getCountyResults2012().get(i).getNumVotesDem();
				repVote = getCountyResults2012().get(i).getNumVotesGop();
				
				//Calculate total votes of each county
				tempVotes = demVote + repVote + otherVote;
				//Calculate total number of votes across all counties
				totalVotes = totalVotes + tempVotes;	
				
			}
		}
		//Check if year 2016
		else if (year == "2016"){
			//Loop through each county result
			for(int i = 0; i < getCountyResults2016().size(); i++){
				//Get required variables
				otherVote = getCountyResults2016().get(i).getNumVotesOther();
				
				demVote = getCountyResults2016().get(i).getNumVotesDem();
				repVote = getCountyResults2016().get(i).getNumVotesGop();
				
				//Calculate total votes
				tempVotes = demVote + repVote + otherVote;
				//Calculate total number of votes across all counties
				totalVotes = totalVotes + tempVotes;
				
			}
		}
		//Check if anything other than year or null
		else{
			System.out.println("Invalid Year!");
			return totalVotes;
		}

		return totalVotes;
	} 
	
	
	
	/**
	* Part 2B
	 *Print the menu of choices,
	 *get the users response
	 *check to make sure it is valid, if not reprompt the user
	 *call the method to calculate the data
	 *print the result for the user
	 */
	public void runLoop() {
		// TODO: Complete this method.  
		// If you call any helper methods that need to read
		// input from the user, pass the commandReader Scanner
		// object to these methods.  You don't want to have more than one
		// Scanner reading from System.in at the same time.

		Scanner commandReader = new Scanner(System.in);
		
		printOptions();
		
		//Int variable to hold user input
		int userInt = -1;

		//string passed in by the user
		String userString = commandReader.next();
		//Convert user input from string to int
		userInt = Integer.parseInt(userString);
		

		//Check to see that user input is not 0
		while (userInt != 0){
			
			//Convert user input from string to int
			userInt = Integer.parseInt(userString);
			

			//Check to see if user input is valid
			if (userInt < 0 || userInt > 5){
				System.out.println("You entered an invalid choice. Please try again");
				userString = commandReader.next();
			}


			//If User chooses option 1
			if(userInt == 1){

				//Verify user option
				System.out.println("You chose option 1");
				//Ask for year to use
				System.out.print ("Which year would you like to use? ");
				//Value to hold year
				String year = commandReader.next();
			

				//check if valid year
				if(!(year.equals("2012") || year.equals("2016"))){
					System.out.println("You entered an invalid choice. Please try again.");	
				}
				else{
					//If 2012 then pass in 2012
					if (year.equals("2012")){
						System.out.println("The most lopsided county is " + mostLopsidedCounty("2012").getCounty() + ", "
											+ mostLopsidedCounty("2012").getState());
					}
					//If 2016 then pass in 2016
					else{
						System.out.println("The most lopsided county is " + mostLopsidedCounty("2016").getCounty() + ", "
								+ mostLopsidedCounty("2016").getState());
					}	
				}

			}
			
			else if (userInt == 2){
					//Verify user option
					System.out.println("You chose option 2");
					//Ask for year to use
					System.out.print ("Which year would you like to use? ");
					//Value to hold year
					String year = commandReader.next();
					//Ask for state to use
					System.out.print ("Which state would you like to use? ");
					//Value to hold state
					String state = commandReader.next();
					
				

					//check if valid year
					if(!(year.equals("2012") || year.equals("2016"))){
						System.out.println("You entered an invalid choice. Please try again.");	
					}
					else{
						//If 2012 then pass in 2012
						if (year.equals("2012")){
							System.out.println("In 2012, " + numCountiesVotedForWinner(state,"2012")
												+ "counties in " + state + " aligned with the winner.");
						}
						//If 2016 then pass in 2016
						else{
							System.out.println("In 2016, " + numCountiesVotedForWinner(state,"2016")
							+ " counties in " + state + " aligned with the winner.");
						}
					}	
				}
				
				//if 3
				else if(userInt == 3){
					//Verify user option
					System.out.println("You chose option 3");
					//Ask for year to use
					System.out.print ("Which year would you like to use? ");
					//Value to hold year
					String year = commandReader.next();
				

					//check if valid year
					if(!(year.equals("2012") || year.equals("2016"))){
						System.out.println("You entered an invalid choice. Please try again.");	
					}
					else{
						//If 2012 then pass in 2012
						if (year.equals("2012")){
							System.out.println(mostThirdParty("2012") + " is the state with the highest percentage "
									+ "of third party votes in 2012.");
												
						}
						//If 2016 then pass in 2016
						else{
							System.out.println(mostThirdParty("2016") + " is the state with the highest percentage "
									+ "of third party votes in 2016.");
						}
					}
				}	
					
				
				else if(userInt == 5){
					//Verify user option
					System.out.println("You chose option 5");
					//Ask for year to use
					System.out.print ("Which year would you like to use? ");
					//Value to hold year
					String year = commandReader.next();
				

					//check if valid year
					if(!(year.equals("2012") || year.equals("2016"))){
						System.out.println("You entered an invalid choice. Please try again.");	
					}
					else{
						//If 2012 then pass in 2012
						if (year.equals("2012")){
							System.out.println("The total number of votes for 2012 is: " + voterTurnout("2012"));
												
						}
						//If 2016 then pass in 2016
						else{
							System.out.println("The total number of votes for 2016 is: " + voterTurnout("2016"));
						}
					}
				}
			
			printOptions();
			userString = commandReader.next();
					
		}
		

			System.out.println ("Goodbye!");
			commandReader.close();
			
}
	
	


	
	
	// TODO: Add private helper methods here.  Two are listed below,
	// and the parseLine method is required,
	// but feel free to add more to help you keep your methods above short.
	
	
	/**
	 * This method takes one line of the input file containing the election data,
	 * in the format described in the PA2 writeup.  It should parse the line
	 * and create two CountyElectionResult objects, one for 2012 results and
	 * one for 2016 results.  Then it should add each object to the appropriate
	 * ArrayList countyResults2012 and countyResults2016.
	 * 
	 * You will call this method from your parseElectionFile method.
	 * 
	 * @param line A single line from the election results file.
	 */
	
	
	
	
	//PART 2A: going through each line and allocating the information
	//taken from each line into the right ElectionResults objects
	private void parseLine(String line)
	{
		// TODO: Complete this method

		
		//Initialize respective CountyElectionResult objects
		CountyElectionResult result2012 = new CountyElectionResult("","","","",0,0,0);
		CountyElectionResult result2016 = new CountyElectionResult("","","","",0,0,0);
		
		//takes one line of the input file with the election data	
		//parse the line and create two CountyElectionResult objects
		String [] lineInfo = line.split(",");
		

		//Create an object for line and then get index and set 
		//those indexes in county results
	
		
		//set location in the countyRests object of 2012
		result2012.setState(lineInfo[0]);
		result2012.setCounty(lineInfo[1]);
		result2012.setFips(lineInfo[2]);
		result2012.setYear("2012");
		
		
		//set location in the countyRests object of 2016
		result2016.setState(lineInfo[0]);
		result2016.setCounty(lineInfo[1]);
		result2016.setFips(lineInfo[2]);
		result2016.setYear("2016");
		

		//add to countyResults 2012
		result2012.setNumVotesDem((int)Double.parseDouble(lineInfo[6]));
		result2012.setNumVotesGop((int)Double.parseDouble(lineInfo[7]));
		int otherVote2012 = (int)Double.parseDouble(lineInfo[5]) - 
				((int)Double.parseDouble(lineInfo[6]) + (int)Double.parseDouble(lineInfo[7]));
		result2012.setNumVotesOther(otherVote2012);
		
	
		//add to countyResults 2016
		result2016.setNumVotesDem((int)Double.parseDouble(lineInfo[9]));
		result2016.setNumVotesGop((int)Double.parseDouble(lineInfo[10]));
		int otherVote2016 = (int)Double.parseDouble(lineInfo[8]) - 
				((int)Double.parseDouble(lineInfo[9]) + (int)Double.parseDouble(lineInfo[10]));
		result2016.setNumVotesOther(otherVote2016);
		
		
		countyResults2012.add(result2012);
		countyResults2016.add(result2016);
		
		//stateArrayListCreator();

			
		}
	

		
	
	
	
	/**
	 * A private helper function to print the options menu.  
	 * This method is not required, but STRONGLY recommended
	 * so that your runLoop method stays short.
	 */
	private void printOptions()
	{
		
		System.out.println("What would you like to know? Enter the number corresponding to your choice.");
		System.out.println("       1        Most lopsided county between dem and rep (param: year)");
		System.out.println("       2        How many counties align with the actual winner (param: year, param: state");
		System.out.println("       3        State with max percent of votes for 3rd party candidate (param: year)");
		System.out.println("       4        Which states switched party affiliation between 2012 and 2016");
		System.out.println("       5        How many votes were there for the specified year(param: year)");
		System.out.println("       0        Quit");
		System.out.print("Please enter your choice:");
		
	}

	
	/** 
	 * A command line program to allow the user to interact with the election
	 * data.
	 * 
	 * You do not need to modify the main method, but you should understand 
	 * what it does.
	 * 
	 * @param args The program takes the name of the file as a command line
	 * argument.
	 */
	public static void main(String[] args) {	
		// We will provide the code that reads the command line argument
		if (args.length < 1) {
			System.out.println("No data file passed in");
			return;
		}
		
		ElectionData data = new ElectionData();
		// Call the parseElectionFile method to read in the data
		try {
			data.parseElectionFile(args[0]);
		}
		catch (IOException e) {
			System.out.println("There was a problem with the data file");
			e.printStackTrace();
			return;
		}
		// Run the main loop
		data.runLoop();
		
	}
	
}
