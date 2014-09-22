package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Point> points;

	public Board(Player player1, Player player2) {
		setupPoints();
		setupPointsForPlayers(player1, player2);

	}

	public Point findPoint(PointNumber pointNumber) {

		for (Point point : points) {
			if (point.getPointNumber() == pointNumber)
				return point;
		}
		return null;
	}

	public int getPointSize() {
		return this.points.size();
	}

	public int getNumberOfPieceOf(Player player1) {

		int count = 0;

		for (Point point : points) {
			if (point.getOwner() == player1)
				count += point.getSize();
		}

		return count;

	}

	private void FillPoint(PointNumber pointNumber, Player player, int total) {

		Point point = findPoint(pointNumber);

		for (int i = 0; i < total; i++) {
			point.pushPiece(new Piece(player));
		}
	}

	private void setupPoints() {
		this.points = new ArrayList<Point>();

		for (PointNumber pointNumber : PointNumber.class.getEnumConstants()) {

			Point point = new Point(pointNumber);

			this.points.add(point);
		}
	}

	private void setupPointsForPlayers(Player player1, Player player2) {

		// for player 1
		FillPoint(PointNumber.Point1, player1, 2);
		FillPoint(PointNumber.Point6, player1, 5);
		FillPoint(PointNumber.Point8, player1, 3);
		FillPoint(PointNumber.Point12, player1, 5);

		// for player 2
		FillPoint(PointNumber.Point24, player2, 2);
		FillPoint(PointNumber.Point19, player2, 5);
		FillPoint(PointNumber.Point17, player2, 3);
		FillPoint(PointNumber.Point13, player2, 5);
	}

}
