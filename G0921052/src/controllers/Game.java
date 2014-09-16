package controllers;

import java.util.ArrayList;

import utils.Response;
import components.Board;
import components.Piece;
import components.Player;


public class Game {
	
	public Board gameBoard;
	
	public Response NewStartBoard(String player1Name, String player2Name)
	{
		Response response = new Response();
		
		//Setting Pieces
		ArrayList<Piece> list1 = new ArrayList<Piece>();
		ArrayList<Piece> list2 = new ArrayList<Piece>();
		int[] positions1 = {1,12,17,19};
		int[] positions2 = {24,13,8,6};
		int[] quantity = {2,5,3,5};
		for(int i=0 ; i<4 ;i++)
		{
			for(int j=quantity[i]; j<quantity[i]; j++)
			{
				Piece newPiece1 = new Piece(1,positions1[i]);
				Piece newPiece2 = new Piece(2,positions2[i]);
				list1.add(newPiece1);
				list2.add(newPiece2);
			}
		}
		
		//Setting Players
		Player player1 = new Player();
		Player player2 = new Player();
		player1.name = player1Name;
		player2.name = player2Name;
		player1.color = 1;
		player2.color = 2;
		player1.piecesList = list1;
		player2.piecesList = list2;
		
		//Setting Board
		gameBoard = new Board();
		gameBoard.player1 = player1;
		gameBoard.player2 = player2;
		
		return response;
	}
	
	public Response movePiece(int playerColor, int origin, int target)
	{
		Response response = new Response();
		Player player;
		Player opponent;
		//Validate positions
		if(origin < 0 || origin > 24 || target < 1 || target > 24)
		{
			response.error = true;
			response.errorMessage = "Movimento inválido. Origem ou destino não existe.";
		}
		//define player and opponent
		if(playerColor == 1)
		{
			player = gameBoard.player1;
			opponent = gameBoard.player2;
		}
		else
		{		
			player = gameBoard.player2;
			opponent = gameBoard.player1;
		}
		// Check movement is correct
		if(!player.hasPieceOnPosition(origin))
		{
			response.error = true;
			response.errorMessage = "Movimento inválido. Você não possui peças na origem selecionada.";
		}
		else if(opponent.has2OrMorePicesOnPosition(target))
		{
			response.error = true;
			response.errorMessage = "Movimento inválido. Seu oponente possui 2 ou mais peças no destino.";
		}
		// Ok, movement is correct, make it happen
		else
		{
			// If opponent has 1 piece on target
			if(opponent.hasPieceOnPosition(target))
			{
				opponent.getPiece(target).position = 0;
			}
			player.getPiece(origin).position = target;
		}
		
		return response;
	}

}
