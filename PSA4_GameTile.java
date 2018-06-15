/*------------------------------------------------------------------//
//                                                   //
//                                                                  //
// GameTile class that is in charge of creating tiles for 2048     //
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 10, 2017 (Wednesday)
 * File: GameTile.java    
 * This class creates the individual tiles that
 will go on the board                                                   
//
//------------------------------------------------------------------*/

// You might need to import additional classes here.
// You might not use all of these classes.
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.*;

/**
  * A GameTile is a StackPane that groups together the 
  * visual items needed to display a 2048 tile.
  * 
  * We haven't talked about inheritance much yet, so 
  * the "extends" keyword might be a bit mysterious at this
  * point.  We'll help you through it in this assignment
  * and it will start to make much more sense over the next
  * few weeks.
  */
public class GameTile extends StackPane {
	
	private Text valueText;


	//Hashmap that uses tilevalue as the key to access appropriate color
	//Check out the populateColors method that populates the HashMap
	private static HashMap<Integer, Color> colors = 
			new HashMap<Integer, Color>();


	/* TODO: Fill in the constructor */
	public GameTile(int tileValue) {

		
		//calls the empty constructor
		super();
		

		/*TODO: Create one or more new Shape(s) to represent the tile 
		 * (it can be a Rectangle, a Circle, a combination, etc.  Get creative!)
		 *
		 * Don't forget to set the width and height of the object(s)
		 * 
		 * Set the color of the object(s) depending on the tile's value.
		 * You can use the colors HashMap to get the appropriate color.
		 * Remember you can change the colors in this HashMap, and you can 
		 * combine them with other colors to make a creative tile.  The
		 * only requirement is that each legal value in the game have a 
		 * different color or color scheme.  You need to handle illegal 
		 * values, but the color you choose for these illegal values is 
		 * up to you.
		 * 
		 * Remember that colors.get(tileValue) will return the Color
		 * associated with the value.
		 * 
		 */ 
		
		//Creating new rectangle object
		//setting width and height both to 130
		//calling the populateColors and displaying
		//the tileValue specific color
		Rectangle rectangleOne = new Rectangle();
		rectangleOne.setWidth(130);
		rectangleOne.setHeight(130);
		populateColors();
		rectangleOne.setFill(colors.get(tileValue));
		

		/* TODO: Create a Text object to display the value of the tile,
		 * if the tileValue is non-zero
		 * Don't forget to setText, setFont, and setFill
		 *
		 * The font type and color is up to you.  You might choose to vary it
		 * depending on the value of the tile, or you can just use a single
		 * color.
		 *
		 * If tileValue is 0,
		 * you do not need to create this text object.  I.e. it will be blank.
		 */
		
		//creating new text object
		valueText = new Text();
		//If the value is non zero
		//setting the text objects font/ size/ color
		if(tileValue != 0){
			valueText.setText(Integer.toString(tileValue));
			valueText.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
			valueText.setFill(Color.BLACK);
		}


		/* TODO: Finally, add tile shape(s) and value of tile to the calling
		 * object, which is a StackPane.  
		 * Hint: Look into the getChildren method of the StackPane/Pane class
		 * and remember that you are adding your objects to the calling object
		 * which is a StackPane. 
		 */
		
		//adding the tile created (both the rectangle and text object)
		this.getChildren().add(rectangleOne);
		this.getChildren().add(valueText);
		

	}

	/* Name: populateColors() 
	 *
	 * Purpose: The purpose of this method is to populate the HashMap
	 * with RGB values pertaining to certain tileValues. For example,
	 * the tileValue 2 has an RGB value of (238, 228, 218). Therefore,
	 * if we want to access the color of tileValue 2 from the hashmap,
	 * we would say colors.get(2) and it would return the color object
	 * Color.rgb(238, 228, 218).
	 *
	 * You are free to change the RGB values of each tileValue as you wish.
	 *
	 * Parameters: None
	 *
	 * Return: None
	 */
	public static void populateColors() {
		colors.put(0,Color.rgb(238, 228, 218, 0.35)); //empty tile
		colors.put(2, Color.rgb(238, 228, 218));
		colors.put(4, Color.rgb(237, 224, 200));
		colors.put(8,Color.rgb(242, 177, 121));
		colors.put(16, Color.rgb(245, 149, 99));
		colors.put(32,Color.rgb(246, 124, 95));
		colors.put(64,Color.rgb(246, 94, 59));
		colors.put(128,Color.rgb(237, 207, 114));
		colors.put(256,Color.rgb(237, 204, 97));
		colors.put(512,Color.rgb(237, 200, 80));
		colors.put(1024,Color.rgb(237, 197, 63));
		colors.put(2048,Color.rgb(237, 194, 46));
		colors.put(4096,Color.rgb(237, 194, 46));
		colors.put(8192,Color.rgb(237, 194, 46));

	}

	
	
}
