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
import br.com.G0921052e1210325.models.Board;
import br.com.G0921052e1210325.models.Dices;
import br.com.G0921052e1210325.models.Game;
import br.com.G0921052e1210325.models.Piece;
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
		GameResponseBean resultBean = new GameResponseBean(); 
		
		// get origin and destination points
		int origin = Integer.parseInt(request.getParameter("origin"));
		int destination = Integer.parseInt(request.getParameter("destination"));
		Point pointOrigin = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[origin]);
		Point pointDestination = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[destination]);
		// get player and opponent
		Player player = (Player)session.getAttribute("player");
		
		// Movement compatible with dices
		if(!player.isMovimetOKforDiceResult(origin, destination))
		{
			resultBean.error = true;
			resultBean.errorMessage = "Movimento inválido para os dados sorteados.";
		}
		// piece on origin verification
		else if(!pointOrigin.isOwner(player))
		{
			resultBean.error = true;
			resultBean.errorMessage = "Você não possui peças na origem selecionada.";
		}
		// destination open
		else if(pointDestination.isClosed())
		{
			resultBean.error = true;
			resultBean.errorMessage = "O destino selecionado está fechado.";
		}
		
		// Movement is OK, make it happen!
		else
		{
			Piece piece;
			// if there is opponent piece on destination to eat 
			if(pointDestination.getPieceQuantity() == 1)
			{
				piece = pointDestination.popPiece();
				if(piece.color == 1)
					game.getBoard().findPoint(PointNumber.PointBar1).pushPiece(piece);
				else
					game.getBoard().findPoint(PointNumber.PointBar2).pushPiece(piece);
				
			}
			piece = pointOrigin.popPiece();
			pointDestination.pushPiece(piece);
		}
		session.setAttribute("resultBean", resultBean);
		request.getRequestDispatcher("Board.jsp").forward(request, response);
	}
}
