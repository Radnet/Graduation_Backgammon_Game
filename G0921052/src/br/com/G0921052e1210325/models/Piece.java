package br.com.G0921052e1210325.models;

public class Piece {
	
	public int color;
	
	private Player owner;
	
	public Player getOwner() {
		return owner;
	}

	public Piece(Player owner)
	{
		this.owner = owner;
		this.color = owner.getNumber();
	}
}
