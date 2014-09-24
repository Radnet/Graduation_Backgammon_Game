package br.com.G0921052e1210325.models;

public class Game {
	
	private static Game game;
	private static Board board;
	private Game(){
		
	}
	public static Game getGameInstance(){
		if(game == null)
		{
			game = new Game();
			// New Board
			UserAccess userAccess = UserAccess.getUserAccess();
			board = new Board(userAccess.getPlayer1(),userAccess.getPlayer2());
		}
		return game;
	}
	public Board getBoard() {
		return board;
	}
	
}
