/* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 31, 2017 (Wednesday)
 * File: README.md
 */


PART 1 WarmUp

Problem 1 Print in Binary
Base Case: if the number being passed in is zero, 
it returns an empty string

Recursion: takes in the modified number which is divided by zero 
(finding the binary value) and adding to the end 
(least significant value) of the binary string
each time the method is called, it reduces the number 
being passed in to create the binary string



Problem 2 Random Nmeumonic
Base Case: if the number being passed in is empty or null, it will
return an empty string

Recursion: if the number passed in is one digit, it will return
the randomly generated letter through the helper method
if its longer than one, it will create two different strings 
in order to create the next randomly generated letter 
each time the method is called, it shortens the string by 
taking away the frist value and running the same code on the next
number in the string being passed in



Problem 3 isSubSetSum
Base Case: has two base cases, if the arrayList length
is 0 (empty or passed in null) it return false
if the targetNumber is already 0, the empty
set is a subset of every set including itself, so it 
will always be true

Recursion: it takes the first value from the arrayList and 
subtracts it from the targetNumber, then it runs 
through the arrayList to see if the next subtraction makes
the targetNumber equal to zero. if it does, it has a subset
sum values



PART 2 Turtle Recursion

Problem 1 Spiral
Base Case: there are base cases for each type of multiplier
depending on if the multiplier is increasing or decreasing the
spiral the turtle is making. once the length is either less
than 1 (decreasing) or greater than 200 (increasing) then it
breaks out.

Recursion: as the length is greater than 1 or less than 200, 
it moves the turtle forward by the amount passed in,
adjusts the next length call (counting up or counting down)
and calls the recursive call until the length hits the base case



Problem 2 Tree
Base Case: two base cases
if the height being passed in (number of forks)
if the branch length is equal to zero
is equal to zero, it breaks out

Recursion: the turtle moves forward by the length passed in
turns to make the right branch and calls the recursion with 
the altered length and subtract 1 from the height to only run
the number of times the user wants (number of forks). at that
point it turns left to make the left branch, calls the 
recursion again with the altered branch length and height -1
the turns right back again and moves backward to go 
back to the bottom, runs until it hits the base case



PART 3 One more recursive problem

Problem 2 Generate Mnemonics
Base Case: similar to the warm up
if the number being passed in has an empty string
is null, it returns an empty arrayList

Recursion: 
if the string created from the getCode method is ""
then it adds "" to the arrayList and calls a recursion method
if the string is not "", it goes through the 
string of possible letters for that digit
if the length of the number being passed in 
is less than 1, it returns 
the string of all possible values for that one number
other cases include getting the possible values 
going through the arraylist to see if it has already 
been generated if yes, continue and make new randomly generated
strings, if no add it to the arrayList that will be returned in 
the end










 