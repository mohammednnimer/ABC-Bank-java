package project.java;

import java.io.FileNotFoundException;
import java.nio.file.spi.FileSystemProvider;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Draivar {
	 static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		
		
		
		
		displayMainMenu();
		Bank b1 = new Bank();
		Account c1 = new Account();
		boolean r=true;
		b1.uploadDataFile();
int a=counter();
		while (a != 8) {
			switch (a) {
			case 1:
				c1 = new Account();
				System.out.println("please enter the id the account");
				do {
					try {

						c1.ID = input.nextInt();
						r = false;
					} catch (InputMismatchException ex) {
						System.out.println("please enter numaric values");
						input.nextLine();
					}
				} while (r);
if(!b1.chekedId(c1.ID))
{
	System.out.println("This ID is given to another account");
	break;
	
}
				System.out.println("please enter the holder name");
				
				c1.Holder_Name = input.next();
				input.nextLine();

				System.out.println("please enter the  type account s or o");

				c1.AccounType = input.next().charAt(0);
				while (c1.AccounType != 's' && c1.AccounType != 'o') {
					System.out.println("please enter the true value s or o");
					c1.AccounType = input.next().charAt(0);

				}
				System.out.println("please enter the PhoneNumber");
				do {
					try {

						c1.PhoneNumber = input.nextLong();
						r = true;
					} catch (InputMismatchException e) {
						System.out.println("please enter numaric values");
						input.nextLine();

					}
				} while (r == false);

				// import the account type
				System.out.println("please enter the balance the account");
				do{
					try {
				c1.balance = input.nextDouble();
				r=false;
					}
					catch(InputMismatchException e){
						System.out.println("please enter numaric values");
						input.nextLine();
						
						
					}
				
				}while(r);
				b1.addAccount(c1);
				break;
			case 2:
				b1.displayAccounts();
				break;
			case 3:
				System.out.println("please enter the id of the Account");
				int n = input.nextInt();
				if(b1.chekedId(n))
				{
					System.out.println("The account number is incorrect");
					break;
				}
				System.out.println("pleasae enter the mount ");
				double i = input.nextDouble();
				b1.addAmount(n, i);
				break;
			case 4:
				
				System.out.println("please enter the id of the Account");
				n = input.nextInt();
				if(b1.chekedId(n))
				{
					System.out.println("The account number is incorrect");
					break;
				}
				System.out.println("please enter the mount ");
				i = input.nextDouble();
				b1.withdrawAmount(n, i);
				break;
			case 5:
				System.out.println("please enter how search about your acount");
				System.out.println("1: your Id");
				System.out.println("2: Holder name");
				System.out.println("3: part of the neme");
				int q = input.nextInt();
				while (q < 1 || q > 3) {
					System.out.println("please enter true value");
					q = input.nextInt();

				}
				String g = " ";
				int n2 = 0;
				int ch = 0;
				if (q == 1) {
					System.out.println("please enter the Id");
					n2 = input.nextInt();
					ch = 1;
				} else if (q == 2) {
					System.out.println("please enter the name");
					g = input.next();
					ch = 0;
				} else {

					System.out.println("please enter the part of the name");
					g = input.next();
					ch = 1;
				}
				b1.viewAccountDetails(n2, g, ch);
				break;
			case 6:
				System.out.println("please enter how search about your acount");
				System.out.println("1: your Id");
				System.out.println("2: Holder name");
				System.out.println("3: part of the neme");
				q = input.nextInt();
				while (q < 1 || q > 3) {
					System.out.println("please enter true value");
					q = input.nextInt();

				}
				g = " ";
				n2 = 0;
				ch = 0;
				if (q == 1) {
					System.out.println("please enter the Id");
					n2 = input.nextInt();
					ch = 1;
				} else if (q == 2) {
					System.out.println("please enter the name");
					g = input.next();
					ch = 0;
				} else {

					System.out.println("please enter the part of the name");
					g = input.next();
					ch = 1;
				}
				b1.modifyAccountDetails(n2, g, ch);
				break;
			default:
				System.out.println("please enter id of the account");

				q = input.nextInt();

				b1.closeAccount(q);
				break;
			}

			displayMainMenu();
			
	
				a=counter();
			
			
			
			
		}

		b1.updateDataFile();

		System.out.println("thank you ...");

	}

	public static void displayMainMenu() {
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println("please Please Select an Operation");
		System.out.println();
		System.out.println("1 : add account");
		System.out.println("2 : View All Accounts");
		System.out.println("3 : Add Amount");
		System.out.println("4 : Withdraw Amount");
		System.out.println("5 : View Account Details");
		System.out.println("6 : Modify Account");
		System.out.println("7 : Close an Account");
		System.out.println("8 : Exit");

	}
	public static int counter()
	{int counter=0;
	int d=0;
	
	boolean r=true;
	do {
		
		
		do{
			try {
	 System.out.println("please enter true value");
	 counter =input.nextInt();
		r=false;
		
		}catch(InputMismatchException e)
		{
			System.out.println("please enter numaric value");
			input.nextLine();
			
		}
			d=1;
		}while(r);
		
		
		
	}while(counter <0 || counter >8);
	
	
		return counter;
		
		
	}
	

}