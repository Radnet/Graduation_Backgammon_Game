package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;

public class Moves {

	private List<Integer> moves = new ArrayList<Integer>();

	public Moves(DicesResult dicesResult) {

		addMove(dicesResult);
	}

	private void addMove(DicesResult dicesResult) {
		if (dicesResult.isEqual()) {
			this.moves.add(dicesResult.getFirstDice());
			this.moves.add(dicesResult.getFirstDice());
			this.moves.add(dicesResult.getFirstDice());
			this.moves.add(dicesResult.getFirstDice());
		} else {
			this.moves.add(dicesResult.getFirstDice());
			this.moves.add(dicesResult.getSecondDice());
		}
	}

	public List<Integer> get() {
		return new ArrayList<Integer>(this.moves);
	}
}
