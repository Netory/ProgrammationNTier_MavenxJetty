<%--
  Created by IntelliJ IDEA.
  User: o22205297@campus.univ-orleans.fr
  Date: 03/02/2026
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>mesparis</title>
</head>
<body>
<h3>Tes paris en cours</h3>
<jsp:useBean id="mesParis" scope="request" type="java.util.Collection<modele.Pari>"/>
<c:forEach var="paris" items="${mesParis}">
    <tr>
    <td>${paris.match}</td>
</tr></c:forEach>

<l1><a href="${pageContext.request.contextPath}/pel/menu">Retour au menu</a></l1>
</body>
</html>
