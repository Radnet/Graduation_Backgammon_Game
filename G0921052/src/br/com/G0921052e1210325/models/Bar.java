package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

public class Bar {

	private List<Piece> pieces;

	public List<Piece> getPieces() {
		return pieces;
	}
	
	public Bar()
	{
		pieces = new ArrayList<Piece>();
	}

	public void pushPiece(Piece piece) {
		this.pieces.add(piece);
	}
	
	public Boolean hasPiece(Player player){
		for (Piece piece : pieces) {
			if (piece.getOwner() == player) 
					return true;
			
		}
		return false;
	}
	
	public Piece popPiece(Player player) {
		Piece popedPiece = null;
		for (Piece piece : pieces) {
			if (piece.getOwner() == player) {
				popedPiece = piece;
				break;
			}
		}

		if (popedPiece != null)
			this.pieces.remove(popedPiece);
		return popedPiece;
	}

}
