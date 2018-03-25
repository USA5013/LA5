package edu.wmich.cs1120.MaxChen.LA5;
import java.util.regex.*;

public class Lookup{
	
	public User[] userList;
	public Item[] storeItemList;		
	public int usernum = 2;
	public String username;
	
	public Lookup() {		
		userList = createUsers();
		storeItemList = loadItems();
		
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return Return the user object if it exist
	 * @throws 
	 * An appropriate exception should be thrown for the following scenarios: 
	 * 1- if username doesn't exist.
	 * 2- Password doesn’t exist
	 */	
	public User checkLoginAuth(String userName, String password) {
		
		for ( int i = 0; i < usernum; i++) {
			if (userList[i].username.equals(userName)  && userList[i].password.equals(password)){
				username = userName;
				return userList[i];
		}
		}
		return null;
	}

	/**	 
	 * @param userName
	 * @param password1
	 * @param password2
	 * @return
	 * @throws 
	 *  An appropriate exception should be thrown for the following scenarios:
        * 1.     A user is trying to signup using a username that already exists.
        * 2.     A user tries to login with a username that doesn’t exist.
        * 3.     A user enters the wrong password.
        * 4.     When a user enters password a second time, it doesn’t match the first password.
        * 5.     If password length is less than 6 characters
        * 6.     If the password is not valid
	 * 
	 */
	public User checkSignUpAuth(String userName, String password1, String password2) throws Exception {	
	
		
		if (password1.equals(password2)) {
			
			for ( int i = 0; i < 10; i++) {
				if (userList[i].username.equals(userName)) {
					System.out.println("the user name is already exist.");
					return null;
				}
				else if (password1.length() < 6){
					System.out.println("password need to be 6 characters or longer.");
					return null;
				}
				else if (isValidPassword(password1) == null) {
					System.out.println("password is not valid");
					return null;
				}
				else if (isValidPassword(password1) == password1){
					
					userList[usernum] = addUserToTheList(userName, password1);
					
					return userList[usernum-1];
				}
				else {
					System.out.println("something wrong");
					return null;
				}
			}
		}
		else if (password1 != password2){
			System.out.println("first password have to match second password");
			return null;
			
		}
		return null;
	}	
	/**
	 * The method checks if the password is valid or not:
	 * password should contains:
	 * 1- at least one digit one specific characters
	 * 2- at least on lower case letter
	 * 3- at least one upper case letter
	 * 4- at least one number	
	 * @param password
	 * @return: The method returns message error if the password is not valid,
	 *  and returns null if the password is valid
	 */
	public String isValidPassword(String password)
	{
		char character;
		int digit = 0;
		int upperCase = 0;
		int lowerCase = 0;
		int number = 0;
		
		Pattern charCheck = Pattern.compile("[a-zA-Z0-9]*");
		Matcher match = charCheck.matcher(password);
	 
	      if (!match.matches()) {
	           digit++;
	      }

		for(int i = 0; i < password.length(); i++)
		{
			character = password.charAt(i);
			if(Character.isUpperCase(character))
			{
				upperCase++;
			}
			if(Character.isLowerCase(character))
			{
				lowerCase++;
			}
			if(Character.isDigit(character))
			{
				number++;
			}
		}
		
		if(digit == 0)
		{
			System.out.println("Must have one character.");
			password = null;
		}
		if(upperCase == 0)
		{
			System.out.println("Must have one upper case.");
			password = null;
		}
		if(lowerCase == 0)
		{
			System.out.println("Must have one lower case.");
			password = null;
		}
		if(number == 0)
		{
			System.out.println("Must have one number.");
			password = null;
		}
		
		return password;
	}
	public User[] getUserList() {
		return userList;
	}

	public void setUserList(User[] userList) {
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * This method add new user to the user array
	 * @return user
	 */
	public User addUserToTheList(String userName, String password) {
		usernum++;
		User list = new User(usernum, userName, password);
		return list;
		
	}
	
	/**
	 * This method adds two users to the user list,
	 * "You should not change these users, but you
	 * can add new users
	 */
	public User[] createUsers() {
		User[] list = new User[10];
		
		list[0] = new User(1, "sara", "123"); // Constructor’s arguments:  (id, username, password)
		list[1] = new User(2, "adam", "321");
		return list;
	}

	/**
	 * This method load data to the item list, this list has all the
	 * items in your application "You should not change these data
	 * but you can add new items".
	 * 
	 */
	public Item[] loadItems() {
		Item[] itemList = new Item[10];
		itemList[0] = new Item(1, "Tulip", 10, 3.00);// Constructor’s arguments:(title, quantity, price)
		itemList[1] = new Item(2, "Calla", 15, 3.00);
		itemList[2] = new Item(3, "Gerbera", 15, 2.00);
		itemList[3] = new Item(4, "Rose", 30, 2.00);
		itemList[4] = new Item(5, "Purple Mallow", 12, 2.00);
		itemList[5] = new Item(6, "Bergenia", 8, 1.80);
		itemList[6] = new Item(7, "Baneberry", 20, 1.95);
		itemList[7] = new Item(8, "Aster", 25, 1.50);
		itemList[8] = new Item(9, "Sunflower", 8, 1.00);
		itemList[9] = new Item(10, "Gladiolus", 10, 0.75);
		
		return itemList;	
      }
	/**
	 * This method searches for the item by its key
	 * and then return the item object if the item exist
	 * else return null 
	 */
	public void printflower() {
		
		for (int i = 0; i < storeItemList.length; i++) {
		System.out.println(storeItemList[i].toString());
		}
	}
	public Item getItemById(int key) {
		for (int i = 0 ; i < 10; i++) {
			if(key == storeItemList[i].id) {
				return storeItemList[i];
			}
		}
			return null;
		}
	public int getqbyid(int key) {
		for (int i = 0 ; i < 10; i++) {
			if(key == storeItemList[i].id) {
		return storeItemList[i].availableQuantity;
			}
		}
		return 0;
	}
	public double getpricebyid(int key) {
		for (int i = 0 ; i < 10; i++) {
			if(key == storeItemList[i].id) {
				return storeItemList[i].price;
			}
		}
		return 0;
	}
	public String getnamebyid(int key) {
		
		for (int i = 0 ; i < 10; i++) {
			if(key == storeItemList[i].id) {
		return storeItemList[i].title;
			}
		}
		return "noo";
	}
}

