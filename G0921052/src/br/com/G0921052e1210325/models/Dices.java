package br.com.G0921052e1210325.models;

import java.util.Random;

public class Dices {

	private DicesResult dicesResult;

	public DicesResult getDicesResult() {
		return dicesResult;
	}

	public void rool() {

		this.dicesResult = new DicesResult(generateRandomNumberForDice(), generateRandomNumberForDice());
	}

	public Moves getMoves() {

		return new Moves(this.dicesResult);
	}

	private int generateRandomNumberForDice() {
		Random rand = new Random();
		int randomNum = rand.nextInt((6 - 1) + 1) + 1;
		return randomNum;
	}
}
