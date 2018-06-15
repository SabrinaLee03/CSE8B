/*
 * File Header TODO
 * Name: Sabrina Lee A91066880
 * Login:CS8bsip sal040@ucsd.edu
 * Date: June 7, 2017 (Wednesday)
 * File: MyStringBuilder.java
 * 
 * Class Header TODO
 * This is the MyStringBuilder class that implements the SBNodes
 * These are the methods that the user can use for the SBNode
 * class that was created in the other file
 * basic methods such as remove, change, toSTring, and add
 */
public class MyStringBuilder{
	SBNode firstNode;   //TODO make sure you define the SBNode class ! 
    SBNode currNode;
    int count;
    

    /* TODO 
     * my string builder is pretty much
     * the first node
     * */
    public MyStringBuilder(){
        count = 0;
        firstNode = null;
    }
    
    
    /* TODO
     * add(char addingChar)
     *  1iterate through the list of SBNodes until
     *  it hits the last SBNode
     *  2at the last SBNode, create a new SBNode with 
     *  adding Char argument 
     *  3set the reference of the current SBNode's next-node
     *  reference to the SBNode
     *  4increment the count variable
     *  
     *  */
    public void add(char addingChar){ 
        /* TODO */

        //If no characters exist then the first character is added character
        if(firstNode == null){
        	//if it did not have anything to 
        	//begin with, add the character
            firstNode = new SBNode(addingChar);
            //reset current node to the first
            currNode = firstNode;
            //increment count
            count++;
        }
        else{
            //use a while loop to iterate through
            //till hits the last SBNode
            while(currNode.nextNode != null){
                currNode = currNode.nextNode;
            }
            //Create new node
            SBNode newNode = new SBNode(addingChar);
            //Set previous nodes next node to new adding node
            currNode.nextNode = newNode;
            //Increase node count
            count++; 
        }
    }

    
    
    /* TODO 
     * check to make sure the position is within legal range
     * (first character position 0) to last (count -1)
     * if it is out of bounds, throw ExceptionOutofBounds
     * 
     * iterate through the list of SBNodes for the
     * correct number of times as given by position
     * legal value of position starts with 0 (first character
     * in the list)
     * 
     * change the SBNode's character to changeChar
     * */
    public void change(char changeChar, int position) throws Exception{
    /*TODO*/
    	
    //Reset Currentnode position to front of linkedlist
    currNode = firstNode;
    
    //check if the position is within legal range
    if(position < 0 || position > count-1){
    	throw new StringIndexOutOfBoundsException("Position being"
    			+ "passed in is out of bounds, please try again!");
    }
    
    //condition check
	 if(firstNode == null || currNode == null){
		System.out.println("There is no character to change, list is empty!");
    }
    else{
    	//iterate through the linked list
    	for(int i = 0; i <= position; i++){
    		//find the position the user wants
    		if(i == position){
                //Set position to the desired changed char
                currNode.data = changeChar;
    		}
    		else{
    		//reseting current node reference to how it was before
    		currNode = currNode.nextNode;
    		}
    	}
    }
 } 
    
    
    /* TODO 
     * create a new string that will
     * eventually be returned
     * 
     * iterate through the nodes until there are no more
     * each character you see will be joined with this string
     * */
    public String toString(){
    	/*TODO*/
    	//string to return
    	String finalString = "";
    	//reset current node to the front
    	currNode = firstNode;
    	
    	//condition check
    	 if(firstNode == null || currNode == null){
    		 //condition warning
    		 System.out.println("Empty list being passed in!");
    		 //return an empty string
    		 return finalString;
         }

    	 else{	 
    		 //use a while loop to iterate through
    		 //till hits the last SBNode
    		 for(int i = 0; i < count; i++){
    			 //creating the string
    			 finalString += currNode.data;
    			 //reseting the currNodes back
    			 currNode = currNode.nextNode;
    		 }
    		 //returning the final string
    		 return finalString; 
    	 }
    }
    
    
    /* TODO
     * 
     * returning the desired character at a given position
     * first make the checks if the position is valid
     * check if the strinbuilder is empty
     * 
     * if checks pass, go through the nodes,
     * set the character to return to the desired position
     * 
     * reset the nodes back, 
     * 
     *  */
    public char remove(int position) {
  	/*TODO*/
    	//empty char to return 
    	char charToReturn = ' ';
     	//reset current node to the front
    	currNode = firstNode;
    
    	//check if the position is within legal range
        if(position < 0 || position > count-1){
            throw new StringIndexOutOfBoundsException("Position being"
                    + "passed in is out of bounds, please try again!");
        }
        
        //check if MyStringBuilder is empty
        if(firstNode == null || currNode == null){
        	System.out.println("There is no character to take out, list is empty!");
        }
        
        //if only one character
        if(firstNode.nextNode == null){
        	//remove the node
        	firstNode = null;
        	//decrement the count
        	count --;
        }

        else{ 
        	//go through all the nodes
        	for(int i = 0; i < count; i++){
        		//till it hits the position
        		if(i == position){
        			//holding character to return in the list
        			charToReturn = currNode.data;
        			//set previous node to currnode.next
        			firstNode = currNode.nextNode;
        			//reseting the currNode back
                    currNode.nextNode = null;
                    //decrement count
                    count--;  
                }
        		//at the position
        		else{
        			//reseting current node reference to how it was before
            		currNode = currNode.nextNode;
                }
            }
        }
        return charToReturn;
    }

}