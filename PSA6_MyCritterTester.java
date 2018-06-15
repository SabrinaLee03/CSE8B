import java.awt.*;

/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: MyCritterTester.java
 * 
 * Description:
 * This file tests if all the functions in MyCritter are 
 * as they were meant to be
 * Test the fight methods mainly
 * Make sure it will win against the others
 * check if its black
 * check the name
 * check if it doesnt eat
 * 
 */

public class MyCritterTester {
	public String scoreLog = "";
	public String scoreInfo = "";
	public String folderName = "";

	
	private double myCalculateScore() {
		double score = 0;
		//calculating the end score after it passes the tests
		score += this.testBEAST();
		//creating the final score and using the fraction
		//to see if its correct
		scoreLog += "final score = " + score + "/10";
		if (score != 10) {
			scoreLog += scoreInfo;
		}
		return score;
	}

	private int testBEAST(){
		//starting score
		int score = 0;
		//boolean tester
		boolean critterTest = true;
		//create my critter
		MyCritter beast = new MyCritter();
		
		/////TEST FIGHT (4 tests)/////	
		//if it comes against a Bear, it should attack with roar
		//if it doesnt it changes the boolean to false
		if (!(Critter.Attack.ROAR == beast.fight("B"))) {
			critterTest = false;
		}
		//if it comes against a lion, it should scratch
		//if it doesnt, it changes the boolean to false
		if (!(Critter.Attack.SCRATCH == beast.fight("L"))) {
			critterTest = false;
		}
		//if it comes against a dragon, it should roar
		//if it doesnt, it changes the boolean to false
		if (!(Critter.Attack.ROAR == beast.fight("D"))) {
			critterTest = false;
		}
		//if it comes against a full tiger, it should scratch
		//if it doesnt, it changes the boolean to false
		if (!(Critter.Attack.SCRATCH == beast.fight("0"))) {
			critterTest = false;
		}
		
		/////TEST MOVE(1 test)/////
		//check if mycritter moves south
		if (!(Critter.Direction.SOUTH == beast.getMove())) {
			critterTest = false;
		}
		
		/////TEST EAT(1 test)/////
		//test if it has eaten when it comes across food
		if (!(true == beast.eat())) {
			critterTest = false;
		}
		
		/////TEST COLOR(1 test)/////
		//creates a new critter and gets the color
		//check if it is black
		MyCritter beast2 = new MyCritter();
		if (!(beast2.getColor()).equals(Color.BLACK))
			critterTest = false;

		/////TEST STRING(1 test)/////
		//name test, check if it returns BEAST
		if (!("BEAST" == beast.toString())) {
			critterTest = false;
		}
		
		////TEST FIGHTING WIN(2 tests)////
		//create my critter
		MyCritter beastFighter = new MyCritter();
		Bear bearLose = new Bear(critterTest);
		Lion lionLose = new Lion();
		
		//creates critters from other classes and tests the fight function
		//used against the Beast
		if (!(Critter.Attack.ROAR == beastFighter.fight(bearLose.toString()))) {
			critterTest = false;
		}
		
		if (!(Critter.Attack.SCRATCH  == beastFighter.fight(lionLose.toString()))) {
			critterTest = false;
		}


		if (critterTest) {
			score += 10;
			} else {
				System.out.println("----" + "fails a test" + "----");
			}
			
		return score;
	}
	
	
	public static void main(String[] args) {
		MyCritterTester myTest = new MyCritterTester();

		System.out.println("*********Begin Submission Script  PSA**************");
		double score = myTest.myCalculateScore();

		System.out.print("Score on this tester " + score + "/10\n");
		
		if (score != 10) {
			System.out.println(myTest.scoreInfo);
		System.out.println("Doesn't pass all tests");
		}
		System.out.println("*********End Submission Script  PSA**************");
	}
	
}
