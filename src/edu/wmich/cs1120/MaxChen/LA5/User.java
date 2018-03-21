package edu.wmich.cs1120.MaxChen.LA5;


public class User {	
	public String username;
	public String password;
	public int id;
	public int i=0;
	Item[] library = new Item[100];
	public User(int id, String username, String password) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
	 public User() {
			// TODO Auto-generated constructor stub
		}
	/**
	 * 
	 * @param item
	 * @param quantity
	 * @throws an appropriate exception if the user try to add more than three items to the cart list, and
	 *  if there is a thrown exception from setQuantity method.
	 */
	public void addItemToTheLibrary(Item item, int quantity) throws InvalidInputException{	
		
		library[i] = item;
	
		i++;
	}
}
