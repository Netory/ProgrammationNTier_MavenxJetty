<%--
  Created by IntelliJ IDEA.
  User: o22205297@campus.univ-orleans.fr
  Date: 03/02/2026
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c'est les paris</title>
</head>
<body>
<h2>Ici les paris ouvert</h2>
<jsp:useBean id="lesMatchs" scope="request" type="java.util.Collection<modele.Match>"/>
    <c:forEach var="match" items="${lesMatchs}">
        <li> Sport : ${match.sport} - ${match.equipe1} VS ${match.equipe2} - <a href="${pageContext.request.contextPath}/pel/parier?idmatch=${match.idMatch}"> Parier </a></li>
    </c:forEach>

<l1><a href="${pageContext.request.contextPath}/pel/menu">Retour au menu</a></l1>
</body>
</html>
