<jsp:useBean id="utilisateur" scope="session" type="modele.Utilisateur"/>
<%--
  Created by IntelliJ IDEA.
  User: o22205297@campus.univ-orleans.fr
  Date: 21/01/2026
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
<h1>Bonjour ${utilisateur.login}</h1>
<ul>
    <form method="get" action="${pageContext.request.contextPath}/pel/listesParis">
        <button type="submit" name="lp">Les paris</button></form>
    <form method="get" action="${pageContext.request.contextPath}/pel/mesparis">
        <button type="submit" name="lp">Mes paris</button></form>
    <form method="get" action="${pageContext.request.contextPath}/pel/deconnexion">
        <button type="submit" name="lp">Déconnexion</button></form>
</ul>
</body>
</html>
