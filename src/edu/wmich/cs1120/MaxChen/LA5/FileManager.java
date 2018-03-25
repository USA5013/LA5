package edu.wmich.cs1120.MaxChen.LA5;

import java.io.*;


public class FileManager {
	
	// File name equals to username
	private String fileName = "bill.txt";
	private double total;
	public FileManager(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @throws IOExceptions
	 * @param total
	 * Catch an appropriate type of exception if there is a problem while creating or writing on the file.
	 */
	public void createBillFile(double total) throws IOException{
		try {
			FileWriter File = new FileWriter(fileName);
			PrintWriter print = new PrintWriter(File);
			
			print.println("Your bill balance is $" + total + "\n");
			print.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("the file is not exist");
		}
		this.total = total;
	}

	
	/**
	 * @throws InvalidInputException
	 * Based on the problem, you need to Catch an appropriate type of exception:
	 * You should handle the exceptions for these cases.
	 * 1- if user does not have a bill yet.
	 * 2- if the problem happened while reading the file.  
	 */
	@SuppressWarnings("resource")
	public void readBill() throws InvalidInputException{
		try {
			FileReader read = new FileReader(fileName);
			
			BufferedReader buff = new BufferedReader(read);
			
			String inthefile;
			inthefile = buff.readLine();
			System.out.println(inthefile);
			
			if (inthefile == null) {
				throw new InvalidInputException("Bill not found");
				
			}
			buff.close();
		}
		catch(InvalidInputException e) {
			System.err.println("not right input");
		}
		catch(IOException e) {
			System.err.println("the file is not exist");
		}
       }
}

