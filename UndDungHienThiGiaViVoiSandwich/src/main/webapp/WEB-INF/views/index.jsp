<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuana
  Date: 19-Jan-22
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Condiment</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
    <form method="post" action="save">
        <input type="checkbox" name="condiment" value="lettuce">Lettuce
        <input type="checkbox" name="condiment" value="tomato">Tomato
        <input type="checkbox" name="condiment" value="mustard">Mustard
        <input type="checkbox" name="condiment" value="sprouts">Sprouts
        <input type="submit" value="Save">
    </form>
    <c:forEach items="${condiments}" var="condiment">
        <p>${condiment}</p>
    </c:forEach>
  </body>
</html>
