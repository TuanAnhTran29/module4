<%--
  Created by IntelliJ IDEA.
  User: tuana
  Date: 17-Jan-22
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculate Currency</title>
  </head>
  <body>
  <form method="post" action="/main">
    <input type="number" name="inputNumber" placeholder="Enter the amount to be transferred">
    <button type="submit" value="Calculate">Calculate</button>
    <p>${result}</p>
  </form>
  </body>
</html>
