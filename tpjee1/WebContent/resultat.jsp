<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>Resultat</title>
</head>
<body>
<p>Bonjour nous sommes le <span><%= new Date()%></span></p>
<p>Bonjour <%= request.getAttribute("leprenom") %> <%= request.getAttribute("lenom") %></p>
<p>Le mot de passe saisi est <%= request.getAttribute("lemdp") %> </p>
<%
String[] loisirs = ((String[]) request.getAttribute("lesloisirs"));
if(loisirs!=null)
{
	for(int i=0;i<loisirs.length;i++)
	{%>
		<p><%= loisirs[i] %></p>
	<%}
}
%>
</body>
</html>
