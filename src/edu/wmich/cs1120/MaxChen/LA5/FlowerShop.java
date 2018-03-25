package edu.wmich.cs1120.MaxChen.LA5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FlowerShop {
//	private static Scanner keyboard = new Scanner(System.in);
//	private static int ct = 0;
	static User Users = new User();
	public static CartItem cart;
	private static int ii = 0;
	/**
	 * @param args for main class
	 * @throws IOException 
	 *  Use a try-catch block in the main method instead of the “default” case,
	 *  you should have relevant catch clauses:
      	 i.  Use an appropriate type of exception if the input is not an integer.
      	 ii. You need to use a custom Exception (InvalidInputException) when the input is not 
       		one of the options on the menu.
	 */
	public static void main(String[] args) throws IOException {
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
		try  {
		welcome = getIntinput();
		
		}
		
		catch(InvalidInputException e){
			
			System.out.println("must be a Integer!");
			
		}
		switch (welcome) {
		case 1:
			System.out.println("Enter your UserName");
			String Suser = keyboard.next();
			System.out.println("Enter your password");
			String spass = keyboard.next();
			System.out.println("Enter your password again");
			String spass2 = keyboard.next();
			try {
				Users = checkSignUp(Suser, spass, spass2, lookup);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if (Users == null) {
					System.out.println("can't signed up");
				}
				else {
					System.out.println("signed up complete!");
				}
			
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
	 * @param lookup class
	 * @throws IOException 

	 * check the users login information
	*/
	public static void login(Lookup lookup) throws IOException {
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
			try {
				mainMenu(lookup);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}
	
	/**
	*
	* @param  userName all the sign up information
	*@param password1 all the sign up information
	*@param password2 all the sign up information
	*@param lookup all the sign up information
	* @return from the look up checkSignUpAuth 
	 * @throws Exception for some error
	 *
	 * check for user signUp information
	*/	
	public static User checkSignUp(String userName, String password1, String password2, Lookup lookup) throws Exception {
		
		return lookup.checkSignUpAuth(userName, password1, password2);
	}

	/**
	 
	 * @param lookup object
	 * @throws InvalidInputException class
	 * @throws IOException 
	 * Use a try-catch block in the main menu method instead of the “default” case,
	 *  you should have relevant catch clauses:
      	 i.  Use an appropriate type of exception if the input is not an integer.
      	 ii. You need to use a custom Exception (InvalidInputException) when the input is not 
       		one of the options on the menu.
	 */
	public static void mainMenu(Lookup lookup) throws InvalidInputException, IOException { 
//		CartItem cart;
		FileManager bill = null;
		Scanner keyboard = new Scanner(System.in);
		int ct = 0;
		while (ct<1) {
			ct=0;
			System.out.println("1- Flowers List\n2- My Cart\n3- Bill\n4- Exit\nSelect one of these options:");
			int main = 0;
			try  {
				main = getIntinput();
				
				}
				
				catch(InvalidInputException e){
					
					System.out.println("must be a Integer!");
					
				}
			switch (main) {
			case 1:
				lookup.printflower();
				System.out.println("Do you want to purchase an item(Y,N)?");
				
				
				String yorn = keyboard.next();
				
				
			
			 if(yorn.equals("Y")|| yorn.equals("y")){
					System.out.println("Enter flower id: ");
					int id = keyboard.nextInt();
					System.out.println("Enter the quantity: ");
					int number = keyboard.nextInt();

					if (id <= 10 && id >= 1) {
					if (sameflower(id)) {
						ii++;
						if (ii<4) {
							Users.addItemToTheLibrary(id,lookup.getItemById(id),number);
						}
					else {
						System.out.println("You cannot have more than three different types of the flowers");
						}
					}
					else {
						System.out.println("This flower’s id is not existing!");
					}
			 }
			 }
				else if (yorn.equals("N")|| yorn.equals("N")){
				}
				else {
					System.out.println("what!!! wrong in put, please choose N or Y");
				
				}
					
			 
				
				break;
			case 2:
				bill = Library();
				break;
			case 3:
				if (bill == null){
					System.out.println("You does not have a bill yet");
				}
				else {
					bill.readBill();
				}
				break;
			case 4:
					System.exit(0);
					break;
					
		}
			
				
		}
		
	}
	/**
	 * @return the bill of the total price
	 * @throws IOException
	 * 
	 * print the user's library, show the price and item, and see if they want pay yet.
	 */
	public static FileManager Library() throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		Lookup lookup = new Lookup();
		double tprice = 0;
		System.out.println("*************User Library*************");
		if (Users.i == 0) {
			System.out.println("your cart have no item");
			return null;
		}
		else {
				for(int i = 0 ; i < Users.i; i++) {
    		System.out.println(Users.library[i].toString());
    		tprice = tprice + Users.library[i].getprice();
    		
    		
		}	
				System.out.println("Total Price: $"+ tprice);	
				System.out.println("Do you want to purchase these items(Y,N)?");
				String yorn = keyboard.next();
				if(yorn.equals("Y")|| yorn.equals("y")){
					FileManager bill = new FileManager(lookup.username);
					bill.createBillFile(tprice);
					System.out.println("Your bill is available now!");
					return bill;
				 }
					else if (yorn.equals("N")|| yorn.equals("N")){
						System.out.println("ok");
						return null;
					}
					else {
						
						System.out.println("what!!! wrong in put, please choose N or Y");
					
					}
				return null;
						
		}
		
	}
	/**
	 * @return return the int user input in
	 * @throws InvalidInputException
	 * 
	 * see if user input have InputMismatchException
	 */
	public static int getIntinput() throws InvalidInputException{
		Scanner keyboard = new Scanner(System.in);
		try {
			return keyboard.nextInt();
		}
		catch(InputMismatchException e){
			throw new InvalidInputException();
		}
	}
	/**
	 * @return if user inputed the flower before
	 * @param id from user input
	 * check if user have input this id before
	 */
	public static boolean sameflower(int id) {
		for ( int i = 0; i < 3; i++) {
			int storeid = 0;
			try {
			storeid = Users.library[i].id;
			}
			catch(Exception e) {
			}
			
		if (storeid == id) {
			System.out.println("you already have this item");
			return false;
			}
		}
		return true;
	}

}
