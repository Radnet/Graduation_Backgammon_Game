package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		LoginBean login = new LoginBean();
		login.setUserName(request.getParameter("userName"));
		login.setUserPassword(request.getParameter("userPassword"));
		
		if(login.getAutorize())
			request.getRequestDispatcher("Waiting.jsp").forward(request, response);
		else
		{
			session.setAttribute("loginResponse", false);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
	}

}
