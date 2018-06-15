 /* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: April 26, 2017 (Wednesday)
 * File: AccountManagerTester.java
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountManagerTester {

	// main function calls tester
	public static void main(String[] args) {
		testAccountManager();
	}

	private static void testAccountManager() {

		// Open test file
		File cardsFile = new File("cards_test.csv");
		Scanner scanner = null;

		try {
			scanner = new Scanner(cardsFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Skip header
		scanner.nextLine();

		// Extract first card number from line 2
		String line = scanner.nextLine();
		String[] lineFields = line.split(",");
		String cardNum = lineFields[0];

		// ******************** Test first number ******************** //
		try {
			System.out.print("TEST validadeCardNumber1: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (!valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should NOT be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract second card number from line 3
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test second number ******************** //
		try {
			System.out.print("TEST validadeCardNumber2: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract third card number from line 4
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test third number ******************** //
		try {
			System.out.print("TEST validadeCardNumber3: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract fourth card number from line 5
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test fourth number ******************** //
		try {
			System.out.print("TEST validadeCardNumber4: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (!valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should NOT be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract fifth card number from line 6
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test fifth number ******************** //
		try {
			System.out.print("TEST validadeCardNumber5: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (!valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should NOT be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

	
		scanner.close();
		
		// ******************** RANDOM TESTS1 ******************** //
		System.out.print("TEST RANDOM TEST ");
		String cardNumtest = "79927398713";
		boolean valid = AccountManager.validateCardNumber(cardNumtest);
		
		if (valid) {
			System.out.println(" PASSED!");
		}
		else {
			System.out.println(" FAILED - card number " + cardNumtest + " should be valid");
		}
		
		// ******************** RANDOM TESTS2 ******************** //
				System.out.print("TEST RANDOM TEST ");
				String cardNumtest2 = "799dasdf713";
				boolean valid2 = AccountManager.validateCardNumber(cardNumtest2);
				
				if (!valid2) {
					System.out.println(" PASSED!");
				}
				else {
					System.out.println(" FAILED - card number " + cardNumtest2 + " should be invalid");
				}
		
		
	}
		
		
		

}


