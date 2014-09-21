package br.com.G0921052e1210325.models.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.G0921052e1210325.models.Moves;
import br.com.G0921052e1210325.models.Dices;
import br.com.G0921052e1210325.models.DicesResult;

public class DicesTest {

	@Test
	public void roollDicesTest_should_return_DicesResult() {

		Dices dices = new Dices();
		dices.rool();

		Assert.assertNotEquals(null, dices.getDicesResult());
	}

	@Test
	public void getMoves_should_return_two_moves_if_dicesResult_are_not_equal() {

		Dices dicesMock = Mockito.mock(Dices.class);

		Mockito.when(dicesMock.getMoves()).thenReturn(new Moves(new DicesResult(2, 4)));

		Moves moves = dicesMock.getMoves();

		Assert.assertEquals(2, moves.get().size());
		Assert.assertEquals(2, moves.get().get(0).intValue());
		Assert.assertEquals(4, moves.get().get(1).intValue());
	}

	@Test
	public void getMoves_should_return_four_moves_if_dicesResult_are_equal() {

		Dices dicesMock = Mockito.mock(Dices.class);

		Mockito.when(dicesMock.getMoves()).thenReturn(new Moves(new DicesResult(5, 5)));

		Moves moves = dicesMock.getMoves();

		Assert.assertEquals(4, moves.get().size());
		Assert.assertEquals(5, moves.get().get(0).intValue());
		Assert.assertEquals(5, moves.get().get(1).intValue());
		Assert.assertEquals(5, moves.get().get(2).intValue());
		Assert.assertEquals(5, moves.get().get(3).intValue());
	}

}
