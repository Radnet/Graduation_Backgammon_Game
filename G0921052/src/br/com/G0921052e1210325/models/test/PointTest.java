package br.com.G0921052e1210325.models.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.G0921052e1210325.models.Piece;
import br.com.G0921052e1210325.models.Player;
import br.com.G0921052e1210325.models.Point;
import br.com.G0921052e1210325.models.PointNumber;

public class PointTest {

	@Test
	public void isClosed_should_return_false_if_points_has_less_than_2_pieces() {

		Point p = new Point(PointNumber.Point1);

		Assert.assertFalse(p.isClosed());
	}

	@Test
	public void isClosed_should_return_false_if_points_has_less_than_2_pieces_and_owner_is_not_equal() {

		Point p = new Point(PointNumber.Point1);
		Player player = new Player();

		p.pushPiece(new Piece(1, player));
		p.pushPiece(new Piece(2, player));
		p.pushPiece(new Piece(3, player));
		p.pushPiece(new Piece(4, player));

		Assert.assertFalse(p.isClosed());
	}

	@Test
	public void pushPiece_should_return_true_if_points_are_not_closed() {

		Point p = new Point(PointNumber.Point1);

		Boolean result = p.pushPiece(new Piece(1, new Player()));

		Assert.assertTrue(result);
		Assert.assertEquals(1, p.getSize());
	}

	@Test
	public void pushPiece_should_return_false_if_points_are_closed() {

		Point p = new Point(PointNumber.Point1);
		p.pushPiece(new Piece(1, new Player()));
		p.pushPiece(new Piece(2, new Player()));

		Boolean result = p.pushPiece(new Piece(1, new Player()));

		Assert.assertFalse(result);
		Assert.assertEquals(2, p.getSize());
	}

	@Test
	public void pushPiece_should_set_owner_if_pieces_is_empty() {

		Point p = new Point(PointNumber.Point1);

		Player player = new Player();

		p.pushPiece(new Piece(1, player));

		Assert.assertEquals(1, p.getSize());
		Assert.assertEquals(player, p.getOwner());
	}

	@Test
	public void pop_piece_should_remove_piece_from_pieces_and_return_last_piece() {

		Point p = new Point(PointNumber.Point1);
		Player player = new Player();

		Piece piece1 = new Piece(1, player);
		Piece piece2 = new Piece(2, player);
		Piece piece3 = new Piece(3, player);

		p.pushPiece(piece1);
		p.pushPiece(piece2);
		p.pushPiece(piece3);

		Piece piece = p.popPiece();

		Assert.assertEquals(piece3, piece);
		Assert.assertEquals(2, p.getSize());
	}

	@Test
	public void pop_piece_should_return_null_if_pieces_is_empty() {

		Point p = new Point(PointNumber.Point1);

		Piece piece = p.popPiece();

		Assert.assertEquals(null, piece);
		Assert.assertEquals(0, p.getSize());
	}

}
