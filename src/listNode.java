public class listNode 
{
	private listNode next;
	private int index;
	private Person person;
	
	public listNode(int inIndex, String inFullName, String inPhoneNumber, String inAddress)
	{
		index = inIndex;
		person = new Person(inFullName, inPhoneNumber, inAddress);
	}
	
	public listNode(int inIndex, String inFullName, String inPhoneNumber, String inAddress, listNode inNext)
	{
		next = inNext;
		
		index = inIndex;
		
		person = new Person(inFullName, inPhoneNumber, inAddress);
	}
	
	public String toString()
	{
		return person.toString();
	}
}
