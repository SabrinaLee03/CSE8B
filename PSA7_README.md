/* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 24, 2017 (Wednesday)
 * File: README.md
 */

1. Describe how polymorphism and dynamic binding was used in Part 1.

In Part 1, it show how polymorphism works through accessing
the GameTile class. In this part we had to download several classes
from our classmates and implement them in the creation of our GUI.
Since they are all extensions of the GameTile superclass, these subclasses
were able to work together in creating a mixture GUI when the grid pane was
created. Due to dynamic binding, the object type was determined when the creation
of the board was going through run-time. It was able to pass the static binding
(compile-time) because each subclass was part of the superclass of GameTile.

In the GameTileFactory, when creating individual tiles to put on the board,
it went through a random number generator and accessed a specific subclass
for the tile chosen on the grid (gameboard). As stated before, there were no errors
in the creation of different game tiles from these different classes created because
they are all part of the large umbrella (overarching) superclass GameTile.


2. Describe the ways in which your moveXXX() code was overly complicated 
before your refactor.  How did your code style improve after the refactor?
Finally, what you have learned about the process of refactoring code and 
redesigning features.   

Before the refactor, each moveXXX() method was overly complicated because
it had to go through the same motions, but implement different areas of the grid.
It would have to go through each gametile on the grid and compare the ones ahead
one at a time. The code style improved after the refactor because each move was
pretty much doing the same thing, the only difference was the different 
starting points for running through the grid in each method. The functions (for
loops) started in the upper left corner or lower left depending on if it was
moving left, right, up, or down. Mainly to avoid out of bound errors and to 
implement the function right. By putting those functions in one code and calling
it in each, it made each method shorter and easier to follow.

I learned the refactoring code can make life a lot simpler. When I was 
creating the method in PA5, I thought to myself that these methods
are pretty much doing the same thing, its just starting at different parts of 
of the grid. But, nothing much is being changed. I pretty much focused on 
the moveRight, canMoveRight methods when writing the PA5, and figured
out the algorithms for the other ones after that point.


