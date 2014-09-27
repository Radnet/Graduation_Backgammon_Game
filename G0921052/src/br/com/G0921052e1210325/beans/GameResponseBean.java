package br.com.G0921052e1210325.beans;

public class GameResponseBean {
	public boolean error;
	public String errorMessage;
	public String dice1;
	public String dice2;
	public GameResponseBean()
	{
		error = false;
		errorMessage = "";
		dice1 = "";
		dice2 = "";	
	}
}
