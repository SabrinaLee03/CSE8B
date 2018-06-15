/**
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: April 19, 2017 (Wednesday)
 * File: ElectionTester.java
 * 
 * The purpose of this file is to write a tester to verify the methods implemented 
 * in Part 2c. This file, makes sure that the methods created and passed in are fine.
 * This is checked through the algorithms created prior and making sure the outcome
 * passes what was suppose to be returned.
 */

/**
 * @author Sriram
 *
 */
import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.ArrayList;

public class ElectionTester {

	public static void main(String[] args) throws IOException {
		int passed_tests = 0;
		ElectionData elecSmall = new ElectionData();
		elecSmall.parseElectionFile("ElectionData2012And2016_smaller.csv");
		ElectionData elecBig = new ElectionData();
		elecBig.parseElectionFile("ElectionData2012And2016.csv");
		if (runTestMostLopSidedCounty(elecSmall))
			passed_tests++;
		if (runTestNumCountiesVotedForWinner(elecBig))
			passed_tests++;
		if (runTestMostThirdParty(elecSmall))
			passed_tests++;
		/*if (runTestSwitchedParties(elecSmall, elecBig))
			passed_tests++;*/
		if (passed_tests <= 2) {
			System.out.println("Only " + passed_tests + " methods are correctly implemented. "
					+ "You need to implement atleast 3 out of the 4 methods in the write up correctly "
					+ "to get full credit");
		} else {
			System.out.println(
					"You have passed all submission tests. Nevertheless, these tests are not complete and you must add your own test cases.");

		}

	}

	private static boolean runTestMostLopSidedCounty(ElectionData elec) {
		CountyElectionResult county = elec.mostLopsidedCounty("2012");
		if (county.getCounty().equals("District of Columbia") && county.getState().equals("DC")) {
			System.out.println("mostLopSidedCounty Test passes for valid input");
			county = elec.mostLopsidedCounty("2013");
			if (county == null) {
				System.out.println("mostLopSidedCounty Test passes for invalid input");
				return true;
			} else {
				
				
				System.out.println("mostLopSidedCounty Test fails for invalid input");
				return false;
			}
		}
		System.out.println("mostLopSidedCounty Test fails for valid input");
		return false;
	}

	private static boolean runTestNumCountiesVotedForWinner(ElectionData elec) {

		if ((elec.numCountiesVotedForWinner("CT", "2016") == 2)
				&& (elec.numCountiesVotedForWinner("CO", "2016") == 41)) {
			System.out.println("numCountiesVotedForWinner Test passes for valid input");
		} else {
			System.out.println("numCountiesVotedForWinner Test fails for valid input");
			return false;
		}
		if (elec.numCountiesVotedForWinner("CT", "20") != -1) {
			System.out.println(elec.numCountiesVotedForWinner("CT", "20"));
			System.out.println("numCountiesVotedForWinner Test fails for invalid input");
			return false;
		}
		System.out.println("numCountiesVotedForWinner Test passes for invalid input");
		return true;
	}

	private static boolean runTestMostThirdParty(ElectionData elec) {
		if (elec.mostThirdParty("2016").equals("ID") && elec.mostThirdParty("2012").equals("AK")) {
			System.out.println("mostThirdParty Test passes for valid input");
			if (!elec.mostThirdParty("2011").isEmpty()) {
				System.out.println("mostThirdParty Test fails for invalid input");
				return false;
			} else {
				System.out.println("mostThirdParty Test passes for invalid input");
				return true;
			}
		}
		System.out.println("mostThirdParty Test fails for valid input");
		return false;
	}

	/*private static boolean runTestSwitchedParties(ElectionData elec1, ElectionData elec2) {
		ArrayList<String> first = new ArrayList<>(asList("DE", "IA", "ME", "MI", "OH", "PA", "WI"));
		ArrayList<String> second = new ArrayList<>(asList("CO", "HI", "LA", "MD", "WY"));
		ArrayList<ArrayList<String>> result = elec1.switchedParties();
		boolean res1 = (isTwoArrayListsWithSameValues(first, result.get(0))
				&& isTwoArrayListsWithSameValues(second, result.get(1)));
		if (res1) {
			System.out.println("switchedParties() test passes for the ElectionData2012And2016_smaller file");
		} else {
			System.out.println("switchedParties() test fails for the ElectionData2012And2016_smaller");
		}
		first = new ArrayList<>(asList("FL", "IA", "MI", "OH", "PA", "WI"));
		second = new ArrayList<String>();
		result = elec2.switchedParties();
		boolean res2 = (isTwoArrayListsWithSameValues(first, result.get(0))
				&& isTwoArrayListsWithSameValues(second, result.get(1)));
		if (res2) {
			System.out.println("switchedParties() test passes for the ElectionData2012And2016");
		} else {
			System.out.println("switchedParties() test fails for the ElectionData2012And2016");
		}
		return res1 && res2;

	}*/

	private static boolean isTwoArrayListsWithSameValues(ArrayList<String> list1, 
			ArrayList<String> list2) {
		// null checking
		if (list1 == null && list2 == null)
			return true;
		if ((list1 == null && list2 != null) || (list1 != null && list2 == null))
			return false;

		if (list1.size() != list2.size())
			return false;
		for (String itemList1 : list1) {
			if (!list2.contains(itemList1))
				return false;
		}

		return true;
	}

}
