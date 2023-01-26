import java.util.ArrayList;

public class phonebookManager 
{
	ArrayList<listNode> phonebook;
	
	public phonebookManager()
	{
		phonebook = new ArrayList<listNode>();
	}
	
	public void addNode(int index, String inName, String inPhone, String inAddress)
	{
		phonebook.add(new listNode(index, inName, inPhone, inAddress));
	}
	
	public String toString()
	{
		return phonebook.get(0).toString();
	}
}