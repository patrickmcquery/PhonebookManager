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
		ListNode temp = firstNode;
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