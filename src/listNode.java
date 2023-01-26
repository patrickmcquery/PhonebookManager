public class listNode 
{
	private listNode next;
	private int index;
	
	private String fullName;
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNumber;
	private String areaCode;
	private String number;
	private String address;
	private String streetNumber;
	private String streetName;
	private String line2;
	private String zip;
	private String city;
	private String state;
	private String country;
	
	public listNode(int inIndex, String inFullName, String inPhoneNumber, String inAddress)
	{
		index = inIndex;
		
		setName(inFullName.trim());
		
		setPhoneNumber(inPhoneNumber.trim());
		address = inAddress;
	}
	
	private void setName(String inFullName)
	{
		fullName = inFullName.trim();
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
		System.out.println("\nArea code: " + areaCode + "\nNumber: " + number);
	}
	public String toString()
	{
		return fullName + ", " + address + ", " + phoneNumber;
	}
}
