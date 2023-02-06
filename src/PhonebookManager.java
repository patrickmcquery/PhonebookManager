/*
 * Patrick McQuery
 * 
 * Phonebook manager class
 * Contains the ability to keep a list of entries using the ListNode class
 */

public class PhonebookManager 
{
	ListNode firstNode;
	public PhonebookManager()
	{
		firstNode = null;
	}
	//Adds a person to the list at the end
	public void add(Person person)
	{
		ListNode node = new ListNode(person);
		if(firstNode == null)
		{
			firstNode = node;
		}
		else
		{
			ListNode temp = firstNode;
			while(temp.hasNext())
			{
				temp = temp.getNext();
			}
			temp.setNext(node);
		}	
	}
	//Adds a person to the start of the list
	public void addStart(Person person)
	{
		ListNode node = new ListNode(person);
		if(firstNode == null)
		{
			firstNode = node;
		}
		else
		{
			node.setNext(firstNode);
			firstNode = node;
		}
	}
	//Adds a person at a specified index
	public void addAt(int index, Person person)
	{
		int i = 1;
		ListNode node = new ListNode(person);
		ListNode temp = firstNode;
		while(temp.hasNext())
		{
			if(i == index)
			{
				node.setNext(temp.getNext());
				temp.setNext(node);
			}
			i++;
			temp = temp.getNext();
		}
		if(i == index)
		{
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
	}
	//Deletes the person at the specified index
	public void delete(int index)
	{
		ListNode temp = firstNode;
		if(index == 1)
		{
			firstNode = temp.getNext();
			return;
		}
		int i = 1;
		while(temp.hasNext())
		{
			if(i == index - 1)
			{
				temp.setNext(temp.getNext().getNext());
				return;
			}
			i++;
			temp = temp.getNext();
		}
		if(i == index - 1)
		{
			temp.setNext(temp.getNext().getNext());
		}
	}
	//Returns the length of the list
	public int length()
	{
		int i = 1;
		if(firstNode == null)
		{
			return 0;
		}
		else
		{
			ListNode temp = firstNode;
			while(temp.hasNext())
			{
				temp = temp.getNext();
				i++;
			}
			return i;
		}
	}
	//Modifies a specified field, of a person at a specified index with a specified modification
	public void modify(int index, char field, String modification)
	{
		int i = 1;
		ListNode temp = firstNode;
		while(temp.hasNext())
		{
			if(i == index)
			{
				switch(field)
				{
				case 'a':
					temp.getPerson().setAddress(modification);
					break;
				case 'n':
					temp.getPerson().setName(modification);
					break;
				case 'p':
					temp.getPerson().setPhoneNumber(modification);
					break;
				}
				return;
			}
			temp = temp.getNext();
			i++;	
		}
		if(i == index)
		{
			switch(field)
			{
			case 'a':
				temp.getPerson().setAddress(modification);
				break;
			case 'n':
				temp.getPerson().setName(modification);
				break;
			case 'p':
				temp.getPerson().setPhoneNumber(modification);
				break;
			}
			return;
		}
	}
	public String toString()
	{
		if(firstNode == null)
		{
			return "Phonebook is empty.";
		}
		ListNode node = firstNode;
		String string = "";
		int i = 1;
		while(node.hasNext())
		{
			string += i + ". " + node.toString() + "\n";
			node = node.getNext();
			i++;
		}
		string += i + ". " + node.toString() + "\n";
		return string;
	}
}