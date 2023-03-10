/*
 * Patrick McQuery
 * 
 * Main class for the phonebook assignment
 */
import java.util.Scanner;

public class Main 
{
	static PhonebookManager phonebook = new PhonebookManager();
	
	/*
	 * Contains the main loop for interacting with the phonebook
	 * You can add, modify, delete, print or quit
	 * Calls the appropriate method based on user input
	 */
	public static void main(String[] args) 
	{
		Scanner console = new Scanner(System.in);		
		boolean doing = true;
		while(doing)
		{
			System.out.println("What would you like to do?");
			System.out.println("add/modify/delete/print/quit");
			String resp = console.nextLine();
	        System.out.println();
	        switch (resp.toLowerCase().charAt(0))
	        {
	            case 'a':
	                add(console);
	                break;
	            case 'm':
	                modify(console);
	                break;
	            case 'd':
	                delete(console);
	                break;
	            case 'p':
	           	 	print();
	           	 	break;
	            case 'q':
	           	 	System.out.println("Exiting gracefully.");
	           	 	doing = false;
	           	 	break;
	            default:
	            	System.out.println("Invalid response given, please try again.");
	         }
		}
	}
	//Add an entry to the phonebook. Can be at the start, end, or middle.
	public static void add(Scanner console)
	{
		boolean adding = true;
		while(adding)
		{
			System.out.println("Would you like to add to the start, end, or somewhere in the middle?");
			System.out.println("start/end/middle");
			String resp = console.nextLine();
	        System.out.println();
	        switch (resp.toLowerCase().charAt(0))
	        {
	            case 's':
	                addStart(console);
	                break;
	            case 'e':
	                addEnd(console);
	                break;
	            case 'm':
	            	if(phonebook.length() == 0)
	            	{
	            		System.out.println("Error: phonebook is empty. Please add to the start/end");
	        			break;
	            	}
	                addMiddle(console);
	                break;
	            default:
	            	System.out.println("Invalid response given, please try again.");
	        }
				System.out.println("Would you like to add another entry?");
	            resp = console.nextLine();
	            System.out.println();
	            switch (resp.toLowerCase().charAt(0))
	            {
	                case 'y':
	                    adding = true;
	                    break;
	                case 'n':
	                    adding = false;
	                    break;
	                default:
	                    System.out.println("Invalid response given, please try again.");
	            }
		}
	}
	//Adds an entry to the end of the phonebook
	public static void addEnd(Scanner console)
	{
			System.out.println("Let's add a new entry to the end of the phonebook.");
			System.out.println("What's the name? ");
			String name = console.nextLine();
			System.out.println("What's the phone number? ");
			String phone = console.nextLine();
			System.out.println("What's the address? ");
			String address = console.nextLine();
			phonebook.add(new Person(name, phone, address));
	}
	//Adds an entry to the start of the phonebook
	public static void addStart(Scanner console)
	{
			System.out.println("Let's add a new entry to the start of the phonebook.");		
			System.out.println("What's the name? ");
			String name = console.nextLine();
			System.out.println("What's the phone number? ");
			String phone = console.nextLine();
			System.out.println("What's the address? ");
			String address = console.nextLine();
			phonebook.addStart(new Person(name, phone, address));
	}
	//Adds an entry to the middle of the phonebook
	public static void addMiddle(Scanner console)
	{
		System.out.println("What position would you like to add the new entry at?");
		System.out.println("2 - " + phonebook.length());
		int resp = console.nextInt();
		console.nextLine();
        System.out.println();
        if(resp > 1 && resp <= phonebook.length())
        {
        	System.out.println("Let's add a new entry to position " + resp + " of the phonebook.");		
			System.out.println("What's the name? ");
			String name = console.nextLine();
			System.out.println("What's the phone number? ");
			String phone = console.nextLine();
			System.out.println("What's the address? ");
			String address = console.nextLine();
			phonebook.addAt(resp, new Person(name, phone, address));
        }
        else
        {
            	System.out.println("Invalid response given, please try again.");
        }
		
	}
	//Modifies the user chosen entry's chosen field
	public static void modify(Scanner console)
	{
		System.out.println("Which entry would you like to modify?");
		int resp = console.nextInt();
		console.nextLine();
        System.out.println();
        if(resp > 0 && resp <= phonebook.length())
        {
        	System.out.println("What would you like to modify?");
        	System.out.println("name/phone/address");
        	String response = console.nextLine();
            System.out.println();
            System.out.println("What would you like it to be?");
        	String modification = console.nextLine();
            System.out.println();
            switch (response.toLowerCase().charAt(0))
            {
                case 'n':
                    phonebook.modify(resp,'n', modification);
                    break;
                case 'p':
                	phonebook.modify(resp,'p', modification);
                    break;
                case 'a':
                	phonebook.modify(resp,'a', modification);
                	break;
                default:
                    System.out.println("Invalid response given, please try again.");
            }
        	System.out.println("Entry at position " + resp + " has been modified.");
        }
        else
        {
            	System.out.println("Invalid response given, please try again.");
        }
	}
	//Deletes an entry
	public static void delete(Scanner console)
	{
		System.out.println("What position is the entry at that you would like to delete?");
		System.out.println("1 - " + phonebook.length());
		int resp = console.nextInt();
		console.nextLine();
        System.out.println();
        if(resp > 0 && resp <= phonebook.length())
        {
        	phonebook.delete(resp);
        	System.out.println("Entry at position " + resp + " has been deleted");
        }
        else
        {
            	System.out.println("Invalid response given, please try again.");
        }
	}
	//Prints the phonebook
	public static void print()
	{
		System.out.println(phonebook);
	}
}