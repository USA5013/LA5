package edu.wmich.cs1120.MaxChen.LA5;

public class CartItem {	
	public int id;
	public int quantitly;
	public Item item = new Item();
	
	public CartItem (int id, Item item) {
		
	}
	/**
	 * 
	 * @param quantity
	 * @throws Exception if user send quantity more than the available quantity in the store 
	 */
	public void setQuantity(int quantity) throws InvalidInputException {
		quantitly = quantity;
	} 
	public String toString() {
		return null;
	}
}


	