<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create from</title>
</head>
<body>
<h1>Create a new product</h1>
<form method="post" action="/products">
    <input type="hidden" name="action" value="create">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="desc" id="desc"></td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td><input type="text" name="manu" id="manu"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
