<%@page import="br.com.G0921052e1210325.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gamão - G0921052 e G1210325</title>
</head>
<body>
	<% 
		if(session.getAttribute("loginResponse") != null && (boolean)session.getAttribute("loginResponse") == false)
		{
			%>
			Nome ou senha inválido. Tente novamente.<br/><br/>
			<% 
		}
	%>
	
	<form action="LoginServlet" method="post">
		Nome de Usuário: <input type="text" name="userName">
		<br/>
		<br/>
		Senha : <input type="password" name="userPassword">
		<br/>
		<br/>
		<input type="submit" value="Ok">
	</form>
</body>
</html>