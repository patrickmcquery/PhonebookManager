public class ListNode 
{
	private ListNode next;
	private int index;
	private Person person;
	
	public ListNode(Person inPerson)
	{
		person = inPerson;
	}
	
	public ListNode(int inIndex, Person inPerson)
	{
		index = inIndex;
		person = inPerson;
	}
	
	public void add(Person inPerson)
	{
		next = new ListNode(index + 1, inPerson);
	}
	
	public boolean hasNext()
	{
		return next != null;
	}
	
	public ListNode getNext()
	{
		return next;
	}
	
	public void setNext(ListNode inNode)
	{
		next = inNode;
	}
	
	public String toString()
	{
		return person.toString();
	}
}
