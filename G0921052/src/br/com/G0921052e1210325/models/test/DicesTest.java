package br.com.G0921052e1210325.models.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.G0921052e1210325.models.AmountOfMoves;
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
	public void getAmountOfMoves_should_return_two_moves_if_dicesResult_are_not_equal() {

		Dices dicesMock = Mockito.mock(Dices.class);

		Mockito.when(dicesMock.getAmountOfMoves()).thenReturn(new AmountOfMoves(new DicesResult(2, 4)));

		AmountOfMoves amountOfMoves = dicesMock.getAmountOfMoves();

		Assert.assertEquals(2, amountOfMoves.getMoves().size());
		Assert.assertEquals(2, amountOfMoves.getMoves().get(0).intValue());
		Assert.assertEquals(4, amountOfMoves.getMoves().get(1).intValue());
	}
	
	@Test
	public void getAmountOfMoves_should_return_four_moves_if_dicesResult_are_equal() {

		Dices dicesMock = Mockito.mock(Dices.class);

		Mockito.when(dicesMock.getAmountOfMoves()).thenReturn(new AmountOfMoves(new DicesResult(5, 5)));

		AmountOfMoves amountOfMoves = dicesMock.getAmountOfMoves();

		Assert.assertEquals(4, amountOfMoves.getMoves().size());
		Assert.assertEquals(5, amountOfMoves.getMoves().get(0).intValue());
		Assert.assertEquals(5, amountOfMoves.getMoves().get(1).intValue());
		Assert.assertEquals(5, amountOfMoves.getMoves().get(2).intValue());
		Assert.assertEquals(5, amountOfMoves.getMoves().get(3).intValue());
	}

}
