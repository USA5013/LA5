package edu.wmich.cs1120.MaxChen.LA5;

public class InvalidInputException extends Exception {
private String mess;
	public InvalidInputException() {
		
	}
	public InvalidInputException(String mess) {
		this.mess = mess;
	}
	public String getmess() {
		return mess;
	}
}
