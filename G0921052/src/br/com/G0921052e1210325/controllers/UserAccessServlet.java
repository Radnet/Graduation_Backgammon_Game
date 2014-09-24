package br.com.G0921052e1210325.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.G0921052e1210325.beans.GameResponseBean;
import br.com.G0921052e1210325.models.Player;
import br.com.G0921052e1210325.models.UserAccess;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserAccessServlet")
public class UserAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		UserAccess userAccess = UserAccess.getUserAccess();
		GameResponseBean gameResponse = new GameResponseBean();
		Player player = userAccess.tryCreatePlayer(request.getParameter("userName"), request.getParameter("userPassword"), gameResponse);
		if(gameResponse.error)
		{
			session.setAttribute("gameResponse", gameResponse);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("player", player);
			// If both players are logged
			if(userAccess.getPlayer1()!= null && userAccess.getPlayer2()!= null)
				application.setAttribute("allPlayersLogged", "ok");
			request.getRequestDispatcher("Waiting.jsp").forward(request, response);
		}
	}

}
