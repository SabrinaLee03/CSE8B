import java.awt.Color;
import java.util.Random;

/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: Dragon.java
 * 
 * Description:
 *This file contains the overridden methods
 * for the critter Dragon
 * -Color changers depending on what they eat
 * -Base their attack on attack history 
 */

public class Dragon extends Critter {

	//random number generator to produce random attack
	private Random attackRand = new Random();
	//attack int created
	private int attackNum;
	//food count variable
	private int dragonEaten;
	//number of attacks;
	private int numberAttacks;
	//empty string for opponent track
	private String dragonOpponent ="";
	//empty attack variable for the beginning
	private Attack dragonAttack;
	//empty direction variable
	private Direction dragonDirection;
	//movement count
	private int dragonMove;
	
	
	
	//constructor with random attack
	public Dragon(){
		//setting eaten to non
		this.dragonEaten = 0;
		//setting attacks to none
		this.numberAttacks = 0;
		//creating random attack
		attackNum = attackRand.nextInt(3);
		
		if(attackNum == 0)
			this.dragonAttack = Attack.ROAR;
		if(attackNum == 1)
			this.dragonAttack = Attack.POUNCE;
		if(attackNum == 2)
			this.dragonAttack = Attack.SCRATCH;
		
		//initial direction is west
		dragonDirection = Direction.WEST;
		//movement is nothing at first
		dragonMove = 0;
		
	}
	
	//eating behavior (always true)
	public boolean eat() {
		dragonEaten++;
		return true;
	}

	//determine fighting behavior from previous opp
	//choose random attack when initialized
	public Attack fight(String opponent) {
		//number of fights
		this.numberAttacks++;
		
		//store the opponent and return the first
		//random attack that was made
		if(this.numberAttacks == 0){
			this.dragonOpponent = opponent;
			return this.dragonAttack;
		}
		
		//if the previous opponent was a bear
		//attack with roar, store the opponent
		if(this.dragonOpponent.equals("B")){
			this.dragonOpponent = opponent;
			return Attack.ROAR;
		}
		
		//if the previous opponent was a lion
		//attack with a pounce, store the opponent
		if(this.dragonOpponent.equals("L")){
			this.dragonOpponent = opponent;
			return Attack.POUNCE;
		}
		
		//store the opponent and attack with a scratch
		//if neither bear or lion
		else{
			this.dragonOpponent = opponent;
			return Attack.SCRATCH;
		}
	}

	//determine the color
	//will change color depending on the food it consumes
	//even number of foods (black)
	//odd number of foods (white)
	public Color getColor() {
		//even number of food storage
		if(this.dragonEaten%2 == 0){
		return Color.BLACK;
		}
		
		else{
		return Color.WHITE;
		}
	}

	//moving behavior
	//initial direction West
	//after moves in zigzag shape (10)
	//counter clockwise direction
	public Direction getMove() {
		
		//initial move is west, continue
		if(dragonMove == 0){
			dragonMove++;
			return dragonDirection;
		}
		//move south every other
		//first quarter of the movement
		else if (dragonMove%2 == 1 &&
				//diameter is 5
				dragonMove < 10){
			dragonDirection = Direction.SOUTH;
			dragonMove++;
			return dragonDirection;
		}
		//initial and move west every other 
		else if (dragonMove%2 ==0 &&
				dragonMove < 10){
			dragonDirection = Direction.WEST;
			dragonMove++;
			return dragonDirection;
		}
		//move east every other
		//change the quarter of the movement
		else if (dragonMove%2 == 1 &&
				dragonMove < 20){
			dragonDirection = Direction.EAST;
			dragonMove++;
			return dragonDirection;
		}
		//move south every other
		else if (dragonMove%2 ==0 &&
				dragonMove < 20){
			dragonDirection = Direction.SOUTH;
			dragonMove++;
			return dragonDirection;
		}
		
		//move north every other
		//change quarter of the movement
		else if (dragonMove%2 == 1 &&
				dragonMove < 30){
			dragonDirection = Direction.NORTH;
			dragonMove++;
			return dragonDirection;
		}
		//move east every other
		else if (dragonMove%2 ==0 &&
				dragonMove < 30){
			dragonDirection = Direction.EAST;
			dragonMove++;
			return dragonDirection;
		}
		//move west every other
		//change quarter of movement
		else if (dragonMove%2 == 1 &&
				dragonMove < 40){
			dragonDirection = Direction.WEST;
			dragonMove++;
			return dragonDirection;
		}
		//move north every other
		else if (dragonMove%2 == 0 &&
				dragonMove < 40){
			dragonDirection = Direction.NORTH;
			dragonMove++;
			return dragonDirection;
		}
		//at the last (dragonMove = 40)
		//go west as if it were 1 and reset the
		//cycle by starting again at 1
		else{
			dragonDirection = Direction.WEST;
			dragonMove = 1;
			return dragonDirection;	
		}
		
	}	

	//determine string being displayed (D)
	public String toString() {
		return "D";
	}
	
	
	
	
}