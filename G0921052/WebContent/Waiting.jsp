<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="3; url=Waiting.jsp">
<title>Aguarde</title>
</head>
<body>
	Aguarde o outro jogador logar...
	
	<%
	String playerNumber = (String)session.getAttribute("playerNumber");
	if(session.isNew())
	{
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}
	else if(application.getAttribute("allPlayersLogged") != null )
	{
		if(playerNumber.equals("1"))
			request.getRequestDispatcher("NewGameServlet").forward(request, response);
		else
			request.getRequestDispatcher("BoardView.jsp").forward(request, response);
	}
		
	%>

</body>
</html>