package edu.wmich.cs1120.MaxChen.LA5;

public class CartItem {	
	public int id;
	public int quantitly = 0;
	public Item item = new Item();
	public Lookup lookup = new Lookup();
	public double tprice = 0;
	
	public CartItem (int id, Item item) {
		this.id = id;
		this.item = item;
	
	}
	public CartItem() {
		
	}
	
	/**
	 * 
	 * @param quantity
	 *  if user send quantity more than the available quantity in the store 
	 * 
	 * @return the quantity
	 */
	public int setQuanytit(int quantity) {
		quantitly = quantitly + quantity;
		if (quantity > lookup.getqbyid(id)) {
			return quantitly;
		}
		return 0;
		
		}
		
//		int oq = lookup.getqbyitem(item);
//		oq = lookup.getqbyitem(item) - quantity;
//		lookup.getqbyitem(item) = oq;
	
	/**
	 * @return the users library as string
	 * return the string 
	 */
	public String toString() {
		double price = lookup.getpricebyid(id)*quantitly;
		
		String cartlist = (lookup.getnamebyid(id)+" (Quantity: " + quantitly+"), price: " + price);
		
		return cartlist;
	}
	/**
	 * @return the 1 item's price
	 * calculate price and quantity
	 */
	public double getprice() {
		double price = lookup.getpricebyid(id)*quantitly;
		return price;
	}
	public String getname() {
		return lookup.getnamebyid(id);
	}
	
}


	