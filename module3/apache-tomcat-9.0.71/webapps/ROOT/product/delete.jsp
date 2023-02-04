<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product:</h1>
<form method="post" action="/products">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="${product.getId()}">
    <fieldset>
        <legend>Current product information:</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${product.getDesc()}</td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td>${product.getManufacturer()}</td>
            </tr>
            <tr>
                <td><a href="/products">Cancel</a> </td>
                <td><input type="submit" value="Confirm"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
