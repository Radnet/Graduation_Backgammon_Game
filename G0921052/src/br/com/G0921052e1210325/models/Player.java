package br.com.G0921052e1210325.models;

import java.util.ArrayList;

public class Player {
	public String name;
	public int color;
	public ArrayList<Piece> piecesList;
	
	public boolean hasPieceOnPosition(int position)
	{
		for(Piece piece : piecesList)
		{
			if(piece.position == position)
				return true;
		}
		return false;
	}
	public boolean has2OrMorePicesOnPosition(int position)
	{
		int count = 0;
		for(Piece piece : piecesList)
		{
			if(piece.position == position)
				count++;
		}
		if(count>=2)
			return true;
		return false;
	}
	public Piece getPiece(int position)
	{
		for(Piece piece : piecesList)
		{
			if(piece.position == position)
				return piece;
		}
		return null;
	}
}
