<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<form method="post" action="/families">
    <input type="hidden" name="action" value="update">
    <table>
        <tr>
            <th>Ma ho khau</th>
            <td><input name="fid" type="number" value="${family.getFid()}" readonly></td>
        </tr>
        <tr>
            <th>Ten chu ho</th>
            <td><input name="host" value="${family.getHost()}" autofocus type="text" required pattern="[a-zA-Z ]+"></td>
        </tr>
        <tr>
            <th>So nhan khau</th>
            <td><input name="members" value="${family.getMembers()}" readonly type="number"></td>
        </tr>
        <tr>
            <th>Ngay lap ho khau</th>
            <td><input name="date" value="${family.getCreateDate()}" type="date" required></td>
        </tr>
        <tr>
            <th>Dia chi nha</th>
            <td><input name="address" value="${family.getAddress()}" type="text" required/></td>
        </tr>
    </table>
    <input type="submit" class="btn btn-primary" value="Sua">
    <a class="btn btn-secondary" href="/families" >Huy</a>
</form>
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