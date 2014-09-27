<%@page import="br.com.G0921052e1210325.beans.GameResponseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gamão</title>
</head>
<body>
BOARD VIEW

<% 
// IF TURN
if(((String)application.getAttribute("turn")).equals((String)session.getAttribute("playerNumber")))
{
	GameResponseBean gameResponse = (GameResponseBean)session.getAttribute("gameResponse");
	if(gameResponse.error)
	{
		%>
		<br/>
		<%=gameResponse.errorMessage %>
		<br/>
		<% 
	}
%>
	<br/>
	Dado1: <%=gameResponse.dice1 %>
	Dado2: <%=gameResponse.dice2 %>
	<br/>
	<form action="DiceServlet" method="post">
		<input type="submit" value="Jogar Dados">	
	</form>
	<form action="MovePieceServlet" method="post">
	Origem:
		<select name="origin">
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
		</select>
	Destino:
		<select name="destination">
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
		</select>
		<br/>
		<input type="submit" value="Mover">
	</form>
	<br/>
	<br/>
	<form action="ChangeTurnServlet" method="post">
		<input type="submit" value="Passar Vez">	
	</form>
<%
}//END IF TURN
else
{
%>
<meta http-equiv="refresh" content="3; url=BoardView.jsp">
Aguarde o amiginho jogar.
<%
}
%>
</body>
</html>