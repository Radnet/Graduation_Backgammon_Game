package br.com.G0921052e1210325.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.G0921052e1210325.beans.DiceBean;
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
		
		// get player
		Player player = UserAccess.getUserAccessInstance().getUserByNumber(Integer.parseInt((String)session.getAttribute("playerNumber"))); 
		
		// get origin and destination points
		int origin = Integer.parseInt(request.getParameter("origin"));
		int destination = Integer.parseInt(request.getParameter("destination"));
		Point pointOrigin;
		if(origin == 25)
			pointOrigin = null;
		else
			pointOrigin = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[origin-1]);
		Point pointDestination = game.getBoard().findPoint(PointNumber.class.getEnumConstants()[destination-1]);
		
		if(player.dices.getDicesResult() == null)
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Você precisa jogar os dados primeiro!";
		}
		else if(origin != 25 && (game.getBoard().getBar().hasPiece(player)))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Você possui peças na barra, tire ela de lá primeiro.";
		}
		// Bar verifications
		else if(origin == 25 && !game.getBoard().getBar().hasPiece(player))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Você não possui peças na barra.";
		}
		else if( (player.number == 1 && destination > 6) || (player.number == 2 && destination < 19) )
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "O destino da barra só pode ser no Primeiro Quadrante.";
		}
		// Movement compatible with dices
		else if(!player.isMovementOkForAvailableMoves(origin, destination))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Movimento inválido para os dados sorteados.";
		}
		// piece on origin verification
		else if(origin != 25 && !pointOrigin.isOwner(player))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "Você não possui peças na origem selecionada.";
		}
		
		// destination open
		else if(pointDestination.isClosed(player))
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "O destino selecionado está fechado.";
		}
		// destination not full
		else if(pointDestination.getPieceQuantity() == 8)
		{
			gameResponse.error = true;
			gameResponse.errorMessage = "O destino está lotado.";
		}
		// Movement is OK, make it happen!
		else
		{
			Piece piece;
			// if there is opponent piece on destination to eat 
			if(pointDestination.getPieceQuantity() == 1)
			{
				piece = pointDestination.popPiece();
				game.getBoard().getBar().pushPiece(piece);				
			}
			if(pointOrigin == null)
				piece = game.getBoard().getBar().popPiece(player);
			else
				piece = pointOrigin.popPiece();
			pointDestination.pushPiece(piece);
			// decrement move
			player.removeMovement(origin, destination);
			//Change turn if movements are used
			if(player.dices.getMoves().get().size() == 0)
			{
				DiceBean diceBean = new DiceBean();
				application.setAttribute("diceBean", diceBean);
				player.dices.emptyDices();
				application.setAttribute("turn", Integer.toString(player.opponent.number));
			}
		}
		application.setAttribute("boardBean", Game.getGameInstance().getBoard().getBoardBean());
		session.setAttribute("gameResponse", gameResponse);
		request.getRequestDispatcher("BoardView.jsp").forward(request, response);
	}
}
