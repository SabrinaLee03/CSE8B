/**
 * Name: Sabrina Lee A91066880
 * Login: CS8bsip
 * Date:  April 12, 2017 (Wednesday)
 * File:  Part2Tester.java 
 * 
 * 
 * Document this file. Class Headers, Method Headers, 
 * in-line comments, and all style guidelines.
 * 
 * This tester file is being used to expose the bugs in the CaesarwithBugs class.
 * There are rotation errors, negative number errors, large int errors,
 * out of bounds of the ASCII variables, and other bugs that were found
 * through the testers that I made.  
 * There may be more bugs in the CaesarwithBugs class but I did my best
 * to find at least 5 errors.
 * 
 */

public class Part2Tester {

  private static int testNum = 0;

  /**
   * 
   * Check the test case to see if it's correct
   * @param message The message to encrypt or decrypt
   * @param expectedAnswer The answer expected
   * @param actualAnswer The actual answer produced
   * @param enc_or_dec A string specifying what function was tested.
   * @return 1 if the test failed, and 0 otherwise.
   * 
   *
   */

  //printing the message when running the tests
  public static int testCase(String message, String expectedAnswer, 
      String actualAnswer, String enc_or_dec) {
    testNum++;
    if (!expectedAnswer.equals(actualAnswer)) {
      System.out.println("Test " + testNum + " Failed (" + 
          enc_or_dec + ")");
      System.out.println("Given message to " + enc_or_dec + " is: " 
          + message);
      System.out.println("Your Answer is: " + actualAnswer);
      System.out.println("The correct answer is: " + expectedAnswer);
      return 1;
    } else {
      System.out.println("Test " + testNum + " Passed!\n");
      return 0;
    }
  }

  /**
   * The main method to test the Caesar class.
   * @param args Unused
   */
  public static void main (String[] args) {

    /** The main method. THIS IS WHERE YOU SHOULD ADD TESTS TO FIND
     * THE ERRORS IN CeasarWithBugs.  We have a few tests, but they 
     * do not expose the errors.
     **/

    //The Caesar Cipher With Bugs Tests
    int failCases = 0;

    //Test 1
    String message1 = "menu";
    String encryptedAnswer = "ogpw";
    String encrypted1 = CaesarWithBugs.encrypt(message1, 2);

    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");    	

    //Test 2
    String encrypted2 = "tlub";
    String messageAnswer = "menu";
    String message2 = CaesarWithBugs.decrypt(encrypted2, 7);

    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");
    
    //Test 3
    String message3 = "bang";
    String encryptedAnswer3 = "zyle";
    String encrypted3 = CaesarWithBugs.encrypt(message3, -2);    

    failCases += testCase(message3, encryptedAnswer3, encrypted3, "encrypt"); 

    //Test 4
    String encrypted4 = "#fvurfnv!$%";
    String messageAnswer4 = "#csrocks!$%";
    String message4 = CaesarWithBugs.decrypt(encrypted4, 3);

    failCases += testCase(encrypted4, messageAnswer4, message4, "decrypt");
    
    //Test 5
    String message5 = "sloth";
    String encryptedAnswer5 = "lehma";
    String encrypted5 = CaesarWithBugs.encrypt(message5, 123);    

    failCases += testCase(message5, encryptedAnswer5, encrypted5, "encrypt");
    
    //Test 6
    String message6 = "coffee";
    String decryptedAnswer6 = "friihh";
    String decrypted6 = CaesarWithBugs.decrypt(message6, -3);    

    failCases += testCase(message6, decryptedAnswer6, decrypted6, "decrypt");
    
    //Test 7
    String message7 = "SLOTH";
    String encryptedAnswer7 = "UNQVJ";
    String encrypted7 = CaesarWithBugs.encrypt(message7, 2);    

    failCases += testCase(message7, encryptedAnswer7, encrypted7, "encrypt");
    
    //Test 8
    String message8 = "SLOTH";
    String encryptedAnswer8 = "QJMRF";
    String encrypted8 = CaesarWithBugs.encrypt(message8, -2);    

    failCases += testCase(message8, encryptedAnswer8, encrypted8, "encrypt");
    
    //Test 9
    String message9 = "SlOtH";
    String encryptedAnswer9 = "UnQvJ";
    String encrypted9 = CaesarWithBugs.encrypt(message9, 2);    

    failCases += testCase(message9, encryptedAnswer9, encrypted9, "encrypt");
    
    //Test 10
    String message10 = "zeta";
    String decryptedAnswer10 = "bgvc";
    String decrypted10 = CaesarWithBugs.decrypt(message10, -2);    

    failCases += testCase(message10, decryptedAnswer10, decrypted10, "decrypt");
    
    //Test 11
    String message11 = "12345";
    String encryptedAnswer11 = "12345";
    String encrypted11 = CaesarWithBugs.encrypt(message11, 222);    

    failCases += testCase(message11, encryptedAnswer11, encrypted11, "encrypt");
    
    //Test 12
    String message12 = "Zeta";
    String decryptedAnswer12 = "Bgvc";
    String decrypted12 = CaesarWithBugs.decrypt(message12, -2);    

    failCases += testCase(message12, decryptedAnswer12, decrypted12, "decrypt");
    
    //Test 13
    String message13 = "sloth";
    String encryptedAnswer13 = "zsvao";
    String encrypted13 = CaesarWithBugs.encrypt(message13, -123);    

    failCases += testCase(message13, encryptedAnswer13, encrypted13, "encrypt");
    
    
    // TODO Add your tests here.  Some ideas: negative numbers, 
    // non-numeric characters, large values for rotation, etc.  
    // (There are more things to test.)


    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("Number of Failed Test Cases : " + failCases);
    }
  }
}
