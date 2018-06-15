// This class defines the methods necessary for an animal to be part of the simulation.
// Your critter animal classes 'extend' this class to add to its basic functionality.
//
/*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: Critter.java
 * 
 * 
 */
// YOU DON'T NEED TO EDIT THIS FILE FOR YOUR ASSIGNMENT.
//
import java.awt.*; // for Color

public abstract class Critter {
	// The following five methods are the ones you must implement for your assignment.
	// I'm not going to comment them because that's your job.

	//when the animal comes across food, calls this on
	//it to ask whether it wants to eat or not (true/ false)
	public boolean eat() {
		return false;
	}

	//when two animals of different species move onto the same square
	//when they collide, code calls this on each animal to ask
	//what kind of attack it wants
	public Attack fight(String opponent) {
		return Attack.FORFEIT;
	}

	//every time the board updates, calls this on the animal
	//to ask what color it wants to be drawn with 
	public Color getColor() {
		return Color.BLACK;
	}

	//every time the board updates, code calls this on the animal to 
	//ask which way it wants to move
	public Direction getMove() {
		return Direction.CENTER;
	}

	//everytime the board updates, calls this to ask
	//what letter it should be drawn as
	public String toString() {
		return "?";
	}


	// I use these fields to implement the methods below such as getX and getNeighbor.
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean alive = true;
	private boolean awake = true;
	private final String[] neighbors = {" ", " ", " ", " ", " "};

	// constants for directions
	public static enum Direction {
		NORTH, SOUTH, EAST, WEST, CENTER
	};

	// constants for fighting
	public static enum Attack {
		ROAR, POUNCE, SCRATCH, FORFEIT
	};

	// The following methods are provided to get information about the critter.
	// Technically the critter could call setXxxx() on itself,
	// but the game model ignores this anyway, so it's useless to do so.
	// These methods are declared 'final' so you can't override them.

	// Returns the height of the game simulation world.
	public final int getHeight() {
		return height;
	}

	// Returns the animal that is 1 square in the given direction away
	// from this animal.  A blank space, " ", signifies an empty square.
	public final String getNeighbor(Direction direction) {
		return neighbors[direction.ordinal()];
	}

	// Returns the width of the game simulation world.
	public final int getWidth() {
		return width;
	}

	// Returns this animal's current x-coordinate.
	public final int getX() {
		return x;
	}

	// Returns this animal's current y-coordinate.
	public final int getY() {
		return y;
	}
	
	// Returns true if this animal is currently alive.
	// This will return false if this animal has lost a fight and died.
	public final boolean isAlive() {
		return alive;
	}

	// Returns true if this animal is currently awake.
	// This will temporarily return false if this animal has eaten too much food
	// and fallen asleep.
	public final boolean isAwake() {
		return awake;
	}

	// Sets whether or not this animal is currently alive.
	// This method is called by the simulator and not by your animal itself.
	public final void setAlive(boolean alive) {
		this.alive = alive;
	}

	// Sets whether or not this animal is currently awake.
	// This method is called by the simulator and not by your animal itself.
	public final void setAwake(boolean awake) {
		this.awake = awake;
	}

	// Sets the height of the game simulation world to be the given value,
	// so that future calls to getHeight will return this value.
	// This method is called by the simulator and not by your animal itself.
	public final void setHeight(int height) {
		this.height = height;
	}

	// Sets the neighbor of this animal in the given direction to be the given value,
	// so that future calls to getNeighbor in that direction will return this value.
	// This method is called by the simulator and not by your animal itself.
	public final void setNeighbor(Direction direction, String value) {
		neighbors[direction.ordinal()] = value;
	}

	// Sets the width of the game simulation world to be the given value.
	// so that future calls to getWidth will return this value.
	// This method is called by the simulator and not by your animal itself.
	public final void setWidth(int width) {
		this.width = width;
	}

	// Sets this animal's memory of its x-coordinate to be the given value.
	// so that future calls to getX will return this value.
	// This method is called by the simulator and not by your animal itself.
	public final void setX(int x) {
		this.x = x;
	}

	// Sets this animal's memory of its y-coordinate to be the given value.
	// so that future calls to getY will return this value.
	// This method is called by the simulator and not by your animal itself.
	public final void setY(int y) {
		this.y = y;
	}

	// These methods are provided to inform you about the result of fights, sleeping, etc.
	// You can override these methods in your Husky to be informed of these events.

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
