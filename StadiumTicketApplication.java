/**A stadium ticket application that is used to test the four basic operation methods (insert, fetch, delete, and update) in a perfect hashed structure
* @author Siang Swee Kong
* @version 1.0.0
*/
public class StadiumTicketApplication {
	
	/**Application entry point
	* @param args As a space delimited list of command line arguments 
	*/	
	public static void main(String[] args) {
		boolean value; //to store a boolean value 
		PerfectHashedStructure stadium1 = new PerfectHashedStructure(); //create a perfect hashed structure with default constructor
		StadiumTicket temp; //to store temporary StadiumTicket object
		
		//create 6 instances of StadiumTicket object
		StadiumTicket ticket1 = new StadiumTicket(2000, "Raymond");
		StadiumTicket ticket2 = new StadiumTicket(35600, "David");
		StadiumTicket ticket3 = new StadiumTicket(98000, "Alfred");
		StadiumTicket ticket4 = new StadiumTicket(1950, "Michael");
		StadiumTicket ticket5 = new StadiumTicket(100000, "Johny");
		StadiumTicket ticket6 = new StadiumTicket(27986, "Kelly");
		
		//testing insert operation
		System.out.println("Test insert method: ");	
		value = stadium1.insert(ticket1); //true
		System.out.println(value);	
		value = stadium1.insert(ticket2); //true
		System.out.println(value);	
		value = stadium1.insert(ticket3); //true
		System.out.println(value);	
		value = stadium1.insert(ticket4); //false because the ticket number is not in the range
		System.out.println(value);	
		value = stadium1.insert(ticket5); //false because the ticket number is not in the range
		System.out.println(value);	
		
		stadium1.displayAll(); //display all the ticket information in the data structure
		
		//testing fetch operation
		System.out.println("Test fetch method: ");	
		temp = stadium1.fetch(2000); 
		System.out.println(temp);//output the ticket1 info
		temp = stadium1.fetch(35600); 
		System.out.println(temp);//output the ticket2 info
		temp = stadium1.fetch(98000);
		System.out.println(temp);//output the ticket3 info
		temp = stadium1.fetch(1000);
		System.out.println(temp); //return null because the requested ticket number is not in the range
		temp = stadium1.fetch(5839);
		System.out.println(temp); //return null because the requested ticket number is not in the structure
	
		//testing delete operation
		System.out.println("\nTest delete method: ");
		value = stadium1.delete(2000); 
		System.out.println(value); //true
		value = stadium1.delete(1000);
		System.out.println(value);  //return false because the requested ticket number is not in the range
		value = stadium1.delete(5839);
		System.out.println(value); //return false because the requested ticket number is not in the structure

		//testing update operation
		System.out.println("\nTest update method: ");
		value = stadium1.update(2000, ticket6); 
		System.out.println(value); //return false because the requested ticket with given key is not in the structure (it was deleted)
		value = stadium1.update(35600, ticket6);
		System.out.println(value); //true, the ticket2 is replaced by ticket6
		
		stadium1.displayAll(); //display all the ticket information in the data structure
		System.out.println("End of the program...");
		System.exit(0); //end of the program
	}
}
