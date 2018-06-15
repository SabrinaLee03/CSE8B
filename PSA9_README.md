 /*
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: June 7, 2017 (Wednesday)
 * File: README.md
 */


Program (4Points)

Part 1
The Caesar Cipher allows someone to take a letter and
rotate through the alphabet in order to generate a new letter
that will either hide a message or letter given. This is used
in hiding passwords or creating secret messages.
The animation in part 1 is either 1 turtle or multiple turtles
animating an encoded message. Depending on if there is one
turtle or multiple turtles.
for one turtle, the secret message uses the caesarcipher to
create a hidden message, that message is then passed onto a
single turtle that draws out the hidden message
for multiple turtles, when each letter is passed into the 
function, a new turtle is created in order to draw the hidden
letter in that message, then the next letter is drawn in a hidden
letter by a new turtle and so on until the entire message is encoded
each turtle draws the hidden letter of the message simultaneously which
is a faster process

Part 2
The StringBuilder created is a class that contains methods to perform
functionalities onto altering strings being passed in.
First the SBNode constructor is created to have default elements 
and a single argument. methods are then applied to the MyStringBuilder
class such as
add(char addingChar) which goes through the entire SBNode linked list
and adds a character being passed in to the end of the linked list
(pretty much appending or concatinating)
change(char changechar, int position) which can change a character
at a given position of the string
toString() allows the user to create a string and return 
the desired string once the method is finished. it uses the entire
SBNode list, all of the internal information is not seen
remove(int position) this will allow the user to delete a character
from the data given a position

these tools are helpful in manipulating a string efficiently and timely
it will extract each character in the string (visualized as a linked 
list of letters) and alter it accordingly to the user. it will then
return the desired altered string that the user input.



Testing (4Points)

Part 1
For the tester I implemented several words and sequences of letters
to check if the string being passed in was valid such as
"Check" "!@#@#" "1234" "". if the string being passed in was not 
all uppercase, then the function would return an error message
for one turtle, it would create the whole new string
for the multiple turtles, each time it goes through
the check on each of the letters in the message and creates
a new turtle with the acceptable letter. if not it will return
and go to the next test.

Part 2
add(char addingChar) method was tested by passing in an empty string
(first node is pointing to null) as well as different types of characters
to make sure the types are matching correctly.
change(char changechar, int position) method was tested by passing in
positions not valid in the string, as well as passing in an empty string
seeing if the exception was thrown. but making sure the program doesn't 
crash by throwing it in main
toString() method was tested by passing in an empty string
because there would be nothing to convert, as well as different types of 
characters
remove(int position) method was tested by putting in a position out 
bounds, as well as passing in an empty string because there would be nothing
to remove. this method was the most tricky for me in visualizing the linked
list and how each pointer had to be altered when removing a node in 
the middle of a list

Mainly the testers created were to check which exceptions were thrown 
and if the positions being passed in were in or out of bounds.


Conceptual Questions(2Points)
encryptMT() given 8 character string
2 threads running simultaneously
every character takes the same amount of time
how long will the encryption take to finish drawing?
charTime = amount of time it takes to encrypt and draw one character

Answer: 8/2 = 4
charTime x4

