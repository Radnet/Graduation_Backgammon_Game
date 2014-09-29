<%@page import="br.com.G0921052e1210325.beans.GameResponseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
if(session.isNew())
{
	request.getRequestDispatcher("Index.jsp").forward(request, response);
}
else if(application.getAttribute("gameOver") != null)
{
	%>
	<h2>FIM DE JOGO!! O Jogador <%=application.getAttribute("gameOver") %> VENCEU a partida!!</h2>
	<% 
}
else if(session.getAttribute("playerNumber") == null)
{
	request.getRequestDispatcher("Index.jsp").forward(request, response);
}
else
{
	%>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<% 
	// IF IS NOT YOUR TURN
	if (!((String) application.getAttribute("turn")).equals((String) session.getAttribute("playerNumber"))) 
	{
		%>
		<meta http-equiv="refresh" content="3; url=BoardView.jsp">
		<%
	} 
	%>
	<link rel="stylesheet" type="text/css" href="css/board.css">
	<title>Gamão</title>
	</head>
	<body>
		<jsp:useBean id="boardBean"
			class="br.com.G0921052e1210325.beans.BoardBean" scope="application" />
	
		<div id="board-image">
			<div id="point-13" class="point-top">
				<div class="piece ${boardBean.point13[0]}"></div>
				<div class="piece ${boardBean.point13[1]}"></div>
				<div class="piece ${boardBean.point13[2]}"></div>
				<div class="piece ${boardBean.point13[3]}"></div>
				<div class="piece ${boardBean.point13[4]}"></div>
				<div class="piece ${boardBean.point13[5]}"></div>
				<div class="piece ${boardBean.point13[6]}"></div>
				<div class="piece ${boardBean.point13[7]}"></div>
			</div>
			<div id="point-14" class="point-top">
				<div class="piece ${boardBean.point14[0]}"></div>
				<div class="piece ${boardBean.point14[1]}"></div>
				<div class="piece ${boardBean.point14[2]}"></div>
				<div class="piece ${boardBean.point14[3]}"></div>
				<div class="piece ${boardBean.point14[4]}"></div>
				<div class="piece ${boardBean.point14[5]}"></div>
				<div class="piece ${boardBean.point14[6]}"></div>
				<div class="piece ${boardBean.point14[7]}"></div>
			</div>
			<div id="point-15" class="point-top">
				<div class="piece ${boardBean.point15[0]}"></div>
				<div class="piece ${boardBean.point15[1]}"></div>
				<div class="piece ${boardBean.point15[2]}"></div>
				<div class="piece ${boardBean.point15[3]}"></div>
				<div class="piece ${boardBean.point15[4]}"></div>
				<div class="piece ${boardBean.point15[5]}"></div>
				<div class="piece ${boardBean.point15[6]}"></div>
				<div class="piece ${boardBean.point15[7]}"></div>
			</div>
	
			<div id="point-16" class="point-top">
				<div class="piece ${boardBean.point16[0]}"></div>
				<div class="piece ${boardBean.point16[1]}"></div>
				<div class="piece ${boardBean.point16[2]}"></div>
				<div class="piece ${boardBean.point16[3]}"></div>
				<div class="piece ${boardBean.point16[4]}"></div>
				<div class="piece ${boardBean.point16[5]}"></div>
				<div class="piece ${boardBean.point16[6]}"></div>
				<div class="piece ${boardBean.point16[7]}"></div>
			</div>
	
			<div id="point-17" class="point-top">
				<div class="piece ${boardBean.point17[0]}"></div>
				<div class="piece ${boardBean.point17[1]}"></div>
				<div class="piece ${boardBean.point17[2]}"></div>
				<div class="piece ${boardBean.point17[3]}"></div>
				<div class="piece ${boardBean.point17[4]}"></div>
				<div class="piece ${boardBean.point17[5]}"></div>
				<div class="piece ${boardBean.point17[6]}"></div>
				<div class="piece ${boardBean.point17[7]}"></div>
			</div>
	
			<div id="point-18" class="point-top">
				<div class="piece ${boardBean.point18[0]}"></div>
				<div class="piece ${boardBean.point18[1]}"></div>
				<div class="piece ${boardBean.point18[2]}"></div>
				<div class="piece ${boardBean.point18[3]}"></div>
				<div class="piece ${boardBean.point18[4]}"></div>
				<div class="piece ${boardBean.point18[5]}"></div>
				<div class="piece ${boardBean.point18[6]}"></div>
				<div class="piece ${boardBean.point18[7]}"></div>
			</div>
	
			<div id="barra" class="point-top">
				<div class="piece ${boardBean.bar[0]}"></div>
				<div class="piece ${boardBean.bar[1]}"></div>
				<div class="piece ${boardBean.bar[2]}"></div>
				<div class="piece ${boardBean.bar[3]}"></div>
				<div class="piece ${boardBean.bar[4]}"></div>
				<div class="piece ${boardBean.bar[5]}"></div>
				<div class="piece ${boardBean.bar[6]}"></div>
				<div class="piece ${boardBean.bar[7]}"></div>
			</div>
	
			<div id="point-19" class="point-top">
				<div class="piece ${boardBean.point19[0]}"></div>
				<div class="piece ${boardBean.point19[1]}"></div>
				<div class="piece ${boardBean.point19[2]}"></div>
				<div class="piece ${boardBean.point19[3]}"></div>
				<div class="piece ${boardBean.point19[4]}"></div>
				<div class="piece ${boardBean.point19[5]}"></div>
				<div class="piece ${boardBean.point19[6]}"></div>
				<div class="piece ${boardBean.point19[7]}"></div>
			</div>
	
			<div id="point-20" class="point-top">
				<div class="piece ${boardBean.point20[0]}"></div>
				<div class="piece ${boardBean.point20[1]}"></div>
				<div class="piece ${boardBean.point20[2]}"></div>
				<div class="piece ${boardBean.point20[3]}"></div>
				<div class="piece ${boardBean.point20[4]}"></div>
				<div class="piece ${boardBean.point20[5]}"></div>
				<div class="piece ${boardBean.point20[6]}"></div>
				<div class="piece ${boardBean.point20[7]}"></div>
			</div>
	
			<div id="point-21" class="point-top">
				<div class="piece ${boardBean.point21[0]}"></div>
				<div class="piece ${boardBean.point21[1]}"></div>
				<div class="piece ${boardBean.point21[2]}"></div>
				<div class="piece ${boardBean.point21[3]}"></div>
				<div class="piece ${boardBean.point21[4]}"></div>
				<div class="piece ${boardBean.point21[5]}"></div>
				<div class="piece ${boardBean.point21[6]}"></div>
				<div class="piece ${boardBean.point21[7]}"></div>
			</div>
	
			<div id="point-22" class="point-top">
				<div class="piece ${boardBean.point22[0]}"></div>
				<div class="piece ${boardBean.point22[1]}"></div>
				<div class="piece ${boardBean.point22[2]}"></div>
				<div class="piece ${boardBean.point22[3]}"></div>
				<div class="piece ${boardBean.point22[4]}"></div>
				<div class="piece ${boardBean.point22[5]}"></div>
				<div class="piece ${boardBean.point22[6]}"></div>
				<div class="piece ${boardBean.point22[7]}"></div>
			</div>
	
			<div id="point-23" class="point-top">
				<div class="piece ${boardBean.point23[0]}"></div>
				<div class="piece ${boardBean.point23[1]}"></div>
				<div class="piece ${boardBean.point23[2]}"></div>
				<div class="piece ${boardBean.point23[3]}"></div>
				<div class="piece ${boardBean.point23[4]}"></div>
				<div class="piece ${boardBean.point23[5]}"></div>
				<div class="piece ${boardBean.point23[6]}"></div>
				<div class="piece ${boardBean.point23[7]}"></div>
			</div>
	
			<div id="point-24" class="point-top">
				<div class="piece ${boardBean.point24[0]}"></div>
				<div class="piece ${boardBean.point24[1]}"></div>
				<div class="piece ${boardBean.point24[2]}"></div>
				<div class="piece ${boardBean.point24[3]}"></div>
				<div class="piece ${boardBean.point24[4]}"></div>
				<div class="piece ${boardBean.point24[5]}"></div>
				<div class="piece ${boardBean.point24[6]}"></div>
				<div class="piece ${boardBean.point24[7]}"></div>
			</div>
	
			<div id="point-12" class="point-botton">
				<div class="piece ${boardBean.point12[7]}"></div>
				<div class="piece ${boardBean.point12[6]}"></div>
				<div class="piece ${boardBean.point12[5]}"></div>
				<div class="piece ${boardBean.point12[4]}"></div>
				<div class="piece ${boardBean.point12[3]}"></div>
				<div class="piece ${boardBean.point12[2]}"></div>
				<div class="piece ${boardBean.point12[1]}"></div>
				<div class="piece ${boardBean.point12[0]}"></div>
			</div>
			<div id="point-11" class="point-botton">
				<div class="piece ${boardBean.point11[7]}"></div>
				<div class="piece ${boardBean.point11[6]}"></div>
				<div class="piece ${boardBean.point11[5]}"></div>
				<div class="piece ${boardBean.point11[4]}"></div>
				<div class="piece ${boardBean.point11[3]}"></div>
				<div class="piece ${boardBean.point11[2]}"></div>
				<div class="piece ${boardBean.point11[1]}"></div>
				<div class="piece ${boardBean.point11[0]}"></div>
			</div>
	
			<div id="point-10" class="point-botton">
				<div class="piece ${boardBean.point10[7]}"></div>
				<div class="piece ${boardBean.point10[6]}"></div>
				<div class="piece ${boardBean.point10[5]}"></div>
				<div class="piece ${boardBean.point10[4]}"></div>
				<div class="piece ${boardBean.point10[3]}"></div>
				<div class="piece ${boardBean.point10[2]}"></div>
				<div class="piece ${boardBean.point10[1]}"></div>
				<div class="piece ${boardBean.point10[0]}"></div>
			</div>
	
			<div id="point-09" class="point-botton">
				<div class="piece ${boardBean.point9[7]}"></div>
				<div class="piece ${boardBean.point9[6]}"></div>
				<div class="piece ${boardBean.point9[5]}"></div>
				<div class="piece ${boardBean.point9[4]}"></div>
				<div class="piece ${boardBean.point9[3]}"></div>
				<div class="piece ${boardBean.point9[2]}"></div>
				<div class="piece ${boardBean.point9[1]}"></div>
				<div class="piece ${boardBean.point9[0]}"></div>
			</div>
	
			<div id="point-08" class="point-botton">
				<div class="piece ${boardBean.point8[7]}"></div>
				<div class="piece ${boardBean.point8[6]}"></div>
				<div class="piece ${boardBean.point8[5]}"></div>
				<div class="piece ${boardBean.point8[4]}"></div>
				<div class="piece ${boardBean.point8[3]}"></div>
				<div class="piece ${boardBean.point8[2]}"></div>
				<div class="piece ${boardBean.point8[1]}"></div>
				<div class="piece ${boardBean.point8[0]}"></div>
			</div>
	
			<div id="point-07" class="point-botton">
				<div class="piece ${boardBean.point7[7]}"></div>
				<div class="piece ${boardBean.point7[6]}"></div>
				<div class="piece ${boardBean.point7[5]}"></div>
				<div class="piece ${boardBean.point7[4]}"></div>
				<div class="piece ${boardBean.point7[3]}"></div>
				<div class="piece ${boardBean.point7[2]}"></div>
				<div class="piece ${boardBean.point7[1]}"></div>
				<div class="piece ${boardBean.point7[0]}"></div>
			</div>
	
			<div id="point-06" class="point-botton">
				<div class="piece ${boardBean.point6[7]}"></div>
				<div class="piece ${boardBean.point6[6]}"></div>
				<div class="piece ${boardBean.point6[5]}"></div>
				<div class="piece ${boardBean.point6[4]}"></div>
				<div class="piece ${boardBean.point6[3]}"></div>
				<div class="piece ${boardBean.point6[2]}"></div>
				<div class="piece ${boardBean.point6[1]}"></div>
				<div class="piece ${boardBean.point6[0]}"></div>
			</div>
	
			<div id="point-05" class="point-botton">
				<div class="piece ${boardBean.point5[7]}"></div>
				<div class="piece ${boardBean.point5[6]}"></div>
				<div class="piece ${boardBean.point5[5]}"></div>
				<div class="piece ${boardBean.point5[4]}"></div>
				<div class="piece ${boardBean.point5[3]}"></div>
				<div class="piece ${boardBean.point5[2]}"></div>
				<div class="piece ${boardBean.point5[1]}"></div>
				<div class="piece ${boardBean.point5[0]}"></div>
			</div>
	
			<div id="point-04" class="point-botton">
				<div class="piece ${boardBean.point4[7]}"></div>
				<div class="piece ${boardBean.point4[6]}"></div>
				<div class="piece ${boardBean.point4[5]}"></div>
				<div class="piece ${boardBean.point4[4]}"></div>
				<div class="piece ${boardBean.point4[3]}"></div>
				<div class="piece ${boardBean.point4[2]}"></div>
				<div class="piece ${boardBean.point4[1]}"></div>
				<div class="piece ${boardBean.point4[0]}"></div>
			</div>
	
			<div id="point-03" class="point-botton">
				<div class="piece ${boardBean.point3[7]}"></div>
				<div class="piece ${boardBean.point3[6]}"></div>
				<div class="piece ${boardBean.point3[5]}"></div>
				<div class="piece ${boardBean.point3[4]}"></div>
				<div class="piece ${boardBean.point3[3]}"></div>
				<div class="piece ${boardBean.point3[2]}"></div>
				<div class="piece ${boardBean.point3[1]}"></div>
				<div class="piece ${boardBean.point3[0]}"></div>
			</div>
	
			<div id="point-02" class="point-botton">
				<div class="piece ${boardBean.point2[7]}"></div>
				<div class="piece ${boardBean.point2[6]}"></div>
				<div class="piece ${boardBean.point2[5]}"></div>
				<div class="piece ${boardBean.point2[4]}"></div>
				<div class="piece ${boardBean.point2[3]}"></div>
				<div class="piece ${boardBean.point2[2]}"></div>
				<div class="piece ${boardBean.point2[1]}"></div>
				<div class="piece ${boardBean.point2[0]}"></div>
			</div>
	
			<div id="point-01" class="point-botton">
				<div class="piece ${boardBean.point1[7]}"></div>
				<div class="piece ${boardBean.point1[6]}"></div>
				<div class="piece ${boardBean.point1[5]}"></div>
				<div class="piece ${boardBean.point1[4]}"></div>
				<div class="piece ${boardBean.point1[3]}"></div>
				<div class="piece ${boardBean.point1[2]}"></div>
				<div class="piece ${boardBean.point1[1]}"></div>
				<div class="piece ${boardBean.point1[0]}"></div>
			</div>
		</div>
		<jsp:useBean id="playerBean" class="br.com.G0921052e1210325.beans.PlayerBean" scope="session" />
		<br />
		Jogador ${playerBean.number}
		<div class="piece ${playerBean.color}"></div>
		<br /> 
		<jsp:useBean id="diceBean" class="br.com.G0921052e1210325.beans.DiceBean" scope="application" />
		Dado1:  <div id="dice${diceBean.dice1}-image"></div>
		Dado2:  <div id="dice${diceBean.dice2}-image"></div>
		<br />
	
		<%
		// IF IS YOUR TURN
		if (((String) application.getAttribute("turn")).equals((String) session.getAttribute("playerNumber"))) {
			GameResponseBean gameResponse = (GameResponseBean) session.getAttribute("gameResponse");
			if (gameResponse.error) 
			{
				%>
				<br />
				<%=gameResponse.errorMessage%>
				<br />
				<%
			}
		%>
		<form action="DiceServlet" method="post">
			<input type="submit" value="Jogar Dados">
		</form>
		<form action="MovePieceServlet" method="post">
			Origem: <select name="origin">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="24">25</option>
			</select> Destino: <select name="destination">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
			</select> <br /> <input type="submit" value="Mover">
		</form>
		<br />
		<br />
		<form action="ChangeTurnServlet" method="post">
			<input type="submit" value="Passar Vez">
		</form>
		<%
		}//END IF TURN
		else 
		{
			%>
			Aguarde o amiginho jogar.
			<%
		}
		%>
	</body>
<%
}
%>
</html>