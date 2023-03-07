<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Email validator</title>
</head>
<body>
<c:if test="${flag}">
  <h3>Hi ${email}</h3>
</c:if>
<c:if test="${!flag}">
  <h3>Email khong hop le, nhap lai</h3>
</c:if>

</body>
</html>