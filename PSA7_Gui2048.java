import java.awt.event.*;

/*

 * @author Abena Bonsu, Liz Izhikevich and Christine Alvarado
 * @date April 18, 2017
 * 
 * 
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 24, 2017 (Wednesday)
 * File: Gui2048.java
 *
 * This program is used to construct a new GUI board game that can be
 * used in the game play of 2048. 
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;


//Gui that makes the gameBoard

public class Gui2048 extends Application {

    // Instance variables
    private GridPane pane;      // Pane to hold the game tiles
    private int GRID_SIZE = 4;  // Size of the board
    private Label scoreNum;     // The label with the score
    private Board board;        // Board object to run the game logic
    private boolean rotateBool; //rotate boolean to be passed in
    
    //private instance variable for the factory
    private GameTileFactory gtf = new GameTileFactory();
    
    /**
     * Name: start(Stage primaryStage)
     * 
     * Purpose: The purpose of this method is to construct the initial state of
     * the board using GUI. This method will be called on once, and so only
     * initializes the board to its beginning state.
     *
     * @param primaryStage the stage on which all the components
     *                     of the GUI will be drawn
     */
    
    public void start(Stage primaryStage) {
        // Set up all the GUI components
        setUpPane(primaryStage);

        // Initialize the game board
        board = new Board(new Random(), GRID_SIZE);

        // Set the GUI to reflect the state of the game board
        updateBoard();
    }

    /*
     * setUpPane()
     *
     * Purpose: The purpose of this method is to set up the board using a
     * GridPane object.
     *
     * Parameters: Stage primaryStage - the stage on which all the components of
     * the GUI will be drawn
     *
     * Return: None
     *
     */
    private void setUpPane(Stage primaryStage) {
        // Top level pane
        BorderPane topPane = new BorderPane();
        //creating an HBox so I can add two buttons to the
        //bottompPane
        HBox bottomPaneAdd = addHBox();

        // Place scene onto the stage and set stage dimensions
        Scene scene = new Scene(topPane);

        // Set primaryStage
        primaryStage.setTitle("Gui2048");
        primaryStage.setScene(scene);
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
         
        //setting the bottom panel to the HBox created
        topPane.setBottom(bottomPaneAdd);
        
        placeTitleBox(topPane);
        placeGameGrid(topPane);

        // Call for key actions
        scene.setOnKeyPressed(new MyKeyHandler());

        // display stage
        primaryStage.show();

    }

    //rotate and update the board method
    public void rotateAndUpdate(){
    	pane.getChildren().clear();
    	//passing in the boolean 
    	//rotate clockwise
    	board.rotate(rotateBool);
    	//update board
    	updateBoard();
    }

    //creating the HBox that handles the clicks 
    //for rotate clockwise and counterclockwise
    public HBox addHBox(){
    	//Creating a new HBox
    	HBox bottomPaneAdd = new HBox();
    	//setting the spacing for the box
    	bottomPaneAdd.setPadding(new Insets(20,20,20,20));
    	bottomPaneAdd.setSpacing(15);
    	
    	  //creating button for clockwise
        Button bClock = new Button("Rotate!Clockwise");
        //button handler
        bClock.setOnAction(new EventHandler<ActionEvent>() {
            @Override //override handle method
            public void handle(ActionEvent event) {
            	//make sure it rotates clock wise
            	rotateBool = true;
                rotateAndUpdate();
            }
        });
        //set the font of the button
        bClock.setStyle("-fx-font: 25 arial;");

        
        //creating button for counterclockwise
        Button bCounter = new Button("Rotate!Counterclockwise");
        //button handler
        bCounter.setOnAction(new EventHandler<ActionEvent>() {
            @Override //override handle method
            public void handle(ActionEvent event) {
            	//make sure it rotates counterclockwise
            	rotateBool = false;
                rotateAndUpdate();
            }
        });
        //set the font of the button
        bCounter.setStyle("-fx-font: 25 arial;");
        //setting the button to the bottom pane

        //adding the buttons to the hbox
    	bottomPaneAdd.getChildren().addAll(bClock, bCounter);
    	//returning the hbox for the bottompane of the gameboard
    	return bottomPaneAdd;
    }
    

    
    // Helper function to place the items into the title box at the top
    private void placeTitleBox(BorderPane topPane) {
        HBox titleBox = new HBox(150);
        HBox scoreBox = new HBox(10);

        // Add score header of the GUI back to pane
        Label score = new Label("Score: ");
        score.setFont(Font.font("Helvetica", FontWeight.BOLD,
                    FontPosture.ITALIC, 20));

        scoreNum = new Label("0");
        scoreNum.setFont(Font.font("Helvetica", FontWeight.BOLD,
                    FontPosture.ITALIC, 30));

        // Add Title of the GUI back to pane
        Label title = new Label("2048");
        title.setFont(Font.font("Helvetica", FontWeight.BOLD,
                    FontPosture.ITALIC, 35));

        scoreBox.setAlignment(Pos.CENTER_RIGHT);
        titleBox.setAlignment(Pos.CENTER);

        scoreBox.getChildren().addAll(score, scoreNum);
        titleBox.getChildren().addAll(title, scoreBox);

        topPane.setTop(titleBox);
    }

    // Set up the visual components of the game grid
    private void placeGameGrid(BorderPane topPane) {
        // Create the pane that will hold the board
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setStyle("-fx-background-color: rgb(187, 173, 160)");

        // Set the spacing between the Tiles
        pane.setHgap(10);
        pane.setVgap(10);

        topPane.setCenter(pane);
    }


    /*
     * Name: updateBoard()
     *
     * Purpose: The purpose of this method is to continually update the board's
     * tile values and the game score on the GUI.
     * This method will display the new board every time
     * a user clicks on one of the arrow buttons, which signals a move.  The
     * GUI is updated based on the values contained within the grid in
     * Board.java. For each move, the old values of the tiles are cleared, and a
     * new board is constructed based off of the values of the grid inside
     * Board.java.
     *
     * Parameters: none
     *
     */
    
    private void updateBoard() {
    	
    	// update the score
        scoreNum.setText("" + board.getScore());

        // Get rid of all of the current game tiles to make new ones
        pane.getChildren().clear();
        
        // Update board by reinitializing it to the grid
        for (int r = 0; r < board.GRID_SIZE; r++) {
            for (int c = 0; c < board.GRID_SIZE; c++) {
                // TODO: Create a new (custom) GameTile object with the
                // score value of the board's grid at location r, c
                // Then add this tile to the pane in the correct
                // location.  REMEMBER that pane.add takes the
                // column as the second argument and the row as the third

            //tileValue from the board grid
            int tileValue = board.getTileValue(r, c);
            	
            //new tile is created replaced with the factory code
            GameTile newTile = gtf.getTile(tileValue);
            
            //adding the tile to the pane (column, row)
            //update the tile being added to the Gui
            pane.add(newTile, c, r);	

            }
        }

        if (board.isGameOver()) {
            // If the game is over, display a new window stating this
            Stage gameOver = new Stage();
            Label gameOverLabel = new Label("GAME OVER");
            gameOverLabel.setFont(Font.font(
                        "Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 36));

            Scene gameOverScene = new Scene(gameOverLabel);
            gameOver.setScene(gameOverScene);
            gameOver.show();
        }
    }


    /**
     * MyKeyHandler is an inner class of the Board class to handle key events
     * and pass them to the Board object to make the appropriate move.
     *
     * @author Christine
     */
    class MyKeyHandler implements EventHandler<KeyEvent> {
        /*
         * Name: handle(KeyEvent e)
         *
         * Purpose: The purpose of this method is to handle the keys pressed by the
         * user of the game.
         *
         * Parameters: KeyEvent e - The key event that the user enters - in other
         * words the directional arrows that the user can choose, or the "Q" key for
         * quitting the game
         *
         * Return: void
         */
        public void handle(KeyEvent e) {

            Direction direction = null;

            // if user hits up arrow
            if (e.getCode() == KeyCode.UP) {
                direction = Direction.UP;
                System.out.println("Moving UP");
            }

            // if user hits down arrow
            else if (e.getCode() == KeyCode.DOWN) {
                System.out.println("Moving DOWN");
                direction = Direction.DOWN;
            }

            // If user hits left arrow
            else if (e.getCode() == KeyCode.LEFT) {
                System.out.println("Moving LEFT");
                direction = Direction.LEFT;
            }

            // If user hits right arrow
            else if (e.getCode() == KeyCode.RIGHT) {
                System.out.println("Moving RIGHT");
                direction = Direction.RIGHT;
            }

            if (board.canMove(direction)) {
                board.move(direction);
                board.addRandomTile();
                updateBoard();
            }

        }

    } // end of keyHandler Class


    /**
     * This main method is needed for running in eclipse
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

} // end of class
