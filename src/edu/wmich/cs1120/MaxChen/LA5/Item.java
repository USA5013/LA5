package edu.wmich.cs1120.MaxChen.LA5;

public class Item {
	public int id;
	public String title;
	public int availableQuantity;
	public double price;
	
	public Item() {
		
	}
	public Item(int id, String title, int availableQuantity, double price) {
		this.id = id;
		this.title = title;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}
	public String toString(){
		String Itemlist =  id + "-\t" + title + ",\t\t" + availableQuantity + " left\tprice: " + price;
		return Itemlist;
	}
}
