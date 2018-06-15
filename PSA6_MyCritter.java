import java.awt.Color;

//import Critter.Direction;

import java.awt.*;

/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: MyCritter.java
 * 
 * Description:
 * My critter created and overridden methods to 
 * beat the other critters in an environment
 * -beat opponents it comes across
 * bear(scratch) = roar
 * lion(pounce) = scratch
 * tiger(either roar(>scratch) when hungry =!0
 * scratch(>pounce) when not hungry =0
 * dragon (random)
 * 
 * 
 */


public class MyCritter extends Critter {
	

	//constructor
	public MyCritter (){
	}	
	
	//default color black
	public Color getColor(){
		return Color.BLACK;
	}
		
	//always hungry
	//when it eats, it falls asleep
	//override the sleep function
	public boolean eat(){
		return true;
	}
	
	//fighting pattern to beat the other animals
	public Attack fight(String opponent) {
		//beat a bear with roar (>scratch)
		if (opponent.equals("B")){
			return Attack.ROAR;
		}
		//beat a lion with scratch (>pounce)
		else if (opponent.equals("L")){
			return Attack.SCRATCH;
		}
		//beat dragon with one attack
		//probability better in mycritter favor
		//if not random
		else if (opponent.equals("D")){
			//more likely to play scratch
			//plays scratch if previous was
			//neither lion or bear
			//roar >scratch
			return Attack.ROAR;
		}
		//beat a tiger(depending on if its hungry)
		else{
			//scratch(>pounce) when not hungry =0
			if(opponent.equals("0")){
			return Attack.SCRATCH;
			}
			//tiger(either roar(>scratch) when hungry =!0
			else
			return Attack.ROAR;	
		}
	}
	
	
	//covers more ground if it just moves one way
	//gets the entirety of the board
	public Direction getMove() {
			return Direction.SOUTH;
	}
	
	//String displayed
	public String toString(){
		return "BEAST";
	}
	
	
	// called when you win a fight against another animal
	public void win() {}

	// called when you lose a fight against another animal, and die
	public void lose() {}

	// called when your animal is put to sleep for eating too much food
	public void sleep() {}

	// called when your animal wakes up from sleeping
	public void wakeup() {}

	// called when the game world is reset
	public void reset() {}
	
	// called when your critter mates with another critter
	public void mate() {}
	
	// called when your critter is done mating with another critter
	public void mateEnd() {}
	
	
}
