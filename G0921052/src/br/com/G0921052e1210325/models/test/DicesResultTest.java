package br.com.G0921052e1210325.models.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.G0921052e1210325.models.DicesResult;

public class DicesResultTest {

	@Test
	public void IsEqual_should_return_true_if_first_and_second_dice_result_are_equal() {
		DicesResult dr = new DicesResult(2, 2);

		Assert.assertTrue(dr.isEqual());
	}

	@Test
	public void IsEqual_should_return_false_if_first_and_second_dice_result_are_not_equal() {
		DicesResult dr = new DicesResult(2, 5);

		Assert.assertFalse(dr.isEqual());
	}
}
