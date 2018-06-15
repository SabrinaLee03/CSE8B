import java.awt.Color;
import java.util.Random;


/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: Tiger.java
 * 
 * Description:
 * This file contains the overridden methods
 * for the critter Tiger. Deeper description in the README
 * file
 * -Fixed amount of food they can eat
 * -Either scratch or pounce
 * -Move randomly
 */

public class Tiger extends Critter{
		
		//setting empty variable to param passed in
		private int tigerHungry;
		//empty variable (hungry until hunger param)
		private int tigerEat;
		//and repeats generating random number
		private Random dir;
		//random number generator
		private int dirInt;
		//empty variable for movement
		private int tigerMove;
		//creating new string to display
		private String tigerCount;
		//empty direction
		private Direction tigerDirection;
		
		
		//constructor
		public Tiger(int hunger){
			//setting the empty variable to param 
			//being passed in
			this.tigerHungry = hunger;
			//setting tiger movement to nothing
			this.tigerMove = 0;
			//eaten count
			this.tigerEat = 0;
			//choose random direction
			//when new tiger is created
			//return either 0 1 2 3
			dir = new Random();
			dirInt = dir.nextInt(4);
			
			//set a direction to the random number generated
			if (dirInt == 0)
			tigerDirection = Direction.NORTH;
			if (dirInt == 1)
			tigerDirection = Direction.SOUTH;
			if (dirInt == 2)
			tigerDirection = Direction.EAST;
			if (dirInt == 3)
			tigerDirection = Direction.WEST;
	
		}
		
		//eating behavior (true if < hunger passed in)
		//else false
		public boolean eat() {
			if(this.tigerHungry > 0){
				//everytime it eats, it subtracts from
				//the hunger count until it reaches 0
				this.tigerHungry--;
				return true;
			}
			//once the hunger count being passed in 
			//hits zero, the tiger is no longer hungry
			else
			return false;
		}

		//determine fighting behavior
		//if eat == true, scratch
		//else pounce (do not call eat())
		public Attack fight(String opponent) {
			//if condition eat returns true
			//attach with scratch
			if(this.tigerEat < this.tigerHungry){
			return Attack.SCRATCH;		
			}	
			//if it is not hungry (else ==false)
			//attach with pounce
			else		
			return Attack.POUNCE;
		}

		//determine the color (yellow)
		public Color getColor() {
			return Color.YELLOW;
		}

		//moving behavior
		//changes a random direction
		public Direction getMove() {
			
			//move that random direction 3 times
			if(tigerMove < 3){
				tigerMove++;
				return tigerDirection;
			}
			
			//reset to 1
			tigerMove = 1;
			//create a random direction
			dirInt = dir.nextInt(4);
			
			//set a direction to random number 
			if (dirInt == 0)
			tigerDirection = Direction.NORTH;
			if (dirInt == 1)
			tigerDirection = Direction.SOUTH;
			if (dirInt == 2)
			tigerDirection = Direction.EAST;
			if (dirInt == 3)
			tigerDirection = Direction.WEST;
			
			//return the new direction that was assigned
			return tigerDirection;		
		}

		//determine string being displayed
		//number of pieces of food the tiger still 
		//wants to eat
		public String toString() {
			//creating a string to return that
			//displays how much it wants to eat
			this.tigerCount = 
					Integer.toString(this.tigerHungry-this.tigerEat);
			return tigerCount;
		}

	
}