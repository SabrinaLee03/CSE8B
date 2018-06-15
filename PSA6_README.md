 /* Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: May 17, 2017 (Wednesday)
 * File: README.md
 */


PART 1:

General Inheritance Questions:

1.) What does the line super(5); do when placed in a class’s constructor?

When placed in a class's constructor, the line super(5) calls the superclass
constructor with the matching paramter (argument of int or String 5).
If a constructor within a class does not call a superclass constructor,
java will make a no-argument constructor from the superclass. 

2.) Assume you have a base class Superclass, and class Subclass that extends 
Superclass.  If you have the following code:
Superclass c = new Subclass();
will this cause an error?  (Assume Subclass has a default constructor).  
Why or why not?

No, because the subclass being created is always part of the Superclass.
For example in class we used Person sally = new Student(); because a student
is always person, but if it were called the other way around
Student sally = new Person(); this would cause an error because a 
person is not always a student. So, in this case, a subclass can be created from 
a superclass, but not vice versa all the time

3.) For the classes Superclass and Subclass as described above, 
which is true:
	a. A Superclass “is a” Subclass
	b. A Subclass “is a” Superclass
	c. Both of these
	d. Neither of these.

B: a sublcass is a superclass
one way, a subclass is a superclass, cannot go the other way around
sometimes a superclass is not a specific subclass (or does not have 
the same traits as a particular subclass)

4.) Now assume you have classes Person and Student as defined in class.  
Assume that you have a Person type variable that references a Student 
type object.  I.e. Person p = new Student(“Sally”, 18);  If the method 
sayHi() is defined in the Person class and overridden in the student class, 
which version of the method will be called when I write p.sayHi(), 
the Person’s version or the Student’s version?

The Student version, it is overridden in the student class and the actual 
type of the object p is "student". Type "person" is only the
declared type.


Inheritance Questions Based on the Implementation of Critters.java:

1.) Draw the class hierarchy for the following classes: Bear, Lion, Tiger,
 Dragon, Critter. Upload a picture of this class hierarchy in a separate
 file and name it Critters.png

 Attached File~

2.) Which methods from Critter will you override in the Bear class?

getColor()
eat()
fight(String opponent)
getMove()
toString()

3.) Will the following cause an error:  Bear b = new Critter();  Why or why not?

Yes, because not all Critters are Bears. It will not cause an error if you invoke
Critter b = new Bear();. But, the actual type (usually a sublcass) is always
part of the declared type (superclass).

4.) True or false: you will need to add a line of code that calls the method “eat” 
critters to eat food during the simulation.

True, some critters always eat when coming across food, some only eat under 
certain circumstances so condition checks have to be put in place.

5.) True or false: The member variables in the Dragon class can be different 
and have no relation to the member variables in the Tiger class.  Explain why.

True, because they are two different subclasses of the superclass Critter. 
Individual subclasses can have different member variables and have no relation to
each other but they can still belong to the same superclass. Although the superclass
may have member variables, because they are passed into every subclass
derived, each subclass do no have to always use those declared member variables.

6.) Explain how you could use a static member variable in the Bear class to keep 
track of the total number of Bears that had ever been created.  (Note: There’s no 
need to actually do this in the code).

You would create a static member variable that keeps track everytime two
Bears collide (they mate and create a new baby everytime two species of the
same kind collide).


PROGRAM DESCRIPTION:
Bear.java
This file contains the functions specific to a bear being created. It is
always hungry, so it always eats when it comes across food. It scratches
when it comes across a different critter. It moves in a zigzag formation
alternating between south and east. It is also color spcecific depending
on if the input makes it a grizzly bear or polar bear (which makes the
color brown or white). The variable that appears is a B.

Lion.java
This file contains the function specific to a lion being created. It
is only hungry after it fights. It either roars or pounces depending 
if it comes across a bear any other critter. It is always the color red.
The movement goes in circles in increments of 5 starting with the direction
going south. The variable that appears is a L.


Tiger.java
This file contains the function specific to a tiger being created. 
It is hungry for a fixed amount and represents how much more food it
wants by the display number. It either scratches or pounces depending on what
crtitter it comes across. The movement of a tiger is random in increments of 3.
It is always the color yellow.


Dragon.java
This file contains the functions specific to a dragon being created.
The color represents how much food it has eaten (either even or odd amounts).
It attacks depending on the last opponent it faced. But, the first attack is 
randomly generated. The movement is in a large indented circle with a 
diameter of 10. The name displayed is always a D.


MyCritter.java
This file contains the functions of my critter that I have created.
The color and display name will always be black and BEAST.
It will always eat when it comes across food. The attack moves
are specific to the opponent it comes across, bear it plays roar,
lion it plays scratch, tiger it plays roar when it is hungry and scratch when 
the tiger is not hungry, against a dragon it plays roar because
the dragon fight function is random. I chose the movement south in 
order to cover more ground.


MyCritterTester.java
This file tests if the fight moves come out to be correct or not.
It depends on the string being passed in for the opponent and it
is specifically tailored to beat the opponent. The movement and colors
are also tested to make sure the input is correct when a BEAST is created.










