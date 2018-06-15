import java.awt.*;

/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: Bear.java
 * 
 * Description:
 * This file contains the overridden methods
 * for the critter Bear. Deeper description in the
 * README file
 * -Always hungry
 * -Scratch when fighting
 * -Either move south or east
 */

public class Bear extends Critter {
	
	//construct boolean default
	private boolean bearMove;
	//construct boolean default
	private boolean grizzlyColor;
	//brown color
	Color brown = new Color(190,110,50);

	
	//constructor with boolean param
	public Bear (boolean grizzly){
		//setting constructed boolean to whatever is
		//being passed in
		  this.grizzlyColor = grizzly;
		  //setting movement to nothing
		  this.bearMove = true;
	}	
	
	//determine color depending on 
	//if it is a grizzly or not
	public Color getColor(){
		//if it is a grizzly bear (grizzly==true)
		//turn bear brown
		if(this.grizzlyColor){
			return brown;	
		}
		//else it is a polar bear (white)
		else 
			return Color.WHITE;
	}
		
	//eating behavior(always hungry)
	public boolean eat(){
		return true;
	}
	
	//fighting behavior (scratch)
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
	
	
	//movement behavior (alternates between south and east)
	public Direction getMove() {
		if(this.bearMove == true){
			//alternate to moving east
			this.bearMove = false;
			//start with moving south
			return Direction.SOUTH;
		}
				
		else{
			//go back to original direction of south
			this.bearMove = true;
			return Direction.EAST;		
		}
	}
	
	//String displayed (B)
	public String toString(){
		return "B";
	}
	
	
}