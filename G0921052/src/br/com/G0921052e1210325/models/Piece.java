package br.com.G0921052e1210325.models;

public class Piece {
	
	public int color;
	
	private Player owner;
	
	public Player getOwner() {
		return owner;
	}

	public Piece(int color, Player owner)
	{
		this.color = color;
		this.owner = owner;
	}
}
