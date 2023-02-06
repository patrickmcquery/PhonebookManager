/*
 * Patrick McQuery
 * 
 * List node class
 * Contains a person,
 */
public class ListNode 
{
	private ListNode next;
	private Person person;
	public ListNode(Person inPerson)
	{
		person = inPerson;
	}
	public Person getPerson()
	{
		return person;
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