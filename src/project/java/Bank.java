package project.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Bank {
	boolean[] n = new boolean[1000];
	Scanner input = new Scanner(System.in);
	Account c = new Account();
	Account[] listAcoount = new Account[1000];

	int counter = 0;

	public boolean chekedId(int c)
	{
		for(int i=0;i<counter;i++)
		{
			if(listAcoount[i].ID==c)
			{if(n[i]==false)
			{
			
				return false;
			}
			}
		}
		return true;
		
		
	}
	public void displayAccounts() {
		for (int i = 0; i < counter; i++) {
			if (n[i] == false) {
				System.out.println(listAcoount[i].tostring());
			}

		}
		return;

	}

	public boolean addAccount(Account c1) {
		/*for (int i = 0; i < counter; i++) {
			if (c1.ID == listAcoount[i].ID) {
				System.out.println("The account is entered because The id is invalid");
				return false;
			}

		}*/
		listAcoount[counter++] = c1;
		return true;
	}

	public void addAmount(int c, double balance) {
		int i;
		int y = 0;
		for (i = 0; i < counter; i++) {
			if (listAcoount[i].ID == c) {
				if (n[i] == false) {
					listAcoount[i].balance += balance;
					y = 1;
					break;
				}

			}
		}
		if (y == 1) {
			System.out.println("the new balance");
			System.out.println(listAcoount[i].balance);
			return;
		} else {
			System.out.println("The account number is incorrect");
		}

	}

	public boolean withdrawAmount(int c, double balance) {
		int i;
		int y = 0;
		for (i = 0; i < counter; i++) {
			if (listAcoount[i].ID == c) {
				if (n[i] == false) {
					if (balance > listAcoount[i].balance) {
						System.out.println("Your balance is not enough");
						return false;
					}
					if (listAcoount[i].AccounType == 's') {
						if (balance > 500) {
							System.out
									.println("Sorry, but this is a savings account. You cannot withdraw more than 500");
							return false;
						}  
					}
					listAcoount[i].balance -= balance;
					
					break;
				}
			}
		}
		
			System.out.println("the new balance");
			System.out.println(listAcoount[i].balance);
		
		return true;

	}

	public boolean closeAccount(int r) {
		for (int i = 0; i < counter; i++) {
			if (listAcoount[i].ID == r) {

				n[i] = true;
				return true;

			}
		}
		System.out.println("There are no specification accounts");
		return false;
	}

	public void viewAccountDetails(int id, String g, int ch) {
		for (int i = 0; i < counter; i++) {
			if (listAcoount[i].ID == id || listAcoount[i].Holder_Name.toLowerCase().contains(g)) {
				if (n[i] == false) {
					if (ch == 0) {
						if (!listAcoount[i].Holder_Name.toLowerCase().contentEquals(g)) {
							break;
						}
					}
					System.out.println(listAcoount[i].tostring());

				}
			}

		}
	}

	public void modifyAccountDetails(int x, String g, int ch) {
		int i;
		for (i = 0; i < counter; i++) {
			{
				if (listAcoount[i].ID == x || listAcoount[i].Holder_Name.toLowerCase().contains(g)) {
					if (n[i] == false) {
						if (ch == 0) {
							if (!listAcoount[i].Holder_Name.toLowerCase().contentEquals(g)) {
								System.out.println("the name is wrong");
								return;
							}
						}
						break;
					}
				}
			}

		}
		System.out.println("Choose the one you want to change\n" + "1:id\n" + "2:holder name\n" + "3:phone number\n"
				+ "4:typeAccount");
		int counter = input.nextInt();
		while (counter > 4 || counter <= 0) {
			System.out.println("please enter the true value");
			counter = input.nextInt();
		}
		switch (counter) {
		case 1:
			System.out.println("please enter the new id");
			counter = input.nextInt();
			System.out.println("please enter the new id again");
			int counter1 = input.nextInt();
			while (counter != counter1) {
				System.out.println("The two entries did not match");
				System.out.println("Try again");
				System.out.println("please enter the new id");
				counter = input.nextInt();
				System.out.println("please enter the new id again");
				counter1 = input.nextInt();
			}
			listAcoount[i].ID = counter;
			System.out.println("Change done");
			break;
		case 2:
			System.out.println("please enter the new holder name");
			String m = input.next();
			System.out.println("please enter the new holder name again");
			String m1 = input.next();
			while (!m.equals(m1)) {

				System.out.println("The two entries did not match");
				System.out.println("Try again");
				System.out.println("please enter the new holder name");
				m = input.next();
				System.out.println("please enter the new holder name again");
				m1 = input.next();
			}
			System.out.println("Match succeeded");
			listAcoount[i].Holder_Name = m;
			System.out.println("Change done");
			break;
		case 3:
			System.out.println("please enter the new phone number");
			long counter2 = input.nextInt();
			System.out.println("please enter the new phone number again");
			long counter3 = input.nextInt();
			while (counter2 != counter3) {
				System.out.println("The two entries did not match");
				System.out.println("Try again");
				System.out.println("please enter the new phone number");
				counter = input.nextInt();
				System.out.println("please enter the new phone number again");
				counter1 = input.nextInt();
			}
			System.out.println("Match succeeded");
			listAcoount[i].PhoneNumber = counter2;
			System.out.println("Change done");
			break;
		default:
			if (listAcoount[i].AccounType == 'o') {
				System.out.println("are you sure do you wunt of change typeAccount to : s\n"
						+ "if yas please enter true\n" + "else please enter flase");
				boolean b = input.nextBoolean();
				if (b == true) {
					listAcoount[i].AccounType = 's';
					System.out.println("The account type has changed to :s");
					break;
				} else {
					break;
				}
			}
			if (listAcoount[i].AccounType == 's') {
				System.out.println("are you sure do you wunt of change typeAccount to : o\n"
						+ "if yas please enter true\n" + "else please enter flase\n");
				boolean b = input.nextBoolean();
				if (b == true) {
					listAcoount[i].AccounType = 'o';
					System.out.println("The account type has changed to :o");
					break;
				} else {
					break;
				}
			}

		}

	}

	public boolean uploadDataFile() throws FileNotFoundException {
		File f1 = new File("C:\\Users\\HP\\Desktop\\lecture\\src\\lecture\\project.java\\Account1.txt");
		if (!f1.canRead()) {
			return false;
		}

		while (!f1.exists()) {
			try {
				Scanner s1 = new Scanner(f1);

			} catch (FileNotFoundException e) {

				System.out.println("Choose the exact account name");

				String n = input.next();
				f1 = new File(n);

			}
		}

		Scanner s1 = new Scanner(f1);
		while (s1.hasNext()) {
			String n = s1.nextLine();
			String[] n1 = n.split(" ");
			c = new Account();
			c.ID = Integer.parseInt(n1[0]);
			c.Holder_Name = n1[1];
			c.PhoneNumber = Long.parseLong(n1[2]);
			c.AccounType = n1[3].charAt(0);
			c.balance = Double.parseDouble(n1[4]);
			addAccount(c);

		}
		s1.close();
		return true;

	}

	public boolean updateDataFile() throws FileNotFoundException {
		File f1 = new File("Account1.txt");
		if (!f1.canWrite()) {
			System.out.println("sorry the file can't write");
			return false;
		}
		while (!f1.exists()) {
			try {
				f1 = new File("C:\\Users\\HP\\Desktop\\lecture\\src\\lecture\\project.java\\Account1.txt");
				Scanner s1 = new Scanner(f1);

			} catch (FileNotFoundException e) {

				System.out.println("file not found");
				System.out.println("please enter the name of the file");
				String n = input.next();
				f1 = new File(n);

			}
		}
		PrintWriter p1 = new PrintWriter(f1);
		for (int i = 0; i < counter; i++) {

			try {
				if (n[i] == false) {
					p1.print(listAcoount[i].tostring());
					p1.println();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		p1.close();
		return true;

	}

}
