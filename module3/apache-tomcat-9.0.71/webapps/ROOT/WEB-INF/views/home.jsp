<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2>Settings:</h2>
<form:form action="save" method="post" modelAttribute="emailConfig">
    <table>
        <tr>
            <th>Language: </th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Pages: </th>
            <td><form:select path="pageSize" items="${pages}"/></td>
        </tr>
        <tr>
            <th>Spam Filter: </th>
            <td>
                <form:select path="spamFilter">
                    <form:option value="true">Enable</form:option>
                    <form:option value="false">Disable</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Signature: </th>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" role="button" class="btn btn-outline-primary" value="Update">
                <input type="reset" role="button" class="btn btn-outline-secondary" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${message != null}">
    <div style="color: red">
        <c:out value="${message}"/>
    </div>
</c:if>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
