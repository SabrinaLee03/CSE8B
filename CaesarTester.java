
 /*
 * Name: Sabrina Lee A91066880
 * Login: CS8bsip
 * Date:  April 12, 2017 (Wednesday)
 * File:  CaesarTester.java 
 * 
 * Sources of Help: Textbook algorithms, tutor hours
 * ... (for example: names of people/tutors/students, books, 
 *                       websites, etc.) 
 *
 * Tests Caesar.java using basic strings and rotation values.
 * 
 *  Testing if the methods I made in the Caesar.java have any bugs
 *  or errors like the other file CaesarWithBugs.java
 *  doing all of the tests to make sure there are no out of bounds
 *  errors or rotational errors by going through the checks of the
 *  methods that were created.
 *
 */

/*
 * 
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTester {

  private static int testNum = 0;  // Keep track of which test we're running

  /**
   * Check the test case to see if it's correct
   * @param message The message to encrypt or decrypt
   * @param expectedAnswer The answer expected
   * @param actualAnswer The actual answer produced
   * @param enc_or_dec A string specifying what function was tested.
   * @return 1 if the test failed, and 0 otherwise.
   */
  public static int testCase(String message, String expectedAnswer, 
      String actualAnswer, String enc_or_dec) {
    testNum++;
    if (!expectedAnswer.equals(actualAnswer)) {
      System.out.println("Test " + testNum + " Failed (" + 
          enc_or_dec + ")");
      System.out.println("Given message to " + enc_or_dec + " is: " 
          + message);
      System.out.println("Your Answer is: " + actualAnswer);
      System.out.println("The correct answer is: " + expectedAnswer + "\n");
      return 1;
    } else {
      System.out.println("Test " + testNum + " Passed!\n");
      return 0;
    }
  }

  /*
   * Name:       main
   * Purpose:    To call methods in Caesar and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main(String[] args) {

    /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
     * FOR encrypt and decrypt methods AND ANY OTHER METHOD
     * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
     **/

    //The Caesar Cipher Tests
    int failCases = 0;

    String message1 = "When in the course of human events it becomes necessary for one people to" + 
      " dissolve the political bands which have connected them with another and to"+
      " assume among the powers of the earth the separate and equal station to"+
      " which the laws of nature and of nature's God entitle them a decent respect"+
      " to the opinions of mankind requires that they should declare the causes"+
      " which impel them to the separation.";

    String encryptedAnswer = "Nyve ze kyv tflijv fw yldre vmvekj zk svtfdvj evtvjjrip " +
      "wfi fev gvfgcv kf uzjjfcmv kyv gfczkztrc sreuj nyzty yrmv tfeevtkvu kyvd nzky refkyvi" + 
      " reu kf rjjldv rdfex kyv gfnvij fw kyv vriky kyv jvgrirkv reu vhlrc jkrkzfe kf nyzty " + 
      "kyv crnj fw erkliv reu fw erkliv'j Xfu vekzkcv kyvd r uvtvek ivjgvtk kf kyv fgzezfej fw" + 
      " drebzeu ivhlzivj kyrk kyvp jyflcu uvtcriv kyv trljvj nyzty zdgvc kyvd kf kyv jvgrirkzfe.";

    System.out.println("***** PART A TESTS ******\n");

    //Test 1
    String encrypted1 = Caesar.encrypt(message1, 17);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

    //Test 2
    String encrypted2 = "Byffi yhwlsjncih qilfx, byffi yhwlsjncih qilfx";
    String messageAnswer2 = "Hello encryption world, hello encryption world";
    String message2 = Caesar.decrypt(encrypted2, -58);
    failCases += testCase(encrypted2, messageAnswer2, message2, "decrypt");

    //Test 3
    String message3 = "menu";
    String encrypted3 = "ogpw";
    String encrypt3 = Caesar.encrypt(message3, 2);

    failCases += testCase(message3, encrypted3, encrypt3, "encrypt");    	

    //Test 4
    String message4 = "brian";
    String decrypt4 = "ukbtg";
    String decrypted4 = Caesar.decrypt(message4 , 7);

    failCases += testCase(message4, decrypt4, decrypted4, "decrypt");
    
    //Test 5
    String message5 = "SLOTH";
    String encrypted5 = "QJMRF";
    String encrypt5 = Caesar.encrypt(message5, -2);    

    failCases += testCase(message5, encrypted5, encrypt5, "encrypt");
    
    //Test 6
    String message6 = "SlOtH";
    String encrypted6 = "UnQvJ";
    String encrypt6 = Caesar.encrypt(message6, 2);    

    failCases += testCase(message6, encrypted6, encrypt6, "encrypt");
    

    
    System.out.println("\n***** PART B TESTS *******\n");		

    //Test 7
    encrypted1 = Caesar.encryptTwo(message1, 17);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encryptTWO");

    //Test 8
    message2 = Caesar.decryptTwo(encrypted2, -58);
    failCases += testCase(encrypted2, messageAnswer2, message2, "decryptTWO");
    
    //Test 9
    String message9 = "menu";
    String encryptd9 = "ogpw";
    String encrypt9 = Caesar.encryptTwo(message9, 2);

    failCases += testCase(message9, encryptd9, encrypt9, "encryptTWO");    	

    //Test 10
    String encrypted10 = "tluba";
    String mssageAnswer10 = "menut";
    String mesg2 = Caesar.decryptTwo(encrypted10 , 7);

    failCases += testCase(encrypted10, mssageAnswer10, mesg2, "decryptTWO");
    
    //Test 11
    String messge11 = "SLOTH";
    String encrypted11 = "QJMRF";
    String encrypt11 = Caesar.encryptTwo(messge11, -2);    

    failCases += testCase(messge11, encrypted11, encrypt11, "encryptTWO");
    
    //Test 12
    String mssage12 = "SlOtH";
    String encrypted12 = "UnQvJ";
    String encrypt12 = Caesar.encryptTwo(mssage12, 2);    

    failCases += testCase(mssage12, encrypted12, encrypt12, "encryptTWO");
    

    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("Number of Failed Test Cases : " + failCases);
    }
  }
}
