
/*
 /*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 10, 2017 (Wednesday)
 * File: Board.java
 * Sources of Help: textbook, tutors
 *
 * Describe what the program does here:
 * This Class is used to construct a Board object to be used
 * for the simulation of the game 2048. It can create a fresh
 * board or load an already existing board. In addition this
 * class allows the user to save their current game to a new, 
 * specified file. The class also allows for the board to be 
 * rotated 90 degrees to the right or left. Baed on the direction
 * passed in by the user, this class will then move tiles
 * existing on the board in a certain direction, combining tiles
 * of the same value. The game is considered to be over when
 * the board cannot move in any direction.
 * /

//------------------------------------------------------------------//
// Board.java                                                       //
//                                                                  //
// Class used to represent a 2048 game board                        //
//                                                                  //
// Author:  W16-CSE8B-TA group                                      //
// Date:    1/17/16                                                 //
//------------------------------------------------------------------//

/**
 * Sample Board
 * <p/>
 * 0   1   2   3
 * 0   -   -   -   -
 * 1   -   -   -   -
 * 2   -   -   -   -
 * 3   -   -   -   -
 * <p/>
 * The sample board shows the index values for the columns and rows
 * Remember that you access a 2D array by first specifying the row
 * and then the column: grid[row][column]
 */

import java.util.Random;

public class Board {
    /**
     * Number of tiles showing when the game starts
     */
    public final int NUM_START_TILES = 2;

    /**
     * The probability (times 100) that a randomly
     * generated tile will be a 2 (vs a 4)
     */
    public final int TWO_PROBABILITY = 90;

    /**
     * The size of the grid
     */
    public final int GRID_SIZE;

    private int[][] grid;  // The grid of tile values
    private int score;     // The current score

    // You do not have to use these variables
    private final Random random;    // A random number generator (for testing)

    /**
     * Name: Board(Random random, int boardSize).
     * 
     * Purpose: The purpose of this method is to create or construct a fresh
     * board for the user with two random tiles places within the board. This
     * board will have a particular boardSize that the user sets, as well as a
     * random
     *
     * @param boardSize size of the 2048 game board to be used.
     * @param random    Random random represents the random number which 
     *                  be used to specific where (after every move) a 
     *                  new tile should be added to the board when playing.
     */
    public Board(Random random, int boardSize) {
        if (boardSize < 2) boardSize = 4;

        // initialize member variables
        this.random = random;
        this.GRID_SIZE = boardSize;
        this.grid = new int[boardSize][boardSize];
        this.score = 0;

        // loop through and add two initial tiles to the board randomly
        for (int index = 0; index < NUM_START_TILES; index++) {
            addRandomTile();
        }
    }


