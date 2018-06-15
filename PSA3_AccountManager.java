import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: April 26, 2017 (Wednesday)
 * File: AccountManager.java
 * 
 * This file contains the accountManage class as well
 * as validation checks for accounts. Methods to check/
 * process/ validate transactions are here and 
 * the functions to create end of month statements
 * 
 * @author Christine
 */
public class AccountManager {

  // Used by the methods we provide for reading in the transactions
  // from a file.  You don't need to worry about this, and please
  // do not change it.
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  // The accounts managed by this AccountManager object.
  // This is public only to make grading your assignments easier.
  // It would be better design to make it private.
  public HashMap<String, CreditCard> accounts;

  /**
   * Construct a new, empty, AccountManager object.
   * To load accounts, use the loadAccounts method.
   */
  public AccountManager() {
    accounts = new HashMap<>();
  }

  /**
   * Uses Luhn's Algorithm to validate card numbers.
   *
   * @param cardNum Card number to validate
   * @return True if card number is valid, false otherwise.
   */
  public static boolean validateCardNumber(String cardNum){
	 // TODO for Part 2
	  
	 //Beginning checks 
	  if( cardNum == null || cardNum == ""){
		  return false;
	  }

	//Card number length
	    int cardNumLength = cardNum.length();
	  //Get the sum of digits
	    int sum = 0;
	  //Get the check digit
	    int checkDigit = Integer.parseInt((String.valueOf(cardNum.charAt(cardNumLength-1))));
	    
	    //extreme cases of checkdigits being 0 or 9
	    if (checkDigit == 0 || checkDigit == 9)
	    	return false;
	    
	  //Go through accountnumber in cardNum
	    for(int i = cardNumLength -2 ; i >= 0; i-= 2){
	    	
	    	//check if character is non numeric
	    	if (!Character.isDigit(cardNum.charAt(i)))
	    		return false;
	    	
	      //Get the digit at index
	      int digit = Integer.parseInt(String.valueOf(cardNum.charAt(i)));
	      
	      //Multiply every other digit by 2
	        digit*=2;
	        
	        //If double digits, subtract by 9 to get "added value"
		      if(digit > 9){
		        digit -= 9;
		      }
		      sum += digit;
	      }
	      
	    for(int i = cardNumLength -3 ; i >= 0; i-= 2){
	    	
	    	//check if character is non numeric
	    	if (!Character.isDigit(cardNum.charAt(i)))
	    		return false;
	    	
	    	 //Get the digit at index
		      int digit = Integer.parseInt(String.valueOf(cardNum.charAt(i)));
		      
	    	  sum+= digit;
	      }
	     
	    //Get final sum and multiply by 9
	    sum = sum*9;
	    sum = (sum%10);
	   

	    //If the check digit is equal to modified sum then return true
	    if(sum == checkDigit) return true;
	    else return false;
  }


