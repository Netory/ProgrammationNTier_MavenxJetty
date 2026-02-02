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

<form method="get" action="pel/menu">
    <label for="pseudo" >Pseudonyme</label>
    <input id="pseudo" type="text" name="pseudo"/>

    <label for="mdp" >Mot de passe</label>
    <input id="mdp" type="text" name="mdp"/>

    <input type="submit" name="Connexion"/>
</form>
</body>
</html>
