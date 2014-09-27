package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

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
	public int getNumber() {
		return number;
	}
	public boolean isMovementOkForAvailableMoves(int origin, int destination) {
		List<Integer> moves = dices.getMoves().get();
		Integer movementLength = destination - origin;
		if(number == 2)
			movementLength = origin - destination;
		if(moves.contains(movementLength))
			return true;
		return false;
	}
	public void removeMovement(int origin, int destination) {
		Integer movementLength = destination - origin;
		if(number == 2)
			movementLength = origin - destination;
		dices.moves.removeMovement(movementLength);
	}
}
