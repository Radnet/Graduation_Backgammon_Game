package br.com.G0921052e1210325.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.G0921052e1210325.beans.GameResponseBean;
import br.com.G0921052e1210325.models.Game;
import br.com.G0921052e1210325.models.Player;
import br.com.G0921052e1210325.models.UserAccess;

/**
 * Servlet implementation class DiceServlet
 */
@WebServlet("/DiceServlet")
public class DiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int playerNumber = Integer.parseInt((String) session.getAttribute("playerNumber"));
		GameResponseBean gameResponse = (GameResponseBean) session.getAttribute("gameResponse");
		Player player = UserAccess.getUserAccessInstance().getUserByNumber(playerNumber);
		player.dices.rool();
		gameResponse.dice1 = Integer.toString(player.dices.getDicesResult().getFirstDice());
		gameResponse.dice2 = Integer.toString(player.dices.getDicesResult().getSecondDice());
		request.setAttribute("boardBean", Game.getGameInstance().getBoard().getBoardBean());
		request.getRequestDispatcher("BoardView.jsp").forward(request, response);
	}

}
