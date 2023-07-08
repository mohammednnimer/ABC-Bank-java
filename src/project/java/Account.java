package project.java;

public class Account {

	int ID;
	String Holder_Name;
	long PhoneNumber;
	char AccounType;
	double balance;
	

	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getHolder_Name() {
		return Holder_Name;
	}
	public void setHolder_Name(String holder_Name) {
		Holder_Name = holder_Name;
	}
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public char getAccounType() {
		return AccounType;
	}
	public void setAccounType(char accounType) {
		AccounType = accounType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String tostring()
	{
		
		
		return ID+" "+Holder_Name+ " "+PhoneNumber+" "+AccounType+" "+balance;
		
	}
	
	
}