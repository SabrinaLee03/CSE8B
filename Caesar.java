
/*
 * Name: Sabrina Lee A91066880
 * Login: CS8bsip
 * Date:  April 12, 2017 (Wednesday)
 * File:  Caesar.java 
 * 
*/


// Keep these two lines.  They are what tell Java to include the
// classes you need for working with files.
// You might get warnings about them at first.  That's OK, just
// ignore the warnings.  They should go away as you complete your code.
import java.io.*;
import java.util.*;

public class Caesar {
  // Complete the methods below.  Be sure to add header
  // comments for each. You may (and should) also write additional
  // helper methods.  Be sure to make the helper methods private and include
  // header comments for each.

  // Here are the basic style guidelines on which you will be graded:

  // Use proper indenting: Indent each block of code (e.g., method body,
  //   loop body.  Line up the lines in the block so that they are all
  //   indented to the same degree.  See examples of this in the book
  //   and in the code below.
  // Use descriptive variable names: The names of your variables should
  //   describe the data they hold.  Almost always, your variable names
  //   should be words (or abbreviations), not single letters.
  // Write short methods: Break your methods up into submethods if they
  //   are getting too complicated or long.  Generally your methods
  //   shouldn't get too much longer than about 20 lines of code (give or take)
  // Write short lines: Each line of code should be no longer than 80
  //   characters, so it can fit in a reasonable size window.  There's a
  //   column number in both vim and emacs.
  //
  // We'll start with these, as these are the most important.  We may add
  // to this list later in the term, but if you do all of the above you're
  // in good shape.

	
  public static String encrypt(String s, int rotation) {
    // TODO: Complete this method
    // letters are between 65 and 90 (Upper Case) and 97 and 122 (Lower Case)

	  //creating empty string to return the result with the new value
	  String result = "";
	 
	  //for loop to go through each letter of the string 
	for (int index = 0; index < s.length(); index++){
		
//get the character at the index of the string
		char original = s.charAt(index);
//letter operations function that does the rotation/ cypher of the message
		char rotatedChar = letterOperation(original, rotation);
			
			
			//concat new character value to the empty string
			result = result + rotatedChar;
		}
	
	
    return result;
  }

  
  
  public static String decrypt(String s, int rotation) {
    // TODO: Complete this method
  
	  //creating empty string to return the result with the new value
  String result = "";
 
	  //for loop to go through each letter of the string 
	for (int index = 0; index < s.length(); index++){
		
		//get the character at the index of the string
		char original = s.charAt(index);
		//making the negative rotation in the letter
		//operations in order to decrypt instead of encrypt
		int reverseRotate = rotation* -1;
		char rotatedChar = letterOperation(original, reverseRotate);
		
			
			
			//concat new character value to the empty string
			result = result + rotatedChar;
		}

    return result;
  }


  
//rotation of the cypher with the conditions to make sure the rotation
  //complies with the ASCII variables and how the resulting message 
  //will turn out through running the conditions here
  //(ex) if the variable is not a letter, negative rotation value
  //implementing different tests to make sure no errors occur
  private static char letterOperation(char a, int rotation) {
    // TODO: Complete this method
	 
    //creating a result character that will store what is being passed in
	  char result = '\0';
	
	 //turning the character into an int value
		int origValue = (int)a;
		
		//checking if the character is a letter
		if (Character.isLetter(a)){
			
			
			//if rotation is negative, might end with something out of the range when %
			//garuntee 0-25, giving some distance from a, but it will be more than 26 away
			//from a, adding the 65 threshold back for upper case
			rotation = rotation%26;
			rotation = (rotation+26) %26;
					
			//check if character is uppercase (65-90)
			//making the rotation when the character is an uppercase letter
			if (Character.isUpperCase(a)){
				origValue = Math.abs(((origValue - 65)+ rotation) % 26) +65;
				
			}
			
			// check if character is lowercase (97-122)
			//making the rotation when the character is a lowercase letter
			else if (Character.isLowerCase(a)){
				origValue = Math.abs(((origValue - 97)+ rotation) % 26) +97;
				
				
			}
			
			//concat new character value to the empty char holder 
			result = (char)(origValue);
		}
		
		//if character is not a letter
		else{
				result = (char)(origValue);
		}
	
		//returning the concatted result
    return result;
	  
  }


  //in order to make the method faster, using a string building to 
  //alter the string being passed in instead of making a new object
  //by scratch
  public static String encryptTwo(String s, int rotation) {
    // TODO: Complete this method
    // letters are between 65 and 90 (Upper Case) and 97 and 122 (Lower Case)
	  
	  //creating empty string to return the result with the new value
	  StringBuilder result = new StringBuilder();
	

	  //for loop to go through each letter of the string 
	for (int index = 0; index < s.length(); index++){
		
		//get the character at the index of the string
		char original = s.charAt(index);
		//running the letter operations method to make the rotation
		//on the string in the stringbuilder
		char rotatedChar = letterOperation(original, rotation);

			//changing the string s within the string builder
			result = result.append(rotatedChar);
			
		}
	
//returning the resulting string from the stringbuilder
    return result.toString();
  }

  
  //decrypt method with the same alterations to make the method faster
  public static String decryptTwo(String s, int rotation) {
    // TODO: Complete this method

	  //creating the string builder with a string
	  StringBuilder result = new StringBuilder();
	
	  //for loop to go through each letter of the string 
	for (int index = 0; index < s.length(); index++){
		
		//get the character at the index of the string
		char original = s.charAt(index);
		//int origValue =(int)original;
		
		//making the decryption method through turning the rotation into 
		//a negative and passing it through the letterOperations method
		int reverseRotate = rotation* -1;
		//running the letter operations method to make the rotation
		char rotatedChar = letterOperation(original, reverseRotate);
		

		//changing the string s within the string builder
		result = result.append(rotatedChar);
			
	}
	
//returning the resulting string within the string builder created
    return result.toString();

	  
  }
}
