<%@page import="br.com.G0921052e1210325.beans.GameResponseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gamão - G0921052 e G1210325</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<% 
		GameResponseBean gameResponse = (GameResponseBean)session.getAttribute("gameResponse");
		if(gameResponse != null && gameResponse.error)
		{
			%>
			<%=gameResponse.errorMessage%> <br/><br/>
			<% 
		}
	%>
	<h2>Gamão - Login</h2>
	<form action="UserAccessServlet" method="post">
		<div class="labels">
			<p>Nome de Usuário:</p>
			<p>Senha:</p>
		</div>
		<div class="fields">
			<input class="username" type="text" name="userName">
			<br>
			<input class="password" type="password" name="userPassword">
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<input class="submit" type="submit" value="Ok">
	</form>
</body>
</html>