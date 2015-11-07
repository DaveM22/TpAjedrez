<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<Center>
<% String ganador=(String)request.getAttribute("ganador");
String colorGanador=(String)request.getAttribute("colorGanador");%>
<h1>El ganador es <%=ganador %> (Fichas <%=colorGanador%>)</h1>

<form method="get" action="IniciarJuego.html">
    <button type="submit">Nuevo Juego</button>
</form>
</Center>
</body>
</html>