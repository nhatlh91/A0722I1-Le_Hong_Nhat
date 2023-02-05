<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2/5/2023
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<h1>Edit product:</h1>
<form method="post" action="/products">
    <input type="hidden" name="action" value="search">
    <fieldset>
        <legend>Search product by name:</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
