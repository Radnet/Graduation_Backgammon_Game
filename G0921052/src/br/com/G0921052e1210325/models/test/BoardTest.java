package br.com.G0921052e1210325.models.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.G0921052e1210325.models.Board;
import br.com.G0921052e1210325.models.Player;
import br.com.G0921052e1210325.models.Point;
import br.com.G0921052e1210325.models.PointNumber;

public class BoardTest {

	@Test
	public void initial_state_of_points() {

		Board board = new Board(new Player(), new Player());

		List<PointNumber> expectedPoints = new ArrayList<PointNumber>();
		for (PointNumber pn : PointNumber.class.getEnumConstants())
			expectedPoints.add(pn);

		Assert.assertEquals(expectedPoints.size(), board.getPointSize());

		for (int i = 0; i < board.getPointSize(); i++) {
			Assert.assertEquals(expectedPoints.get(i), board.findPoint(expectedPoints.get(i)).getPointNumber());
		}

	}

	@Test
	public void initial_state_of_points_by_player1() {

		Player player1 = new Player();
		Player player2 = new Player();

		Board board = new Board(player1, player2);

		List<PointNumber> player1PointsNumbers = new ArrayList<PointNumber>();
		player1PointsNumbers.add(PointNumber.Point1);
		player1PointsNumbers.add(PointNumber.Point6);
		player1PointsNumbers.add(PointNumber.Point8);
		player1PointsNumbers.add(PointNumber.Point12);

		List<Integer> player1PiecesInPoint = new ArrayList<Integer>();
		player1PiecesInPoint.add(2);
		player1PiecesInPoint.add(5);
		player1PiecesInPoint.add(3);
		player1PiecesInPoint.add(5);

		for (int i = 0; i < 4; i++) {

			Point point = board.findPoint(player1PointsNumbers.get(i));

			Assert.assertEquals(player1PiecesInPoint.get(i).intValue(), point.getSize());
			Assert.assertEquals(player1, point.getOwner());
		}
	}

	@Test
	public void initial_state_of_points_by_player2() {

		Player player1 = new Player();
		Player player2 = new Player();

		Board board = new Board(player1, player2);

		List<PointNumber> player2PointsNumbers = new ArrayList<PointNumber>();
		player2PointsNumbers.add(PointNumber.Point13);
		player2PointsNumbers.add(PointNumber.Point17);
		player2PointsNumbers.add(PointNumber.Point19);
		player2PointsNumbers.add(PointNumber.Point24);

		List<Integer> player2PiecesInPoint = new ArrayList<Integer>();
		player2PiecesInPoint.add(5);
		player2PiecesInPoint.add(3);
		player2PiecesInPoint.add(5);
		player2PiecesInPoint.add(2);

		for (int i = 0; i < 4; i++) {

			Point point = board.findPoint(player2PointsNumbers.get(i));

			Assert.assertEquals(player2PiecesInPoint.get(i).intValue(), point.getSize());
			Assert.assertEquals(player2, point.getOwner());
		}
	}
	
	@Test
	public void initial_state_of_board_number_of_piece_for_player1() {
		
		Player player1 = new Player();
		Player player2 = new Player();

		Board board = new Board(player1, player2);
		
		int result =  board.getNumberOfPieceOf(player1);
		
		Assert.assertEquals(15, result);
	}

	@Test
	public void initial_state_of_board_number_of_piece_for_player2() {
		
		Player player1 = new Player();
		Player player2 = new Player();

		Board board = new Board(player1, player2);
		
		int result =  board.getNumberOfPieceOf(player2);
		
		Assert.assertEquals(15, result);
	}
}
