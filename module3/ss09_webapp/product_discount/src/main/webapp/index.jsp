<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product discount calculator</title>
</head>
<body>
<h1><%= "Product discount calculator" %></h1>
<hr>
<form method="post" action="discount">
    <input name="description" type="text" placeholder="Product descriptions">
    <input name="price" type="number" placeholder="Listed Price">
    <input name="discountRate" type="number" placeholder="Discount Percent">
    <input type = "submit" id = "submit" value = "Calculate!"/>
</form>
</body>
</html>