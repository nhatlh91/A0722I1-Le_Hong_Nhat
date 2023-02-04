
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product details</title>
</head>
<body>
<h1>Product details</h1>
<fieldset>
    <legend>Product information:</legend>
    <table>
        <tr>
            <td>ID: </td>
            <td>${product.getId()}</td>
        </tr>
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
            <td></td>
            <td><a href="/products">Back to List</a> </td>
    </table>
</fieldset>
</body>
</html>
