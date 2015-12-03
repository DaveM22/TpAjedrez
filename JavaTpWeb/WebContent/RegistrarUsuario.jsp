<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String Error=(String)request.getAttribute("errorLogin");
String dni=(String)request.getSession().getAttribute("dni1");
if(Error==null)
Error="";%>
<form action="Ldni1" method="POST">

<h1><%=Error %></h1>
<center>
Dni:<%=dni %>
<br>
nombre:<input type="text" name="nombre"><br>
<br>
apellido:<input type="text" name="apellido"><br>
<button type="submit">Registrar</button>
</center>
</form>
</body>
</html>