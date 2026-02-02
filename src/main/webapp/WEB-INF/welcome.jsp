<%--
  Created by IntelliJ IDEA.
  User: o22205297@campus.univ-orleans.fr
  Date: 21/01/2026
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/pel/menu">
    <label for="login" >Pseudonyme</label>
    <input id="login" type="text" name="login"/>

    <label for="password" >Mot de passe</label>
    <input id="password" type="text" name="password"/>

    <button type="submit" name="Connexion">Se connecter</button>
</form>
</body>
</html>
