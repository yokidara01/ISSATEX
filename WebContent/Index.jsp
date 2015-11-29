<%@page import="beans.Client"%>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
<script src="bootstrap/js/bootstrap.js"></script>
<title>Welcome to Issatex</title>
</head>
<body>
<header>
<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="Index.jsp">Home</a></li>
  <%
  Client c = (Client) session.getAttribute("user");
  
  if (session.getAttribute("user")!=null)
  {
	  out.print("<li role='presentation'><a href='Profil.jsp'>Profil</a></li>") ;
	  out.print("<li role='presentation'><a href='logout'>Deconnection</a></li>") ;
	  
	  out.print("<h2>Hello"+c.getNom()+"</h1>");
	  
  } 
  if(session.getAttribute("admin")!=null)
  {
	  out.print("<li role='presentation'><a href='Profil.jsp'>Profil</a></li>") ;
	  out.print("<li role='presentation'><a href='AdminPanel.jsp'>Administration</a></li>") ;
	  out.print("<li role='presentation'><a href='logout'>Deconnection</a></li>") ;
	  
	  out.print("<h2>Hello admin </h1>");
  }
  
  
  
  
  
  else{
  %>
  
  
  
  
  
  <li role="presentation"><a href="Inscription.jsp">Inscription</a></li>
  <li role="presentation"><a href="Authentif.jsp">login</a></li>
<%
  }
%>
  
</ul>

</header>

</body>
</html>