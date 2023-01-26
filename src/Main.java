import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		phonebookManager test = new phonebookManager();
		Scanner console = new Scanner(System.in);
		System.out.println("Let's add a new entry to the phonebook.");
		
		System.out.println("What's the name? ");
		String name = console.nextLine();
		
		System.out.println("What's the phone number? ");
		String phone = console.nextLine();
		
		System.out.println("What's the address? ");
		String address = console.nextLine();
		
		test.addNode(0, name, phone, address);
		System.out.println(test);
	}
}