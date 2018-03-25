package edu.wmich.cs1120.MaxChen.LA5;


public class User {	
	public String username;
	public String password;
	public int id;
	public int i=0;
	CartItem[] library = new CartItem[3];
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
	public void addItemToTheLibrary(int id,Item item, int quantity){	
		i++;
		Lookup lookup = new Lookup();
		
		CartItem library = new CartItem(id, item);
		
		int q = library.setQuanytit(quantity);
		if(q == 0) {
				this.library[i-1] = library;
				System.out.println("added "+quantity+" "+lookup.getnamebyid(id)+" to cart");
			
			
		}
		else {
			System.out.println("The available quantity in the store is "+ lookup.getqbyid(id) + " flowers, and your ordered quantity is " + quantity + " flowers.");
		
		}
	}
}