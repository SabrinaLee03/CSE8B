/** 
 * TODO: Your file header comment here.
 * This file holds the created CreditCard class as well as constructors
 * for this class. It also creates a closeMonth statement
 * method to summarize the account information and transactions
 * for that account holder.
 */

import java.io.File;
import java.util.ArrayList;

/**
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: April 26, 2017 (Wednesday)
 * File: CreditCard.java
 * 
 * TODO: Your class header comment here.
 * A class to represent credit card objects and constructors
 * for the objects to be processed later
 * 
 * 
 */
public class CreditCard {

	// TODO: Implement this class as described in the PA3 writeup
	// Part 3A
	
	private String cardNumber; //account number associated with card
	private String accountHolder; //name of account holder
	private double creditLimit; //credit limit for the card
	private double currentBalance; //current balance on the card
	private double overDraft; //amount the account holder can charge 
							//above the credit limit
	private double rebate; //percent of monthly charges that get 
							//credited back at the end of the month
	private ArrayList<Transaction> transactionsList; //list of transactions
					//that have been made since last monthly statement
	
	public CreditCard(String cardNumber, String accHolder){
		this.cardNumber = cardNumber;
		this.accountHolder = accHolder;
		this.creditLimit = 5000.00;
		this.currentBalance = 0.00;
		this.overDraft = 1000.00;
		this.rebate = 0.02;
		transactionsList = new ArrayList<Transaction>();
	}
	
	public String getCardNumber(){
		return cardNumber;
	}
	
	public String getAccountHolder(){
		return accountHolder;
	}
	
	public double getCurrentBalance(){
		return currentBalance;
	}
	
	public ArrayList<Transaction> getCurrentTransactions(){
		return transactionsList;
	}
	
	public void setCurrentBalance(double amt) {
		currentBalance = amt;
	}
	
	public boolean processTransaction(Transaction t) {
		boolean result = false;
		
		
		if(!(t.getCardNumber().equals(cardNumber))){
			t.denyTransaction("Transaction attempted on incorrect"
					+ "account");
			result = false;
		}
		
		else if((currentBalance + t.getPurchaseAmount() + 
				overDraft) > creditLimit){
			t.denyTransaction("Credit limit reached");
			result = false;
		}
		
		else if (t == null || !t.isValid())
			result = false;
		
		else if (t.isValid()){
			currentBalance = currentBalance + t.getPurchaseAmount();
			transactionsList.add(t);
			result = true;
		}
		
		return result;
		
	}
	
	
	public String closeMonth(){
	
		String monthlyStatementString = new String();
		
		//current Transactions arrayList
		ArrayList<Transaction> currentTransactions = 
				getCurrentTransactions();
		
		double totalofTransactions = 0.00;
		for (int i = 0; i< currentTransactions.size(); i++){
			double purchaseAmount = 
				currentTransactions.get(i).getPurchaseAmount();
			totalofTransactions += purchaseAmount;
		}
		
	
		double newRebate = totalofTransactions*rebate;
		currentBalance = currentBalance - newRebate;
		
		
		//MONTHLY STATEMENT STRING
		//accountNumber
		int cardNumberFirstFour = cardNumber.length()-4;
		int cardNumberLast = cardNumber.length();
		String accntNumber = cardNumber.substring(cardNumberFirstFour, cardNumberLast);
		
		//print account holder and account number
		monthlyStatementString += "Account: " +accountHolder+ " " +accntNumber+"\n";
		//space
		monthlyStatementString += "-----------------------------------------------------\n";
		//summary of each transaction, separate by new line

		if (currentTransactions.size() == 0){
			monthlyStatementString += "NO TRANSACTIONS THIS MONTH\n";
		}
		
		else{
			for (int i = 0; i<currentTransactions.size(); i++){
				monthlyStatementString += "$"+ currentTransactions.get(i).getPurchaseAmount() + 
				" purchase at " + currentTransactions.get(i).getVendor()
				+ " with card ending in " +accntNumber+"\n";	
			}
			
		}
		
		//space
		monthlyStatementString += "-----------------------------------------------------\n";
		//rebate earned for this month
		monthlyStatementString += "Rebate Received: $" +newRebate+"\n";
		//balance after the rebate
		monthlyStatementString += "Current Balance: $" +currentBalance+"\n";
		
		//amount overDrawn
		
		if(currentBalance > creditLimit){
			double overDrawnAmount;
			overDrawnAmount = currentBalance - creditLimit;
			monthlyStatementString += "ACCOUNT OVERDRAWN BY: $" +overDrawnAmount+"\n";	
		}
		
		transactionsList.clear();

		return monthlyStatementString;
	}

	
	

	
	
	@Override
	public String toString() {
		// This method will work once you implement the other methods
		return this.getClass().getSimpleName() + " " +
				getCardNumber() + " " + getAccountHolder();
	}

}
