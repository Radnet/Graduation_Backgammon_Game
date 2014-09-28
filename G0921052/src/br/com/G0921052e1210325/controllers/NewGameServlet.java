package br.com.G0921052e1210325.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.G0921052e1210325.models.Game;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/NewGameServlet")
public class NewGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create a new game
		Game game = Game.getGameInstance();
		
		request.setAttribute("boardBean", game.getBoard().getBoardBean());
		
		request.getRequestDispatcher("BoardView.jsp").forward(request, response);
	}

}
