<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <title>Quan ly ho khau</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<h3>Danh sach ho khau</h3>
<table class="table table-bordered" id="pagination-table">
    <thead>
    <th>So thu tu</th>
    <th>Ma ho khau</th>
    <th>Ten chu ho</th>
    <th>So thanh vien</th>
    <th>Ngay lap</th>
    <th>Dia chi nha</th>
    <th>Chuc nang</th>
    </thead>
    <tbody>
    <c:set var="count" value="0"/>
    <c:forEach items="${families}" var="family">
        <c:set var="count" value="${count+1}"/>
        <tr>
            <td>${count}</td>
            <td><fmt:formatNumber pattern="HK-" minIntegerDigits="3" value="${family.getFid()}"/></td>
            <td>${family.getHost()}</td>
            <td>${family.getMember()}</td>
            <td><fmt:formatDate value="${family.getDate()}" pattern="dd-MM-yyyy"/></td>
            <td>${family.getAddress()}</td>
            <td>
                <a href="#" class="btn-primary btn">Sua</a>
                <a href="#" class="btn-primary btn">Chi tiet</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>



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
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#pagination-table').dataTable({
            'searching': false,
            'pageLength' : 5,
            'info': false,
        })
    })
</script>
</body>
</html>