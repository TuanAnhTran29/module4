<%--
  Created by IntelliJ IDEA.
  User: tuana
  Date: 18-Jan-22
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
  <form method="post" action="/dictionary">
    <input type="text" name="inputText" placeholder="Enter the word">
    <button type="submit" value="submit">Translate</button>
    <p>${message}</p>
  </form>
  </body>
</html>
