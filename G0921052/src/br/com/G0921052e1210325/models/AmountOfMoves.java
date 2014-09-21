package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

public class AmountOfMoves {

	private List<Integer> housesToMove = new ArrayList<Integer>();

	public AmountOfMoves(DicesResult dicesResult) {

		addMoves(dicesResult);
	}

	private void addMoves(DicesResult dicesResult) {
		if (dicesResult.isEqual()) {
			this.housesToMove.add(dicesResult.getFirstDice());
			this.housesToMove.add(dicesResult.getFirstDice());
			this.housesToMove.add(dicesResult.getFirstDice());
			this.housesToMove.add(dicesResult.getFirstDice());
		} else {
			this.housesToMove.add(dicesResult.getFirstDice());
			this.housesToMove.add(dicesResult.getSecondDice());
		}
	}

	public List<Integer> getMoves() {
		return new ArrayList<Integer>(this.housesToMove);
	}
}
