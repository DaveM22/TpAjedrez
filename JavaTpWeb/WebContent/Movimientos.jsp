<%@page import="Servlets.Guardar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
     <%@page import="Clases.Pieza"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String h=(String)session.getAttribute("dni1");
String f=(String)session.getAttribute("dni2");
String color=(String)session.getAttribute("color");
String resultadonegro="";
String resultadoblanco="";
String error=(String)request.getAttribute("error");
ArrayList<Pieza> piezas = (ArrayList<Pieza>)session.getAttribute("listado");
%>


<%for(Pieza i:piezas){%>
<%if(i.getColor()=="Negro"){%>
<%resultadonegro+=i.getId_pieza()+i.getClass().getSimpleName()+" "+i.getPosicion()+"\n"; %>
<%} %>
<%} %>

<%for(Pieza i:piezas){%>
<%if(i.getColor()=="Blanco"){%>
<%resultadoblanco+=i.getId_pieza()+i.getClass().getSimpleName()+" "+i.getPosicion()+"\n"; %>
<%} %>
<%} %>
<center>
<table>
<tr>
<td><div><%=h %><br><textarea rows="16" cols="12"><%=resultadonegro %></textarea></div>
<td><img src="board.png" alt="Mountain View" style="width:304px;height:228px;">
<td><div><%=f %><br><textarea rows="16" cols="12"><%=resultadoblanco %></textarea></div>
<tr>
</table>
</center>
<br>
<%piezas=null; %>
<Center>
<p><h1>Turno:</h1><%=color %></p>
<br>
<font color="#FF0000"><p><%=error %></p></font>
<form action="Mover" method="POST">
<br>
<label>Posici�n origen: </label><input type="text" name="posori"><br>
<br>
<label>Posici�n destino: </label><input type="text" name="posdes"><br>
<br><button type="submit">Mover</button><br>
<a href=Guardar >Guardar partida</a>
</form>
</Center>
</body>
</html>