    /**
     * Constructor used to load boards for grading/testing
     * 
     * THIS IS USED FOR GRADING - DO NOT CHANGE IT
     *
     * @param random
     * @param inputBoard
     */
    public Board(Random random, int[][] inputBoard) {
        this.random = random;
        this.GRID_SIZE = inputBoard.length;
        this.grid = new int[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                this.grid[r][c] = inputBoard[r][c];
            }
        }
    }

    /**
     * return the tile value in a particular cell in the grid.
     *
     * @param row The row
     * @param col The column
     * @return The value of the tile at (row, col)
     */
    public int getTileValue(int row, int col) {
        return grid[row][col];
    }

    /**
     * Get the current score
     *
     * @return the current score of the game
     */
    public int getScore() {
        return score;
    }

    /**
     * Name: addRandomTile()
     * 
     * Purpose: The purpose of this method is to add a random tile of either
     * value 2 or 4 to a random empty space on the 2048
     * board. The place where this tile is added is dependent on the random
     * value associated with each board object. If no tiles are empty, it
     * returns without changing the board.
     */
    public void addRandomTile() {
        int count = 0;
        // loop through grid keeping count of every empty space on board
        for (int rowI = 0; rowI < grid.length; rowI++) {
            for (int colI = 0; colI < grid[rowI].length; colI++) {
                if (grid[rowI][colI] == 0) {
                    count++;
                }
            }
        }

        // if count is still 0 after loop, no empty spaces, return
        if (count == 0) {
            System.out.println("There are no empty spaces!");
            return;
        }

        // keep track of where on board random tile should be placed
        int location = random.nextInt(count);
        int value = random.nextInt(100);

        // reset count
        count = 0;
        // loop through grid checking where grid is 0 & incrementing count
        for (int rowI = 0; rowI < grid.length; rowI++) {
            for (int colI = 0; colI < grid[rowI].length; colI++) {
                if (grid[rowI][colI] == 0) {
                    // if count equals random location generated, place tile
                    if (count == location) {
                        System.out.println("Adding a tile to location " + rowI + ", " + colI);
                        if (value < TWO_PROBABILITY) {
                            grid[rowI][colI] = 2;
                        } else {
                            grid[rowI][colI] = 4;
                        }
                    }
                    count++;
                }
            }
        }
    }

    /**
     * Name: isGameOver()
     * <p>
     * Purpose: The purpose of this method is to check whether or not the game
     * in play is over. The game is officially over once there are no longer any
     * valid moves that can be made in any direction. If the game is over, this
     * method will return true and print the words: "Game Over!" This method
     * will be checked before any movement is ever made.
     *
     * @return true if the game is over, and false if the game isn't over
     */
    public boolean isGameOver() {
        return (!canMoveLeft() && !canMoveRight() && !canMoveUp()
                && !canMoveDown());
    }


    /**
     * Name: canMove(Direction direction)
     * 
     * Purpose: The purpose of this method is to check to see if the movement of
     * the tiles in any direction can actually take place. It does not move the
     * tiles, but at every index of the grid, checks to see if there is a tile
     * above, below, to the left or right that has the same value. If this is
     * the case, then that tile can be moved. It also checks if there is an
     * empty (0) tile at a specified index, as this also indicates that movement
     * can be possible. This method is called within move() so that that method
     * can determine whether or not tiles should be moved.
     *
     * @param direction direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    
    public boolean canMove(Direction direction) {
        // utilize helper methods to check if movement in a particular
        // direction is possible
    	if(direction == null)
    		return false;
    	
        switch (direction) {
            case UP:
                return canMoveUp();
            case RIGHT:
                return canMoveRight();
            case DOWN:
                return canMoveDown();
            case LEFT:
                return canMoveLeft();
            default:
                // If we got here, something went wrong, so return false
                return false;
        }
    }

    /**
     * Name: move(Direction direction)
     * 
     * Purpose: The purpose of this method is to move the tiles in the game
     * board by a specified direction passed in as a parameter. If the movement
     * cannot be done, the method returns false. If the movement can be done, it
     * moves the tiles and returns true. This method relies on the help of four
     * other helper methods to perform the game play.
     *
     * @param direction direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean move(Direction direction) {
        // if canMove is false, exit and don't move tiles
        if (!canMove(direction)) return false;

        // move in relationship to the direction passed in
        switch (direction) {
            case UP:
                moveUp();
                break;
            case RIGHT:
                moveRight();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            default:
                // This should never happen
                return false;
        }

        return true;
    }

    //TODO: You will implement the methods below this comment as described in
    // the PA writeup

    // TODO: Implement this method and add header comment
    //this method goes through the grid and shifts the tiles
    //to the right, either to the right most empty space
    //or adds them up when coming across equal tiles
    private void moveRight() { 
    	
    	//going through the entire grid by starting at the 
    	//top right of the grid   	
        for (int x = 0; x < GRID_SIZE; x++){
          for (int y = GRID_SIZE - 1; y > 0; y--){
            //go through columns (one ahead of the current one
        	//being traced)  
            for (int z = 1; z < y + 1; z++){
              //comparing tile being traced to the one ahead
              if (grid[x][y] == grid[x][y-z] && grid[x][y] != 0){
                //updating the alike tiles
                grid[x][y]*=2;
                //setting the previous to zero
                grid[x][y-z] = 0;
                //updating the score with new value
                score += grid[x][y];
                //updating the tile being traced to the next
                //column and running through the comparison
                y = z;
                //pop out of loop
               break;
              }
              //if the one being traced ahead is a non zero
              //go through to the next index
              else if (grid[x][y-z] != 0){
            	  //popping out of the loop
                break;
              }
            }
          }
          //staying in the same row, making a different check
          //going through the columns once again
          for (int y = GRID_SIZE - 1; y > 0; y--){
            //if the one being traced is a zero
        	//go through and find a non zero tile
            if (grid[x][y] == 0){
              //tracing through and finding a non zero
              for (int z = y - 1; z >= 0; z--){
                if(grid[x][z] != 0){
                	
                 //updating to the first non zero (found
                // in the trace)
                  grid[x][y] = grid[x][z];
                  //non zero tile found, set back to zero
                  //to simulate a shift in the board
                  grid[x][z] = 0;
                  //pop out of the loop
                  break;
                }
              }
            }
          }
        }
    }
    
    
    // TODO: Implement this method and add header comment
    //this method goes through the grid and shifts the tiles
    //to the left, either to the left most empty space
    //or adds them up when coming across equal tiles
   
  private void moveLeft() {

	//going through the entire grid by starting at the 
	//top left of the grid 
	 for(int x = 0; x < GRID_SIZE; x++){
			for(int y = 0; y < GRID_SIZE-1; y++){
				//tracing through the row one column ahead
				for(int z = y+1; z < GRID_SIZE - y; z++){
					//comparing if they are alike and the
					//current tile is non zero
					if(grid[x][y] == grid[x][z] && grid[x][y] != 0){
					  //if they are, update the non zero tile
					//that is currently being tracked and updating
					//to twice the amount
		              grid[x][y]*=2;
		              //updating the one being traced 
		             //to a zero to simulate a shift in the board
		              grid[x][z] = 0;
		              //updating the score board with the new tile added
		              score += grid[x][y];
		              //going to the next index in the same row
		              y = z;
		              //Pop out of loop
		              break;
					}
					else if(grid[x][z] != 0){
					//Pop out of loop to skip empty cell
						break;
					}
				}
			}

//within the same row, making a new check with the columns
			for(int y = 0; y < GRID_SIZE-1; y++){
				//if the one currently is a zero, go through
				//and look for a non zero within the same row
				if(grid[x][y] == 0){
					//finding the non zero
					for(int z = y+1; z < GRID_SIZE; z++){
						//found the non zero 
						if(grid[x][z] != 0){
							//changing the current tile being traced
							//to the new non zero tile
							grid[x][y] = grid[x][z];
							//simulating a shift in the tiles
							//by replacing the previous with a zero
							grid[x][z] = 0;
							//popping out of the loop
							break;
						}
					}
				}
			}
		}
    }
    
    
    // TODO: Implement this method and add header comment
    //this method goes through the grid and shifts the tiles
    //down, either to the bottom most empty space
    //or adds them up when coming across equal tiles
    private void moveDown() {
    //going through the grid	
    	
    	//going through the grid starting at the bottom right
        for (int y = 0; y < GRID_SIZE; y++){
            for (int x = GRID_SIZE - 1; x > 0; x--){  
            	//going through the grid on the opposite end
            	//starting from the bottom left (one index in)
              for (int z = 1; z < x + 1; z++){
            	 // comparing the current tile to the one
            	  //on the far left of the grid if they are alike
            	  //update the tiles
                if (grid[x][y] == grid[x-z][y] && grid[x][y] != 0){
                //current value being updated when adding
                  grid[x][y] *=2;
                  //simulate shift
                  grid[x-z][y] = 0;
                  //updating the score board
                  score += grid[x][y];
                  //going to the next index
                  x = z;
                  //pop out of the loop
                  break;
                }
                //if the one being traced is a non
                //zero, go to the next
                else if (grid[x-z][y] != 0){
                	//pop out of the for loop
                  break;
                }
              }
            }
            
            
            //within the same column, comparing the 
            //current one and finding a non zero
            for (int x = GRID_SIZE - 1; x > 0; x--){
            	//if the current tile is zero
              if (grid[x][y] == 0){
            	 //finding the non zero in the column
                for (int z = x-1; z >= 0; z--){
                	//once found the non zero
                  if(grid[z][y] != 0){
                	  //update the current tile to the non
                	  //zero
                    grid[x][y] = grid[z][y];
                    //updating the being traced
                    //to simulate a shift
                    grid[z][y] = 0;
                    //popping out of the loop
                    break;
                  }
                }
              }
            }
          }
    	}

    // TODO: Implement this method and add header comment
    //this method goes through the grid and shifts the tiles
    //up, either to the top most empty space
    //or adds them up when coming across equal tiles
    private void moveUp() {
    	//going through the entire grid by starting at the 
    	//top left of the grid 
    		  for(int y = 0; y < GRID_SIZE; y++){
    				for(int x = 0; x < GRID_SIZE-1; x++){
    					//tracing through column one ahead
    					for(int z = x+1; z < GRID_SIZE - x; z++){
    						//comparing if they are alike and the
    						//current tile is non zero
    						if(grid[x][y] == grid[z][y] && grid[x][y] != 0){
    						  //if they are, update the non zero tile
    						//that is currently being tracked and updating
    						//to twice the amount
    			              grid[x][y]*=2;
    			              //updating the one being traced 
    			             //to a zero to simulate a shift in the board
    			              grid[z][y] = 0;
    			              //updating the score board with the new tile added
    			              score += grid[x][y];
    			              //going to the next index in the same column
    			              x = z;
    			              //Pop out of loop
    			              break;
    						}
    						//checking if the one ahead is non zero
    						else if(grid[z][y] != 0){
    						//Pop out of loop to skip empty cell
    							break;
    						}
    					}
    				}

    	//within the same column, making a new check with the rows
    				for(int x = 0; x < GRID_SIZE-1; x++){
    					//if the one currently is a zero, go through
    					//and look for a non zero within the same row
    					if(grid[x][y] == 0){
    						//finding the non zero
    						for(int z = x+1; z < GRID_SIZE; z++){
    							//once found the non zero
    							if(grid[z][y] != 0){
    								//changing the current tile being traced
    								//to the new non zero tile
    								grid[x][y] = grid[z][y];
    								//simulating a shift in the tiles
    								//by replacing the previous with a zero
    								grid[z][y] = 0;
    								//popping out of the loop
    								break;
    							}
    						}
    					}
    				}
    			}
    } 	



    // TODO: Implement this method and add header comment
    //canMoveLeft() helper method, to check if the tiles
    //can move into an empty to the left or 
    //combine with a tile to the left that has the same value 
    private boolean canMoveLeft() {
    	//go row by row, check if there's an equal value
    	//to the right
    for(int x = 0; x < GRID_SIZE; x++){
    	for (int y=0; y < GRID_SIZE -1; y++){
    		
    		//check if to the right is equal without a 
    		//a value of zero
    		if(grid[x][y] == grid[x][y+1] &&
    				grid[x][y] !=0) return true;	
    	}	
    }
	
	//go row by row, check if there's an empty value
    // and a non-zero value to the right
    for(int x = 0; x < GRID_SIZE; x++){
    	for (int y=0; y < GRID_SIZE -1; y++){
		
    		//check if to the right is equal without a 
    		//a value of zero
    		if(grid[x][y] == 0 &&
    				grid[x][y+1] !=0) return true;
    	}
	}	

        return false;
    }
    

    // TODO: Implement this method and add header comment
    //canMoveRight() helper method, to check if the tiles
    //can move into an empty space to the right or 
    //combine with a tile to the right that has the same value 
    private boolean canMoveRight() {
    	//go row by row, check if there's an equal value
    	//to the left
    for(int x = 0; x < GRID_SIZE; x++){
    	for (int y=0; y < GRID_SIZE -1; y++){
    		
    		//check if to the left is equal without a 
    		//a value of zero
    		if(grid[x][y] == grid[x][y+1] &&
    				grid[x][y] !=0) 
    			return true;	
    	}	
    }
	
	//go row by row, check if there's an empty value 
    // and a non-zero value to the left
    for(int x = 0; x < GRID_SIZE; x++){
    	for (int y = GRID_SIZE-1; y > 0; y--){
		
		//check if to the left is equal without a 
		//a value of zero
    		if(grid[x][y] == 0 &&
    				grid[x][y-1] !=0) 
    			return true;	
    	}	
    }

        return false;
    }

    // TODO: Implement this method and add header comment
    //canMoveUp() helper method, to check if the tiles
    //can move into an empty space above or 
    //combine with a tile below that has the same value 
    private boolean canMoveUp() {
    	//go column by column, check if there's an equal value
    	//below
    for(int y = 0; y < GRID_SIZE; y++){
    	for (int x = 0; x < GRID_SIZE -1; x++){
    		
    		//check if the below is equal without a 
    		//a value of zero
    		if(grid[x][y] == grid[x+1][y] &&
    				grid[x][y] !=0) return true;	
    	}	
    }
	
	//go column by column, check if there's an empty value
    //and a non-zero value to the below
    for(int y = 0; y < GRID_SIZE; y++){
    	for (int x = GRID_SIZE -1; x > 0; x--){
		
		//check if below is equal without a 
		//a value of zero
    		if(grid[x][y] == 0 &&
    				grid[x-1][y] !=0) return true;
    	}
	}	

        return false;
    }

    // TODO: Implement this method and add header comment
    //canMoveDown() helper method, to check if the tiles
    //can move into an empty space below or 
    //combine with a tile below that has the same value 
    private boolean canMoveDown() {
    	//go column by column, check if there's an equal value
    	//above
    for(int y = 0; y < GRID_SIZE; y++){
    	for (int x = 0; x < GRID_SIZE -1; x++){
    		
    		//check if below is equal without a 
    		//a value of zero
    		if(grid[x][y] == grid[x+1][y] &&
    				grid[x][y] !=0) return true;	
    	}	
    }
	
	//go column by column, check if there's an empty value
    //below and a non-zero value to the below
    for(int y = 0; y < GRID_SIZE; y++){
    	for (int x = GRID_SIZE -1; x > 0; x--){
		
		//check if empty with a non zero value above
    		if(grid[x][y] == 0 &&
    				grid[x-1][y] !=0) return true;
    	}
	}	

        return false;
    }


    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", score));
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++)
                outputString.append(grid[row][column] == 0 ? "    -"
                        : String.format("%5d", grid[row][column]));

            outputString.append("\n");
        }
        return outputString.toString();
    }

    /**
     * Set the grid to a new value.  This method can be used for
     * testing and is used by our testing/grading script.
     * @param newGrid The values to set the grid to
     */
    public void setGrid(int[][] newGrid)
    {
        if (newGrid.length != GRID_SIZE ||
                newGrid[0].length != GRID_SIZE) {
            System.out.println("Attempt to set grid to incorrect size");
            return;
                }
        this.grid = new int[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = newGrid[r][c];
            }
        }
    }

    /**
     * get a copy of the grid
     * @return A copy of the grid
     */
    public int[][] getGrid()
    {
        int[][] gridCopy = new int[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++) {
                gridCopy[r][c] = grid[r][c];
            }
        }
        return gridCopy;
    }
}
