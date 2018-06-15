 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 10, 2017 (Wednesday)
 * File: README.md



PART 1: Answer the questions
GUI2048.java Questions
1.) Explain the role of the MyKeyHandler class. 
What does it do, and how does it enable the game state 
to change based on the user’s actions?  
(Hint: we will talk about this in class in Week 5)

The role of the MyKeyHandler class is to take in the keys
pressed by the user and pass them onto the Board to make the
board object move as desired. It implements the EventHandler
hashmap that contains the KeyEvents. It takes in the key event
as a parameter and matches the code of the key event to 
the events of up, down, left, or right. It enables the game 
state to change the base by changing the direction to the
key event passed in. The EventHandler hashmap matches the
key being passed in and calls the getCode() method to run
the desired change in direction base.


2.) Draw a picture of the GUI including the panes that 
are holding each of the components.  
Make it clear what panes are in the GUI and how the
components are organized inside each other.

*** DRAW PICTURE


3.) How does the GUI display the updated score of the game?
From the helper function of placeTitleBox, this takes
the items made (title, score, and default score) and
places them into the title box at the top which is displayed
in the beginning.
After every move, the old tile values are cleared and
the score is updated. The updatedBaord() references 
the Board.java and runs the getScore() method in order
to keep an updated version of the score everytime the player 
makes a move.
It will reveal a new board everytime a user makes an actions
(up, down, left, or right). The score on the GUI is updated
based on the values that appear on the tiles in the Board.java.
A new board is constructed from the values on the grid 
and the old tile values are cleared after every move.



Board.java Questions:
1.) Find two methods that call the canMoveLeft(),
canMoveRight(), canMoveUp() and canMoveDown() helper methods, 
and explain what those methods do.

public boolean canMove(Direction direction)
The purpose of this method is to check 
if the movement being passed in is acceptable. This method
does not move the tiles, but it checks each index of the grid
to see if there is the same value above, below, to the right, or
to the left. If it is, then the tile can move. There is also a 
zero value check that takes place. The helper methods 
are used to check if the movement is acceptable or not.
It takes in the direction as the parameter and checks the four cases.
If it fits one of the four movements, it returns the canMove[specific 
direction] method. If there is a default, something went wrong and 
returns false.


public boolean move(Direction direction)
The purpose of this method is to move the tiles
based on the direction being passed in for the parameter.
It uses the canMove() method as a check, if it does
not pass it automatically returns false.
If a movement cannot be passed in, it will return false.
If it can be done, it will move the tiles and return true.
It takes in the direction as the parameter and 
checks the four cases (canMoveLeft, canMoveRight,
canMoveUp, and canMoveDown). If the case of either direction, 
it runs the move[specified direction] and breaks out of the
loop to return true.


2.) Explain what the addRandomTile() method does and discuss 
where you would need this functionality during the game of 2048 
(not the exact method where you will call it, but at what point 
in the game will it be useful).

The purpose of the addRandomTile() method is to add 
a random tile (2 or 4) to an empty space on the board. The place
is dependent on the random value that comes with the board object.
If there are no tile spaces left (empty tiles) it will return 
without adding a new random tile. It will be useful when the 
player makes a move. During the game, it will have to place a
new random tile to the board in order for the game to continue. 
The placement must be in an empty tile piece and when there
are no spaces available and no moves left for the player, the
game will end because the board is too filled and the player
is unable to move.


PART 5: Program description for each file worked on
Describe what the classes do, how they work, and 
how they work together(aim for 1-2 max per class)

Board.java:
The Board.java class was used to make the Board object.
It was able to update a board or load a board that was already
created. Depending on the desired direction that the user
wanted, the class will move the tiles on the board in the
given direction (combining of the same value, stopping at
certain points). There are a lot of checks when implementing 
the Up, Down, Left, and Right movements. When there are no moves
left, this class will indicate that the user cannot move
anything and display a GameOver.

It works cohesively with the Gui2048 as the back end of the
game. It provides the checks and functionanilities of each move that
the player makes to make sure the board is updated in the correct
points. Whether it be right, left, up, or down. The functions
in this class will be displayed by the Gui (interactive picture)
created in Gui2048.java.

Gui2048.java:
This class creates the actual display of the game.
In this I created a set up the different objects that are
being displayed on the boardgame and works with Board.java
for the actualy functionalities of the game. The objects being 
displayed such as the title, score, game tiles, and game over 
message are created here and placed on the
grid created through the gridPane (primary stage.)

Through this class, it also implements the eventKeyHandler
which takes in the desired direction of the user. It works with 
the Board.java file to make sure the key can be passed in as a move,
update the tiles board after going through the functions of the 
Board.java and display the updated board.


Effectively tested(8-10 sentences):
Mainly using the tests from the given PA5Tester, but also
implemented different senarios. For the move left, right, up, and down
there are tests to make sure that all the numbers do not add at the
end of the row if it is possible to merge alike tiles. 
There are tests to makesure that is does not skip over tiles 
if there is a  non-zero in the middle and the outside tiles are alike.
There are many cases of out of bounds errors, but those are fixed through 
for loops being run a certain way. Some tests were used to make
sure it fit with different sized gameboards and not just the one I created.
I also implemented a test to make sure the score was updated correctly (
when there was a match and merge during game play.) A lot of the tests
included shifting to the right box (making sure it wasnt going one by one).
As well as updating the entire board correctly. There were many problems that
I ran into when making the move methods, but I tried to fix the ones that 
I could. All in all, a pretty challenging assignment.







  