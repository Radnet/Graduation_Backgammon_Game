package br.com.G0921052e1210325.models.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.G0921052e1210325.models.AmountOfMoves;
import br.com.G0921052e1210325.models.DicesResult;

public class AmountOfMovesTest {

	@Test
	public void AmountOfMoves_should_return_two_moves_differents_if_dicesResult_are_not_equal() {
		
		DicesResult dr = new DicesResult(2,4);
		
		AmountOfMoves aom = new AmountOfMoves(dr);
		
		Assert.assertEquals(2, aom.getMoves().size());
		Assert.assertEquals(2, aom.getMoves().get(0).intValue());
		Assert.assertEquals(4, aom.getMoves().get(1).intValue());
	}

	
	@Test
	public void AmountOfMoves_should_return_four_moves_equals_if_dicesResult_are_equal() {
		
		DicesResult dr = new DicesResult(2,2);
		
		AmountOfMoves aom = new AmountOfMoves(dr);
		
		Assert.assertEquals(4, aom.getMoves().size());
		Assert.assertEquals(2, aom.getMoves().get(0).intValue());
		Assert.assertEquals(2, aom.getMoves().get(1).intValue());
		Assert.assertEquals(2, aom.getMoves().get(2).intValue());
		Assert.assertEquals(2, aom.getMoves().get(3).intValue());
	}

}
