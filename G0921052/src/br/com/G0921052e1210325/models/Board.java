package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

import br.com.G0921052e1210325.beans.BoardBean;

public class Board {

	private List<Point> points;
	private Bar bar; 

	public Bar getBar() {
		return bar;
	}

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

	public Point findPoint(int number) {
		PointNumber pointNumber;
		if (number == 1)
			pointNumber = PointNumber.Point1;
		else if (number == 2)
			pointNumber = PointNumber.Point2;
		else if (number == 3)
			pointNumber = PointNumber.Point3;
		else if (number == 4)
			pointNumber = PointNumber.Point4;
		else if (number == 5)
			pointNumber = PointNumber.Point5;
		else if (number == 6)
			pointNumber = PointNumber.Point6;
		else if (number == 7)
			pointNumber = PointNumber.Point7;
		else if (number == 8)
			pointNumber = PointNumber.Point8;
		else if (number == 9)
			pointNumber = PointNumber.Point9;
		else if (number == 10)
			pointNumber = PointNumber.Point10;
		else if (number == 11)
			pointNumber = PointNumber.Point11;
		else if (number == 12)
			pointNumber = PointNumber.Point12;
		else if (number == 13)
			pointNumber = PointNumber.Point13;
		else if (number == 14)
			pointNumber = PointNumber.Point14;
		else if (number == 15)
			pointNumber = PointNumber.Point15;
		else if (number == 16)
			pointNumber = PointNumber.Point16;
		else if (number == 17)
			pointNumber = PointNumber.Point17;
		else if (number == 18)
			pointNumber = PointNumber.Point18;
		else if (number == 19)
			pointNumber = PointNumber.Point19;
		else if (number == 20)
			pointNumber = PointNumber.Point20;
		else if (number == 21)
			pointNumber = PointNumber.Point21;
		else if (number == 22)
			pointNumber = PointNumber.Point22;
		else if (number == 23)
			pointNumber = PointNumber.Point23;
		else
			pointNumber = PointNumber.Point24;
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
				count += point.getPieceQuantity();
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
		
		bar = new Bar();
		
	}

	private void setupPointsForPlayers(Player player1, Player player2) {

		// for player 1
		FillPoint(PointNumber.Point1, player1, 2);
		FillPoint(PointNumber.Point6, player2, 5);
		FillPoint(PointNumber.Point8, player2, 3);
		FillPoint(PointNumber.Point12, player1, 5);

		// for player 2
		FillPoint(PointNumber.Point24, player2, 2);
		FillPoint(PointNumber.Point19, player1, 5);
		FillPoint(PointNumber.Point17, player1, 3);
		FillPoint(PointNumber.Point13, player2, 5);

		// for empty points
		FillPoint(PointNumber.Point2, null, 0);
		FillPoint(PointNumber.Point3, null, 0);
		FillPoint(PointNumber.Point4, null, 0);
		FillPoint(PointNumber.Point5, null, 0);
		FillPoint(PointNumber.Point7, null, 0);
		FillPoint(PointNumber.Point9, null, 0);
		FillPoint(PointNumber.Point10, null, 0);
		FillPoint(PointNumber.Point11, null, 0);
		FillPoint(PointNumber.Point14, null, 0);
		FillPoint(PointNumber.Point15, null, 0);
		FillPoint(PointNumber.Point16, null, 0);
		FillPoint(PointNumber.Point18, null, 0);
		FillPoint(PointNumber.Point20, null, 0);
		FillPoint(PointNumber.Point21, null, 0);
		FillPoint(PointNumber.Point22, null, 0);
		FillPoint(PointNumber.Point23, null, 0);
	}

	public BoardBean getBoardBean() {

		BoardBean boardBean = new BoardBean();

		for (PointNumber pointNumber : PointNumber.class.getEnumConstants()) {

			Point p = findPoint(pointNumber);

			Player player1 = UserAccess.getUserAccessInstance().getPlayer1();
			Player player2 = UserAccess.getUserAccessInstance().getPlayer2();
			
			if (p.getOwner() == player1) {
				boardBean.setFor(p.getPointNumber(), p.getPieceQuantity(), player1.getColor());
			} else {
				boardBean.setFor(p.getPointNumber(), p.getPieceQuantity(), player2.getColor());
			}
		}
	
		boardBean.setBarFor(this.bar.getPieces());
		
		return boardBean;
	}
}
