/**Class demonstrating a stadium ticket that contains the information about the ticket number and the purchaser's name.
* @author Siang Swee Kong
* @version 1.0.0
*/

public class StadiumTicket {
	private int ticketNumber;  // ticket number is used as the key field 
	private String ticketOwner; // a variable to store the purchaser's name
	
	/**A default constructor that takes no argument to initialize the attributes
	 * @param None
	 * @return No return type
	 */	
	public StadiumTicket () 
	  {  ticketNumber = 0; 
	     ticketOwner = "N/A";
	  }

	/**A constructor that takes two arguments to initialize the attributes
	* @param number A parameter used to initialize the ticketNumber
	* @param name A parameter used to initialize the ticketOwner
	* @return No return type
	*/	
	public StadiumTicket (int number, String name) 
	  {  ticketNumber = number;
	     ticketOwner = name;
	  }
	
	/**A method that prints out the ticket information
	* @param None 
	* @return the description of the ticket number and the purchaser's name
	*/	
	public String toString() 
	   {   
		return("Ticket number is: " + ticketNumber + "\nPurchaser's name is: " + ticketOwner + "\n");
	   }
	
	/**A method that makes a deep copy of the node
	* @param None
	* @return a deep copy of the node
	*/	
	public StadiumTicket deepCopy() 
	   {  StadiumTicket dCopy = new StadiumTicket(ticketNumber, ticketOwner); // make a deep copy of the node
	      return dCopy;
	   }
	
	/**A method to return the value of the ticketNumber field
	* @param None
	* @return ticket number as int
	*/	
	public int getTicketNumber()
		{
			return ticketNumber;
		}
	
	/**A method to return the value of the ticketOwner field
	* @param None
	* @return the purchaser's name as String
	*/	
	public String getTicketOwner()
		{
			return ticketOwner;
		}
	
	
}
