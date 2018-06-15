/* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 31, 2017 (Wednesday)
 * File: WarmupRecursion.java
 */
/**
 * File: WarmupRecursion.java
 * Author: Gustavo Umbelino and TODO add your name(s)!
 * Date: 5/24/2017
 * Description: TODO describe this class!
 */



import java.util.ArrayList;
import java.util.Random;

public class WarmupRecursion {

    /**
     * TODO
     *should return the binary representation of the
     *non-negative decimal number n as a String
     *
     *example binaryString(6) returns 110
     *assume n is non-negative (>=0)
     *
     * @param n
     * @return
     */
	
	//pass in an integer to turn into a string of the binary value
    public static String binaryString(int n) {
    	//empty string
    	String result = "";
    	//base case when its done recursing
    	//or if the param is a zero
    	if(n == 0){
    		//return the resulting string
    		return result;
    	}
    	else{
    		//recursion: passing the modified (n/2) method
    		//adding to the return least significant number
    		//right most value
    		return binaryString(n/2) + Integer.toString(n%2);
    	}
    }

    /**
     * TODO
     *input a String containing 0 or more digits and returns a string
     *which is a legal nemonic for that string of digits
     *(not really a word), chosen at random
     *
     *example generateRandomMnemonic("723") return PAD, QBF, QAE
     *if empty or null, return an empty string
     * @param digits
     * @return
     */
    
public static String generateRandomMnemonic(String digits) {
    	
    	//empty string
    	String result = "";
    	//anothere character holder
        String digitToRandChar = "";
    	//random generator
    	Random rand = new Random();
    	//Random number
    	int randNum = rand.nextInt(3);
 
    	
    	//base case, if string is empty or null
    	//returns an empty string
    	if (digits == "" || digits == null){
    		return result;            
    	}
    	else{
    	//first check if there is only one string
    	//return a random character from the help method
    		if(digits.length() == 1){
                if(getCode(digits.charAt(0)).equals("")){
                    return "";
                }
    			return Character.toString(getCode(digits.charAt(0)).charAt(randNum));	
    		}
    		
    		else{

    			//if longer, use a substring to alter the digits
    			//going through the digits passed in
                String generatedString = generateRandomMnemonic(digits.substring(1));
                //set the empty string to the first random digit's letter
                String translatedDigit = getCode(digits.charAt(0));
                //if its not an empty string (anything other than 2-9)
                if (!translatedDigit.equals("")) {
                	//setting the translated character string 
                    digitToRandChar = Character.toString(translatedDigit.charAt(randNum));
                }
                //continually adding the new characters
                return digitToRandChar + generatedString;
    		}
    	}
    }

    //helper method provided
    //swtich case
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

    

    /**
     * TODO
     *takes an ArrayList of integers, and a targetNumber 
     *determines if there is a subset of those integers
     *that sum to that targetNumber
     *
     *example {3,7,1,8,-3} and the target sum is 4
     *result is true because {3,1} sums to 4. but if
     *the target was 2, it would reutnr false
     * @param set
     * @param targetNumber
     * @return
     */
    public static boolean isSubSetSum(ArrayList<Integer> set, int targetNumber) {
    	//int holder
    	int firstInt = 0;


    	//base case when the targetNumber is 0
    	//if target number is 0, empty set is a subset
    	//of every set including itself
    	if (targetNumber == 0){
    		return true;
    	}
    	//if set is empty, no elements to look at
    	//set as the base case
    	//if it goes through the recursion calls and
    	//it does not come out to 0, it returns false
    	else if(set.size() == 0 &&
    			targetNumber != 0){
    		return false;
    	}
    	
    	//first recursion: update targetNumber
    	//if first element is in the subset
    	else{

    		//if updated targetNumber minus the next int 
        	//is equal to zero, the return true, if anything 
        	//else return false
        	return false; 			

    	}
    
    }
    
      
    
}
