package edu.wmich.cs1120.MaxChen.LA5;

import java.util.Scanner;

public class FlowerShop {
//	private static Scanner keyboard = new Scanner(System.in);
//	private static int ct = 0;
	/**
	 * Use a try-catch block in the main method instead of the “default” case,
	 *  you should have relevant catch clauses:
      	 i.  Use an appropriate type of exception if the input is not an integer.
      	 ii. You need to use a custom Exception (InvalidInputException) when the input is not 
       		one of the options on the menu.
	 * @param args
	 */
	public static void main(String[] args) {
		Lookup lookup = new Lookup();
		Scanner keyboard = new Scanner(System.in);
		
		int ct = 0;
		while(ct < 1) {
			ct = 0;
		System.out.println("Welcome to our Flowers Shop!");
		System.out.println("1- SignUp");
		System.out.println("2- Login");
		System.out.println("3- Exit\nSelect one of these options");
		int welcome = 0;
//		try {
		welcome = keyboard.nextInt();
//		}
//		catch(java.util.InputMismatchException e){
//			System.out.println("The input is not an integer");
//		}
		switch (welcome) {
		case 1:
			System.out.println("Enter your UserName");
			String Suser = keyboard.nextLine();
			System.out.println("Enter your password");
			String spass = keyboard.nextLine();
			System.out.println("Enter your password again");
			String spass2 = keyboard.nextLine();
			checkSignUp(Suser, spass, spass2, lookup);
			ct++;
		    break;
		case 2:
			login(lookup);
			ct++;
			break;
		case 3:
			ct++;
			break;
		}
		}
		
	}	

	/**
	* Catch an appropriate type of exception
	*/
	public static void login(Lookup lookup) {
		Scanner keyboard = new Scanner(System.in);
		int ct = 0;
		while(ct < 1) {
			ct = 0;
		System.out.println("Enter your UserName: ");
		String username = keyboard.nextLine();
		System.out.println("Enter your Password: ");
		String password = keyboard.nextLine();
		if(lookup.checkLoginAuth(username,password)==null) {
			System.out.println("Incorrect username or password");
		}
		else {
			System.out.println("Login Successful!");
			mainMenu(lookup);
			}
		}
		
	}
	
	/**
	* Catch an appropriate type of exception
	*/	
	public static User checkSignUp(String userName, String password1, String password2, Lookup lookup) {
		return null;
	}

	/**
	 * Use a try-catch block in the main menu method instead of the “default” case,
	 *  you should have relevant catch clauses:
      	 i.  Use an appropriate type of exception if the input is not an integer.
      	 ii. You need to use a custom Exception (InvalidInputException) when the input is not 
       		one of the options on the menu.
	 * @param args
	 */
	public static void mainMenu(Lookup lookup) { 
		Scanner keyboard = new Scanner(System.in);
		int ct = 0;
		while (ct<1) {
			ct=0;
			System.out.println("1- Flowers List\n2- My Cart\n3- Bill\n4- Exit\nSelect one of these options:");
			int main =  keyboard.nextInt();
			switch (main) {
			case 1:
				lookup.printflower();
				System.out.println("Do you want to purchase an item(Y,N)?");
//				
				String yorn ="Y";
				yorn = keyboard.nextLine();
				if (yorn.equals("N") || yorn.equals("n")) {
					ct++;
				}
				else if(yorn.equals("Y")|| yorn.equals("y")){
					System.out.println("Enter flower id: ");
					int id = keyboard.nextInt();
					System.out.println("Enter the quantity: ");
					int number = keyboard.nextInt();
//					ct++;
				}
				else {
					System.out.println("wtf!!!");
					System.out.println(yorn);
					System.out.println(keyboard.nextLine());
				}
				
				break;
			case 2:
				
			case 3:
					
			case 4:
					System.exit(0);
					break;
					
		}
			
				
		}
		
	}

}
