/**
*Description: A program that uses a perfect hashed data structure to store an array of nodes that contain information about a stadium ticket
*which is the ticket number and the purchaser's name. This program can store 60, 000 ticket at maximum in which the ticket numbers range from 2000 to 100,000.
*Four basic operations methods: Insert, Fetch, Delete, and Update, are created in the data structure and tested by a driver program.
*Class: Summer - COSC 2436.86400
*Assignment5: Perfect Hashed Structure
*Date: 07/29/2018
*@author  Siang Swee Kong
*@version 0.0.0
*/ 

/**Class demonstrating the four basic operation methods (insert, fetch, delete, and update) on a perfect hashed structure
* @author Siang Swee Kong
* @version 1.0.0
*/
public class PerfectHashedStructure {
	private StadiumTicket [] database;  
	private int maxNumOfSeats; //store the maximum number of seats
	private int count; //used to count the number of tickets stored in the structure
	private int sizeOfPSA; //size of the primary storage area
	private int minKeyValue; //the minimum possible value for a key
	
	/**A default constructor that takes no argument to initialize all the data fields
	 * @param None
	 * @return No return type
	 */	
	public PerfectHashedStructure() 
    {  	maxNumOfSeats = 60000; //the maximum number of seats is 60,000
    	count = 0; //start the count from 0
    	sizeOfPSA = (100000-2000); //98,000 is the size of the primary storage area
    	minKeyValue = 2000; //the minimum possible value for a key is 2000
    	database = new StadiumTicket[sizeOfPSA]; //create an array of references with size of 98,000 that contain the instances of StadiumTicket object
    }
	

	/**A subtraction preprocessing algorithm is used to convert the target key into pseudokey. This prevents the Direct Hashing algorithm from 
	* generating negative indices when the minimum key is negative, and improves the density when the minimum key is positive.
	* @param key Specifying the key value desired
	* @return calculated pseudokey
	*/	
	public int subtractionPreProcessing (int key)
	{
		int calculatedPseudoKey;
		calculatedPseudoKey = key - minKeyValue; //compute the pseudokey by using the given key minus the minimum possible value for a key
		return calculatedPseudoKey;
	}
	
	/**A method that is used to insert a new ticket into the data structure and tell the user if the ticket is successfully inserted
	* @param newTicket Specifying the ticket desired to be inserted into the data structure
	* @return false if the ticket number is out of range
	* @return false if the number of tickets stored reaches the maximum number of seats 
	* @return true if the ticket is successfully inserted into the structure
	*/	
	public boolean insert(StadiumTicket newTicket) {
		int index; //location in the primary storage area
		int pseudoKey; 
		pseudoKey = subtractionPreProcessing(newTicket.getTicketNumber()); //call the preprocessing method to compute the pseudokey
		index = pseudoKey; //Direct Hashing function
		if (pseudoKey < 0 || pseudoKey >= sizeOfPSA)  //Ticket is out of range
		{
			System.out.println("Out of ticket range!");
			return false;
		}
		
		else if (count == maxNumOfSeats)  //Number of tickets stored reaches the maximum number of seats 
		{
			System.out.println("Reached the maximum number of available seats!");
			return false;
		}
		
		else //Insert was successful
		{
			database[index] = newTicket.deepCopy(); //Insert the new node
			count++; //increment the count
			System.out.println("Successful Inserted!");
			return true;
		}
	}
	
	/**A method that is used to retrieve information of a ticket
	* @param key Specifying the key of the ticket desired to be retrieved from the data structure
	* @return null if the ticket number is out of range
	* @return null if the ticket with given key does not exist in the data structure
	* @return the description of the ticket number and the purchaser's name if the ticket with given key is in the structure
	*/	
	public StadiumTicket fetch(int key)
	{
		int index; //location in the primary storage area
		int pseudoKey;
		pseudoKey = subtractionPreProcessing(key); //call the preprocessing method to compute the pseudokey
		index = pseudoKey; //Direct Hashing function
		if (pseudoKey < 0 || pseudoKey >= sizeOfPSA) //Ticket is out of range
		{
			System.out.println("Out of ticket range!"); 
			return null;
		}
		
		else if (database[index] == null) //Ticket is not in the structure
		{
			System.out.println("The requested ticket does not exist!");
			return null;
		}
		
		else  //Ticket is in the structure
		{
			return database[index].deepCopy(); //return a copy of the node
		}
	}
	
	/**A method that is used to delete a ticket in the data structure and tell the user if the ticket is successfully deleted
	* @param key Specifying the key of the ticket desired to be deleted from the data structure
	* @return false if the ticket number is out of range
	* @return false if the ticket with given key does not exist in the data structure
	* @return true if the ticket is successfully deleted from the structure
	*/	
	public boolean delete(int key)
	{
		int index; //location in the primary storage area
		int pseudoKey;
		pseudoKey = subtractionPreProcessing(key); //call the preprocessing method to compute the pseudokey
		index = pseudoKey; //Direct Hashing function
		if (pseudoKey < 0 || pseudoKey >= sizeOfPSA) //Ticket is out of range
		{
			System.out.println("Out of ticket range!");
			return false;
		}
		
		else if (database[index]==null) //Ticket is not in the structure
		{
			System.out.println("The requested ticket to be deleted does not exist!");
			return false;
		}
		
		else //Ticket is in the structure
		{
			System.out.println("Successful deleted!");
			database[index] = null; //delete the node
			return true;
		}
	}
	
	/**A method that is used to update an existed ticket with a new ticket and tell the user if the ticket is successfully updated
	* @param key Specifying the key of the ticket desired to be updated in the data structure
	* @param newTicket Specifying a new ticket desired to replace the ticket with the given key
	* @return false if the update failed
	* @return true if the ticket with given key is updated to the new ticket
	*/	
	public boolean update(int key, StadiumTicket newTicket)
	{
		if(delete(key) == false) //Ticket is not in the structure
		{
			System.out.print("Update failed!\n"); 
			return false;
		}
		
		else //Ticket is in the structure 
		{
			insert(newTicket);  //Update the requested ticket with the new ticket
			System.out.print("Successful Updated!\n");
			return true;
		}
	}
	
	/**A method that is used to display all the ticket information in the data structure
	* @param None
	* @return description of the ticket number and the purchaser's name for all the tickets existed in the structure
	*/	
	public void displayAll()
	{
		System.out.println("\nPrint all the tickets information stored in the data structure.");
		for(int index = 0; index < sizeOfPSA; index++)
		{
			if (database[index] != null) //If the current location of the primary storage area contains a ticket
			{
				System.out.println(database[index].toString()); //print the ticket information
			}
		}
	}
	
}
