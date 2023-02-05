<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<h1>Product List:</h1>
<p>
    <a href="/product/create.jsp">Add a new product</a>
</p>
<p>
    <a href="/product/search.jsp">Search</a>
</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDesc()}</td>
            <td>${product.getManufacturer()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">Update</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
