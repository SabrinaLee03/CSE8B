import java.awt.Color;

/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: Lion.java
 * 
 * Description:
 *This file contains the overridden methods
 * for the critter Lion. Deeper description in
 * the README file
 * -Gets hungry after they fight
 * -Either roar or pounce
 * -Move in circles
 * 
 */


public class Lion extends Critter{
		
		//start with empty variable on movement
		private int moveLion;
		//starting count at zero, lion hasnt eaten
		private int eatenLion;
		//at first the lion is not hungry, so it will
		//not return true until it has gone into a fight
		private boolean lionFight;
	
	
		//default constructor
		public Lion(){
			//setting count to no movement
			this.moveLion = 0;
			//hasnt eaten
			this.eatenLion = 0;
			//has not eaten yet
			this.lionFight = false;
		}
		
		//eating behavior (return true if lion has been in fight)
		//else false
		public boolean eat() {
			//check since the last time it ate
			//if the lion has eaten, fight
			if (this.eatenLion != 0 && this.lionFight == true){
				//reset count of eaten last
				this.eatenLion = 0;
				//reset to not fight
				this.lionFight = false;
			return true;	
			}
			
			else {
				this.eatenLion ++;
			return false;		
			}
		}

		//determine fighting behavior
		//if bear (roar) 
		//else pounce
		public Attack fight(String opponent) {
			//if it goes into this method, it fights
			//change the fight indicator boolean
			this.lionFight = true;
			//if opponent is a beat roar
			if(opponent.equals("B")){
				return Attack.ROAR;	
			}
			//anything else pounce
			else{
				return Attack.POUNCE;
			}
		}

		//determine the color (red)
		public Color getColor() {
			return Color.RED;
		}

		//moving behavior
		//move in clockwise (circles)
		//south 5, west 5, north 5, east 5
		public Direction getMove() {
			//first 5 spaces move south 0-4
			if (this.moveLion > 0 && 
				this.moveLion < 5){
				this.moveLion++;
				return Direction.SOUTH;
			}
			//second 5 spaces move west 5-9
			if(this.moveLion > 4 && 
				this.moveLion < 10){
				this.moveLion++;
				return Direction.WEST;
			}
			//third 5 spaces move north 10-14
			if(this.moveLion > 9 && 
					this.moveLion < 15){
				this.moveLion++;
				return Direction.NORTH;
			}
			//fourth 5 spaces of the circle east 15-19
			if(this.moveLion > 14 && 
					this.moveLion < 20){
				this.moveLion++;
				return Direction.EAST;
			}
			//reset back to south at 0 once it hits 21
			else{
				this.moveLion = 0;
				this.moveLion++;
				return Direction.SOUTH;
			}
		}

		//determine string being displayed (L)
		public String toString() {
			return "L";
		}
	
}