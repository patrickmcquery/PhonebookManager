public class PhonebookManager 
{
	ListNode firstNode;
	
	public PhonebookManager()
	{
		firstNode = null;
	}
	
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
	
	public void delete(int index)
	{
		int i = 1;
		ListNode temp = firstNode;
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
	
	public String toString()
	{
		ListNode node = firstNode;
		String string = "";
		while(node.hasNext())
		{
			string += node.toString() + "\n";
			node = node.getNext();
		}
		string += node.toString() + "\n";
		return string;
	}
}