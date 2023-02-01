<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Simple Vietnamese dictionary" %>
</h1>
<br/>
    <form action="dictionary.jsp" method="get">
        <input type="text" name="search" placeholder="Enter your word: "/>
        <input type = "submit" id = "submit" value = "Search"/>
    </form>
</body>
</html>