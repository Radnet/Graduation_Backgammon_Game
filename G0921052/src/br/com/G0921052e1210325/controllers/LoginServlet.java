package br.com.G0921052e1210325.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.G0921052e1210325.beans.LoginBean;

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
		ServletContext application = getServletContext();
		
		LoginBean login = new LoginBean();
		login.setUserName(request.getParameter("userName"));
		login.setUserPassword(request.getParameter("userPassword"));
		
		if(login.getAutorize())
		{
			int cont;
			try
			{
				cont = ((Integer)application.getAttribute("contador"));
			}
			catch(Exception e)
			{
				cont = 0;
			}
			cont++;
			application.setAttribute ("contador", new Integer (cont));
			request.getRequestDispatcher("Waiting.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("loginResponse", false);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
	}

}
