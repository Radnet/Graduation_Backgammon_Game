package br.com.G0921052e1210325.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.G0921052e1210325.beans.GameResponseBean;

public class UserAccess {

	private Player player1;
	private Player player2;

	private static List<String> pieceColors = new ArrayList<String>();

	private static UserAccess userAccess;

	private UserAccess() {
		player1 = null;
		player2 = null;

		pieceColors.add("black-piece");
		pieceColors.add("blue-piece");
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public static UserAccess getUserAccessInstance() {
		if (userAccess == null)
			userAccess = new UserAccess();
		return userAccess;
	}

	public Player tryCreatePlayer(String name, String password, GameResponseBean response) {
		authorizeLogin(name, password, response);
		if (!response.error) {

			if (player1 == null) {

				Random rand = new Random();
				int colorForPlayer1 = rand.nextInt((2 - 1) + 1) + 1;

				String color = pieceColors.get(colorForPlayer1 - 1);
				pieceColors.remove(color);

				player1 = new Player(name, 1, color);
				return player1;
			} else {

				String color = pieceColors.get(0);

				player2 = new Player(name, 2, color);
				// set opponents
				player1.opponent = player2;
				player2.opponent = player1;
				return player2;
			}
		}
		return null;
	}

	private void authorizeLogin(String name, String password, GameResponseBean response) {
		// Verifying credentials
		if (!getAutorize(name, password)) {
			response.error = true;
			response.errorMessage = "Combinação Login-senha errado!";
		}
		// Verifying number of players
		else if (player1 != null && player2 != null) {
			response.error = true;
			response.errorMessage = "Numero de jogadores excedido!";
		}
		// Verifying repeated login credential
		else if (player1 != null && name.equals(player1.name)) {
			response.error = true;
			response.errorMessage = "Jogador já está logado!";
		} else
			response.error = false;
	}

	private boolean getAutorize(String userName, String userPassword) {
		boolean autorize;
		// If user name anda password is correct
		if (userName.equals("banana") && userPassword.equals("pera"))
			autorize = true;
		else if (userName.equals("abacaxi") && userPassword.equals("uva"))
			autorize = true;
		else
			autorize = false;
		return autorize;
	}

	public Player getUserByNumber(int number) {
		if (number == 1)
			return player1;
		return player2;
	}
}