  /**
   * TODO Explain this method in Part B
   */
  public ArrayList<String> loadAccounts(String filename) {
    ArrayList<String> invalid = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(filename))) {
      // Skip the header
      scanner.nextLine();

      // Read the credit card data
      while (scanner.hasNextLine()) {
        String[] data = scanner.nextLine().split(",");
        System.out.println("------------------------------------");
        String cardNumber = data[0];
        System.out.println("Card number: " + cardNumber);
        String accountHolder = data[1];
        System.out.println("Account holder: " + accountHolder);
        String bal = data[2];
        System.out.println("Balance: " + bal);
        double cardBalance = Double.parseDouble(bal);
        if (validateCardNumber(cardNumber)) {
          CreditCard card = new CreditCard(cardNumber, accountHolder);
          card.setCurrentBalance(cardBalance);
          accounts.put(cardNumber, card);
        } else {
          invalid.add(cardNumber);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Accounts file not found");
      e.printStackTrace();
    }

    System.out.println("------------------------------------");
    return invalid;
  }

  /**
   * Process a list of transactions from a file.
   * As each transaction is processed, the balance of the corresponding
   * credit card is adjusted if the transaction is allowed.  If the
   * transaction is not valid, the transaction is denied with the reason
   * for the denial.
   *
   * @param transactionsFile The name of the file where the transactions
   *                         are listed.
   * @return A list of denied Transactions, modified to indicate
   * why they were denied.
   */
  public ArrayList<Transaction>
  processTransactionsFromFile(String transactionsFile) {
    ArrayList<Transaction> transactions = readTransactionsFromFile(transactionsFile);
    return processTransactions(transactions);
  }

  /**
   * TODO Explain this method in Part B
   */
  private ArrayList<Transaction>
  processTransactions(ArrayList<Transaction> transactions) {
    // The transactions that are denied
    ArrayList<Transaction> denied = new ArrayList<>();
    for (Transaction t : transactions) {
      if (validateCardNumber(t.getCardNumber())) {
        // Get the card object corresponding to the card number
        CreditCard c = accounts.get(t.getCardNumber());
        if (!c.processTransaction(t)) {
          denied.add(t);
        }
      } else {
        t.denyTransaction("Invalid account number " + t.getCardNumber());
        denied.add(t);
      }
    }
    return denied;
  }

  /**
   * Read transactions from a file.
   *
   * YOU DO NOT NEED TO AND SHOULD NOT CHANGE THIS METHOD
   *
   * @param transactionsFilename Name of transactions data file
   * @return A list of transactions from the file.
   */
  private ArrayList<Transaction>
  readTransactionsFromFile(String transactionsFilename) {
    ArrayList<Transaction> transactions = new ArrayList<>();
    try { // Read data
      Scanner scanner = new Scanner(new File(transactionsFilename));

      // Use comma as the delimiter
      scanner.useDelimiter(",|\n");

      // Skip header
      scanner.nextLine();

      // Formatter to parse the date object
      DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

      while (scanner.hasNext()) {
        String transactionNumber = scanner.next();
        String cardNumber = scanner.next();
        Date date = dateFormat.parse(scanner.next());
        String vendor = scanner.next();
        double purchaseAmount = scanner.nextDouble();
        transactions.add(new Transaction(
            transactionNumber, cardNumber, date, vendor, purchaseAmount));
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("Could not read from transaction file");
    } catch (InputMismatchException e) {
      System.err.println("Purchase amount is not a double type");
      System.err.println("Skipping the rest of the file");
    } catch (ParseException e) {
      System.err.println("Bad date format: " + e.getMessage());
      System.err.println("Skipping the rest of the file");
    }
    return transactions;
  }

  /**
   * TODO Explain this method in Part B
   */
  public void generateStatements(String filename) {
    try {
      PrintWriter statements = new PrintWriter(new File(filename));
      statements.write("******************************************************\n");
      for (String cardNum : accounts.keySet()) {
        CreditCard card = accounts.get(cardNum);
        String statement = card.closeMonth();
        statements.write(statement);
        statements.write("******************************************************\n");
      }
      statements.flush();
      statements.close();
    } catch (IOException e) {
      System.err.println("There was a problem opening the statements file");
    }
  }

  /**
   * Implement the program described in PA3
   *
   * @param args The three command line arguments:
   *             The filename that contains the account information
   *             The filename that contains the transactions
   *             The filename where the account statements will be written
   */
  public static void main(String[] args) {
    // YOU DO NOT NEED TO CHANGE THIS METHOD.

    if (args.length < 3) {
      System.err.println("Invalid number of arguments");
      System.exit(1);
    }

    String creditCardsFilename = args[0];
    String transactionsFilename = args[1];
    String statementsFilename = args[2];

    AccountManager accountManager = new AccountManager();
    System.out.println("Loading accounts...");
    ArrayList<String> invalidAccounts =
        accountManager.loadAccounts(creditCardsFilename);

    if (invalidAccounts.size() > 0) {
      System.out.println("The following " + invalidAccounts.size() +
          " account numbers are invalid. No accounts created:");
      for (String acct : invalidAccounts) {
        System.out.println("\t" + acct);
      }
    }

    ArrayList<Transaction> denied =
        accountManager.processTransactionsFromFile(transactionsFilename);

    if (denied.size() > 0) {
      System.out.println("The following transactions were denied: ");
      for (Transaction t : denied) {
        System.out.println("-----------------------------------------------------");
        System.out.println(t.toString());
        System.out.println("Reason: " + t.getDenialReason());
      }
      System.out.println("-----------------------------------------------------");
    }

    System.out.println("Writing statements to " + statementsFilename + " ...");
    accountManager.generateStatements(statementsFilename);
  }
}
