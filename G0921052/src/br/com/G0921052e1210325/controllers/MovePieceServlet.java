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
import br.com.G0921052e1210325.models.Game;
import br.com.G0921052e1210325.models.Piece;
import br.com.G0921052e1210325.models.Player;
import br.com.G0921052e1210325.models.Point;
import br.com.G0921052e1210325.models.PointNumber;
import br.com.G0921052e1210325.models.UserAccess;

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
		GameResponseBean gameResponse = (GameResponseBean) session.getAttribute("gameResponse");
		
		// get origin and destination points
		int origin = Integer.parseInt(request.getParameter("origin"));
		int destination = Integer.parseInt(request.getParameter("destination"));
		Point pointOrigin = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[origin-1]);
		Point pointDestination = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[destination-1]);
		// get player
		Player player = UserAccess.getUserAccessInstance().getUserByNumber(Integer.parseInt((String)session.getAttribute("playerNumber"))); 
		
		// Movement compatible with dices
		if(!player.isMovementOkForAvailableMoves(origin, destination))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Movimento inv�lido para os dados sorteados.";
		}
		// piece on origin verification
		else if(!pointOrigin.isOwner(player))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Voc� n�o possui pe�as na origem selecionada.";
		}
		// destination open
		else if(pointDestination.isClosed())
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "O destino selecionado est� fechado.";
		}
		// destination not full
		else if(pointDestination.getPieceQuantity() == 8)
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "O destino est� lotado.";
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
			// decrement move
			player.removeMovement(origin, destination);
			//Change turn if both dices are used
			if(player.dices.getMoves().get().size() == 0)
				application.setAttribute("turn", Integer.toString(player.opponent.number));
		}
		session.setAttribute("gameResponse", gameResponse);
		request.getRequestDispatcher("BoardView.jsp").forward(request, response);
	}
}
