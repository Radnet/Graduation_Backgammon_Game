package br.com.G0921052e1210325.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.G0921052e1210325.models.Dices;
import br.com.G0921052e1210325.models.Game;
import br.com.G0921052e1210325.models.Player;
import br.com.G0921052e1210325.models.Point;
import br.com.G0921052e1210325.models.PointNumber;

/**
 * Servlet implementation class MovePieceServlet
 */
@WebServlet("/MovePieceServlet")
public class MovePieceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		Game game = Game.getGameInstance();
		
		// get origin and destination points
		int origin = Integer.parseInt(request.getParameter("origin"));
		int destination = Integer.parseInt(request.getParameter("destination"));
		Point pointOrigin = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[origin]);
		Point pointDestination = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[destination]);
		// get player and playerNumber
		Player player = (Player)session.getAttribute("player");
		// 1st step verifications
		if(!player.isMovimetOKforDiceResult(origin, destination))
		{
			
		}
		// 2nd step verifications
	}
}
