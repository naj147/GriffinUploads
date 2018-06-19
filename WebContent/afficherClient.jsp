<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
   <%-- <jsp:useBean id="client" class="Beans.Client"/> --%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage des clients</title>
<link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>
<p class="info">${erreurClient}</p>
<p>Nom=${client.nom}</p>
<p>Prenom=${client.prenom}</p>
<p>Adresse=${client.adresse}</p>
<p>Tel=${client.tel}</p>
<p>Email=${client.email}</p> 
</body>
</html>
