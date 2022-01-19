<%--
  Created by IntelliJ IDEA.
  User: tuana
  Date: 19-Jan-22
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form method="post" action="calculate1">
    <input type="number" name="input1" placeholder="Enter the number:">
    <input type="number" name="input2" placeholder="Enter the number:"><br>
    <input type="submit" name="calculate" value="Addition">
    <input type="submit" name="calculate" value="Subtraction">
    <input type="submit" name="calculate" value="Multiplication">
    <input type="submit" name="calculate" value="Division">
  </form>
  <p>Result: ${result}</p>
  </body>
</html>
