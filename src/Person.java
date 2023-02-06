/*
 * Patrick McQuery
 * 
 * The person class
 * Contains the name, phone number, and address
 * Has the ability to store the name and phonenumber as seperated values
 * doesn't do anything with this funcitonality though
 */

public class Person 
{
	private String fullName;
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNumber;
	private String areaCode;
	private String number;
	private String address;	
	public Person(String inFullName, String inPhoneNumber, String inAddress)
	{
		
		setName(inFullName.trim());
		
		setPhoneNumber(inPhoneNumber.trim());
		
		setAddress(inAddress.trim());
	}
	
	public void setName(String inFullName)
	{
		fullName = inFullName;
		String[] nameArray= fullName.split("\\s");
		switch(nameArray.length)
		{
			case 1: firstName = nameArray[0];
					middleName = "";
					lastName = "";
					break;
			case 2: firstName = nameArray[0];
					middleName = "";
					lastName = nameArray[1];
					break;
			case 3: firstName = nameArray[0];
					middleName = nameArray[1];
					lastName = nameArray[2];
					break;
			default: System.out.println("Error: Name doesn't exist");
		}
	}
	public void setPhoneNumber(String inPhoneNumber)
	{
		if(inPhoneNumber.contains("(") && inPhoneNumber.contains(")") && inPhoneNumber.contains("-"))
		{
			phoneNumber = inPhoneNumber;
			areaCode = inPhoneNumber.substring(1, 4);
			number = inPhoneNumber.substring(5);
		}
		else if(inPhoneNumber.contains("-") && inPhoneNumber.length() == 12)
		{
			areaCode = inPhoneNumber.substring(0, 3);
			number = inPhoneNumber.substring(4);
			phoneNumber = "(" + areaCode + ")" + number;
		}
		else if(inPhoneNumber.length() == 10)
		{
			areaCode = inPhoneNumber.substring(0, 3);
			number = inPhoneNumber.substring(3, 6) + "-" + inPhoneNumber.substring(6);
			phoneNumber = "(" + areaCode + ")" + number;
		}
	}
	public void setAddress(String inAddress)
	{
		address = inAddress;
	}
	public String toString()
	{
		return fullName + ", " + address + ", " + phoneNumber;
	}
}