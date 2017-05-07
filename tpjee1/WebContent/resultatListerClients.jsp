<%@page import="java.util.Collection"%>
<%@page import="metier.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>Liste des clients</title>
</head>
<body>
<table>
	<tr> 
		<th>Id</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Couleur des yeux</th>
		<th>Age</th>
	</tr>
	<%Collection<Client> listeClients = ((Collection<Client>) request.getAttribute("listeClients"));
	for(Client c : listeClients)
	{%>
		
			<tr> 
				<td><%= c.getId() %></td>
				<td><%= c.getNom() %></td>
				<td><%= c.getPrenom() %></td>
				<td><%= c.getCouleurYeux() %></td>
				<td><%= c.getAge() %></td>
			</tr>
		
	<%}
	%>
	</table>
</body>
</html>