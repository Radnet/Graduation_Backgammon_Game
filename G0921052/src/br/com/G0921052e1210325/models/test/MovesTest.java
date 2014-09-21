package br.com.G0921052e1210325.models.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.G0921052e1210325.models.Moves;
import br.com.G0921052e1210325.models.DicesResult;

public class MovesTest {

	@Test
	public void Moves_should_return_two_moves_differents_if_dicesResult_are_not_equal() {
		
		DicesResult dr = new DicesResult(2,4);
		
		Moves aom = new Moves(dr);
		
		Assert.assertEquals(2, aom.get().size());
		Assert.assertEquals(2, aom.get().get(0).intValue());
		Assert.assertEquals(4, aom.get().get(1).intValue());
	}

	
	@Test
	public void Moves_should_return_four_moves_equals_if_dicesResult_are_equal() {
		
		DicesResult dr = new DicesResult(2,2);
		
		Moves aom = new Moves(dr);
		
		Assert.assertEquals(4, aom.get().size());
		Assert.assertEquals(2, aom.get().get(0).intValue());
		Assert.assertEquals(2, aom.get().get(1).intValue());
		Assert.assertEquals(2, aom.get().get(2).intValue());
		Assert.assertEquals(2, aom.get().get(3).intValue());
	}

}
