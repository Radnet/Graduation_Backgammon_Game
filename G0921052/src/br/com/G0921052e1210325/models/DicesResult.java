package br.com.G0921052e1210325.models;

public class DicesResult {

	private int firstDice;
	private int secondDice;

	public int getFirstDice() {
		return firstDice;
	}

	public int getSecondDice() {
		return secondDice;
	}

	public DicesResult(int first, int second) {
		this.firstDice = first;
		this.secondDice = second;
	}
	
	public Boolean isEqual(){
		return this.firstDice == this.secondDice;
	}
}
