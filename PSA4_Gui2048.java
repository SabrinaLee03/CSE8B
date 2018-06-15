	/*
	 * Name: Sabrina Lee A91066880
	 * Login:CS8bsip sal040@ucsd.edu
	 * Date: May 3, 2017 (Wednesday)
	 * File: Gui2048.java
	 * 
	 * This  holds all the GUI elements
	
	 *
	 * This program is used to construct a new GUI board game that can be
	 * used in the game play of 2048. 
	 */
	
	import javafx.application.*;
	import javafx.scene.control.*;
	import javafx.scene.*;
	import javafx.scene.paint.*;
	import javafx.scene.shape.*;
	import javafx.scene.layout.*;
	import javafx.stage.*;
	import javafx.event.*;
	import javafx.scene.input.*;
	import javafx.scene.text.*;
	import javafx.geometry.*;
	import java.util.*;
	import java.io.*;
	
	public class Gui2048 extends Application {
	
	
		// Main Instance variables
		private GridPane pane;
		private Text text;
		private Scene scene;
		private int GRID_SIZE = 5;
		private GameTile[][] cells;
	
		/*
		 * Name: start(Stage primaryStage)
		 *
		 * Purpose: The purpose of this method is to construct
		 * the inital state of the board using GUI. This
		 * method will be called on once, and so only initializes
		 * the board to its beginning state. 
		 *
		 * Parameters: Stage primaryStage - the stage on which
		 * all the components of the GUI will be drawn
		 *
		 * Return: void
		 */
		public void start(Stage primaryStage) {
	
			/* TODO: Answer Part 1 Questions about code in setUpPane */
	
			//set the foundation for the GUI
			setUpPane(primaryStage);
	
			
			/* Title for GUI
			 *
			 * Make a new label Object for the title
			 * Set the Font for the label
			 * Add the label to the pane
			 */
			
			//creating the header, setting font, size
			//and color, then adding it to the pane
			Label title = new Label("2048");
			title.setFont(Font.font("Helvetica", FontWeight.BOLD,
					FontPosture.ITALIC, 35));
			pane.add(title, 0, 0);
	
	
			/* TODO: Add score header
	
			 * Follow same procedure as title above
			 */
			
			//creating the score header by creating
			//a label, setting the font, size, and color
			//adding it to the pane
			Label scoreHeader = new Label("Score: ");
			scoreHeader.setFont(Font.font("Helvetica", FontWeight.BOLD,
					FontPosture.ITALIC, 30));
			pane.add(scoreHeader, 2, 0);
			
	
			/* TODO: Create a current score and place it on the board using placeScore
			 * You should always create a score of 0 */
			//creating an int score (start at zero)
			//calling the placeScore method to set the new score
			int currentScore = 0;
			placeScore(currentScore);
			
	
			/* Create a new 2D array to hold the GameTiles.
			 * Note: This is not technically needed for this assignment
			 * but we will need it in a future assignment.  Adding GameTiles
			 * to this array will NOT add them to the pane.  You need to do both
			 * in the makeGrid method.
			 */
			cells = new GameTile[GRID_SIZE][GRID_SIZE];
			
			/* TODO: Call the makeGrid method to populate the pane with tiles */
			makeGrid();
	
		}
	
		/* setUpPane()
		 *
		 * Purpose: The purpose of this method is to set up
		 * the board using a GridPane object.
		 *
		 * Parameters: Stage primaryStage - the stage on which
		 * all the components of the GUI will be drawn
		 *
		 * Return: None
		 *
		 */
		
		//creating the foundation for the GUI
		public void setUpPane(Stage primaryStage) {
	
			/******** Given Code ***********/
	
			// Create the pane that will hold all of the visual objects
			pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			pane.setStyle("-fx-background-color: rgb(187, 173, 160)");
	
			// Set the spacing between the Tiles
			pane.setHgap(10);
			pane.setVgap(10);
	
			// Place scene onto the stage and set stage dimensions
			scene = new Scene(pane);
	
			// Set primaryStage 
			primaryStage.setTitle("Gui2048");
			primaryStage.setScene(scene);
			primaryStage.setWidth(700);
			primaryStage.setHeight(700);
	
			//display stage
			primaryStage.show();
	
	
		}
	
		/* TODO: placeScore() 
		 *
		 * Purpose: The purpose of this method is to place the 
		 * current score on the game board to the right of the Score Header
		 * Hint: Use the code you wrote for "Score Header" to help you
		 *
		 * Parameters: int score
		 *
		 * Return: None
		 *
		 */
		
		//creating a new label for the current score
		//it takes in the score as a parameter, creates
		//a label with the size, font, and color
		//adds it to the pane
		public void placeScore(int score) {
			Label newScore = new Label(Integer.toString(score));
			newScore.setFont(Font.font("Helvetica", FontWeight.BOLD, 
					FontPosture.ITALIC, 30));
			pane.add(newScore,3,0);
			
		}
		
	
		/* TODO: makeGrid() 
		 *
		 * Purpose: Populate the grid (pane) with GameTile objects 
		 *
		 * Parametrs: None
		 *
		 * Return: None
		 */
		public void makeGrid() {
			/* TODO: Create a GameTile object for each position in the grid 
			 * and add that object to the pane in the proper location.
			 * 	Hint: You might find using a nested for-loop helpful
			 *
			 * Each loop iteration will need to:
			 *	Create a GameTile object for each tile with a tileValue (see below) 
			 *  Add this object to the 2D array of GameTiles, cells
			 *	Add the particular cell to the appropriate pane location 
			 *     (i.e., pane.add(....)
			 * 
			 * The tiles can have any values, as long as you have:
			 *   At least one tile with a 0 value (empty tile)
			 *   At least two tiles with two different non-zero legal values.
			 * You can use Java's Random  to choose values randomly from a list
			 * or you can make all the tiles in one row have the same value
			 * (e.g. first row has all 0s, second row has all 2s, third row has
			 * all 4s, etc), or each tile have a different legal value. 
			 * (e.g. 0, 2, 4, 8, 16, etc).  There are other possibilities.
			 * It's up to you.
			 * 
			 * NO MAGIC NUMBERS HERE.  Hint: Use the GRID_SIZE variable
			 * or the size of the cells array.
			 */
			
			
			//Array of possible tilevalues
			int tileValues[] = {0,2,4,8,16,32,64,128,256,512,
					1024,2048,4096,8192};
			
			//Random variable
			Random rand = new Random();
			
			//Looping through each position in the grid of 4x4
			for(int x = 0; x < GRID_SIZE-1; x++){
				//Col position of grid
				for(int y = 1; y < GRID_SIZE; y++){
			
				//Adding a zero value
					if(x==0 && y==0){
						GameTile tile = new 
								GameTile(tileValues[0]);
						//Add tile to Gametiles double array
						cells[x][y] = tile;
						//Add tile to board
						pane.add(tile, x, y);
					}
					
					
						//Create new GameTile object with randvalue from list
						GameTile tile = new 
								GameTile(tileValues[rand.nextInt(tileValues.length)]);
						//Add tile to Gametiles double array
						cells[x][y] = tile;
						//Add tile to board
						pane.add(tile, x, y);
					}			
				}

	}
		
		/**
		 * This main method is needed for running in eclipse
		 * @param args
		 */
		public static void main(String [] args)
		{
			Application.launch(args);
		}
	
	} //end of 
