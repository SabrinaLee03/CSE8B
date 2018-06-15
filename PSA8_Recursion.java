/* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 31, 2017 (Wednesday)
 * File: Recursion.java
 */
/**
* File: Recursion.java
 * Author: Gustavo Umbelino, Sriram Manohar, and TODO add your name(s)!
 * Date: 5/24/2017
 * Description: TODO describe this class!
 */

import java.util.ArrayList;
import java.util.Random;

public class Recursion {

    public static double humanPyramidWeight(ArrayList<ArrayList<Double>> weights,
                                            int level, int offset) throws Exception {
        return 1.0;
    }

  //PROBLEM WORKED ON NUMBER 2
  //creates an arrayList with all the possible combinations
  //letters for that number sequences being passed in
    public static ArrayList<String> generateMnemonics(String number) {
    	
    	//finalArrayList to return
    	ArrayList<String> finalArray = new ArrayList<String>();
    	
    	//base case when the number
    	//passed in is nothing or empty
    	if(number == null || number.length() == 0){
    		//nothing being passed in, nothing to add
    		finalArray.add("");
    		//return the finalArray
    		return finalArray;
    	}
    
    	//character of first number being called
    	//might be getting an empty string
    	char numberPassed = number.charAt(0);
    	//String of possible letter
    	String numberLetters = getCode(numberPassed);
    	//length of string being passed in
    	int lettersLength = numberLetters.length();
    	

    	
    	//condition when the getCode method returns ""
    	//add nothing to the arrayList and
    	//continue going through the numbers
    	 if(numberLetters.equals("")){
			finalArray.add("");
			//recursion call to go through when empty
			return generateMnemonics(number.substring(1)); 
		}
    	
    	else{
    		//if the number letters is not an empty string
    		//go through the for loop to add to the arraylist
    		if(!numberLetters.equals("")){        
    			//getting the string length of the possible letters for that number
    			for(int index = 0; index < lettersLength; ++index){	
    				//creating the string for the character being created
    				//to add to the string of possible letters
    				String generatedCharacter =
    						Character.toString(numberLetters.charAt(index));
    				//if the lenght of the rest of the string is less than 1
    				if(number.substring(1).length() < 1){
    					//add that generated character to the array list
    					finalArray.add(generatedCharacter);
    				}
    				//if it is longer
    				else{
    					//call a for each loopthat has a recursive call
    					//for each generated string upon call of the method
    					//there is a call to the method with the following
    					//characters being passed in as the param
    					for(String generatedString: 
    						generateMnemonics(number.substring(1))){
    						//add to the character being created upon recursion
    						finalArray.add(generatedCharacter + generatedString);
    					}
    				}
    			}
    		}
    		
    		//recursion when the getCode method gives ""
        	//add nothing to the arrayList and
        	//continue going through the numbers
    		//by making a recursive call with the 
    		//next int in the param being passed in 
    		else{
    			finalArray.add("");
    			return generateMnemonics(number.substring(1));
    		}
    		//return the final arrayList with the additions
    		return finalArray;
    	}
 }
    
    
    //helper method provided
    //switch case
    private static String getCode(char A) {
      	 switch (A) {
      	 case '2':
      		 return "ABC";
      	 case '3':
      		 return "DEF";
      	 case '4':
      		 return "GHI";
      	 case '5':
      		 return "JKL";
      	 case '6':
      		 return "MNO";
      	 case '7':
      		 return "PQRS";
      	 case '8':
      		 return "TUV";
      	 case '9':
      		 return "WXYZ";
      	 default:
      		 return "";
    
      	 }
       }


    
    
    public static int collectCoins1D(int[] m) {
        return 0;
    }
      
    public static int collectCoins2D(int[][] board, int row, int col) {
    	return 0;
    	
    }

    private static int collectMaxCoinsHelp(int[] m, int start, int end) {
    	return 0;

    }

}