package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

public class Point {

	private PointNumber pointNumber;

	public PointNumber getPointNumber() {
		return pointNumber;
	}

	private List<Piece> pieces;

	private Player owner = null;

	public Player getOwner() {
		return owner;
	}

	public Point(PointNumber pointNumber) {
		this.pointNumber = pointNumber;
		this.pieces = new ArrayList<Piece>();
	}

	public Boolean isClosed() {

		Boolean isSameOwner = true;

		for (Piece piece : pieces) {

			if (piece.getOwner() != this.owner)
				isSameOwner = false;
		}

		return this.pieces.size() >= 2 && !isSameOwner;
	}

	public Boolean pushPiece(Piece piece) {

		if (isClosed())
			return false;

		if (this.pieces.size() == 0)
			this.owner = piece.getOwner();

		this.pieces.add(piece);

		return true;
	}

	public int getSize() {

		return this.pieces.size();
	}

	public Piece popPiece() {

		if(getSize() == 0)
			return null;
		
		int size = this.getSize() - 1;
		Piece popedPiece = this.pieces.get(size);
		this.pieces.remove(size);
		return popedPiece;

	}

}
