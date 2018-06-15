import java.util.*;
/* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 24, 2017 (Wednesday)
 * File: GameTileFactory.java
 * 
 * This file extends to the customized Guis created
 * by other classmates
 */

public class GameTileFactory{
    private Random rand = new Random();
    
    // Modify this according to the number of custom tiles you wish to use
    private final int NUM_CUSTOM_TILES = 5;

    // use getTile method to get a random Tile
    public GameTile getTile(int value) {
        switch (rand.nextInt(NUM_CUSTOM_TILES)) {
            // Uses two students' custom tiles
            case 0: return new GameTileyokina(value);
            case 1: return new GameTiletnn050(value);
            case 2: return new GameTileajacosta(value);
            case 3: return new GameTilef9he(value);
            case 4: return new GameTilezes004(value);
       
            
            // You easily can add more tiles with an additional line of code
            // case 2: return new GameTileStudentThree(value);
            // case 3: return new GameTileStudentFour(value);
            default: return null;
        }
    }
}
