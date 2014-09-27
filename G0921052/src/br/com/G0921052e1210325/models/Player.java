package br.com.G0921052e1210325.models;

import java.util.ArrayList;

public class Player {
	public String name;
	public int number;
	public Dices dices;
	public Player opponent;
	public ArrayList<Piece> piecesList;
	
	public Player(){
	}
	public Player(String name, int number)
	{
		this.name = name;
		this.number = number;
		this.dices = new Dices();
	}
	
	public boolean hasPieceOnPosition(int position)
	{
		for(Piece piece : piecesList)
		{
			//if(piece.position == position)
				//return true;
		}
		return false;
	}
	public boolean has2OrMorePicesOnPosition(int position)
	{
		int count = 0;
		for(Piece piece : piecesList)
		{
			//if(piece.position == position)
				//count++;
		}
		if(count>=2)
			return true;
		return false;
	}
	public Piece getPiece(int position)
	{
		for(Piece piece : piecesList)
		{
			//if(piece.position == position)
				//return piece;
		}
		return null;
	}
	public int getNumber() {
		return number;
	}
	public boolean isMovimetOKforDiceResult(int origin, int destination)
	{
		//Dices
		int fDice = dices.getDicesResult().getFirstDice(); 
		int sDice = dices.getDicesResult().getSecondDice();
		int diceSum = fDice+sDice;
		//
		int movmentLength = destination - origin;
		if(this.number == 2)
		{
			movmentLength = origin - destination;
		}
		if(fDice == movmentLength)
		{
			return true;
		}
		else if(sDice == movmentLength)
		{
			return true;
		}
		else if(diceSum == movmentLength)
		{
			return true;
		}
		return false;
	}
}
