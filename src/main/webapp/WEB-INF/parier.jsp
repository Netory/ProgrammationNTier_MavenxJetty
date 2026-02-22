<%--
  Created by IntelliJ IDEA.
  User: o22205297@campus.univ-orleans.fr
  Date: 05/02/2026
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Paris</title>
</head>
<body><jsp:useBean id="match" scope="request" type="modele.Match"/>
<li>Vous voulez parier sur le match : ${match.equipe1} VS ${match.equipe2} le ${match.quand}</li>
 <form method="post" action="${pageContext.request.contextPath}/pel/validerParis?idmatch=${match.idMatch}">
    <label for="paris" >Verdict du match </label>
        <select id="paris" id="paris">
            <option value="n1gagnant">${match.equipe1} gagne</option>
            <option value="n2gagnant">${match.equipe2} gagne</option>
            <option value="nul">nul</option>
        </select>
    <button type="submit" name="parier">Parier !</button></form>
<li><a href="${pageContext.request.contextPath}/pel/menu">Retour au menu</a></li>
</body>
</html>
