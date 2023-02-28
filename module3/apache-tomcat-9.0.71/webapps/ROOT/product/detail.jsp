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
<h3>Details information:</h3>
<div>
<table>
    <tr>
        <th>Ma mat bang:</th>
        <td><fmt:formatNumber value="${product.getId()}" minIntegerDigits="3" pattern="PT-#"/></td>
    </tr>
    <tr>
        <th>Dien tich:</th>
        <td><fmt:formatNumber value="${product.getArea()}" pattern="#m2"/></td>
    </tr>
    <tr>
        <th>Trang thai:</th>
        <td>${product.getStatus()}</td>
    </tr>
    <tr>
        <th>Tang:</th>
        <td>${product.getFloor()}</td>
    </tr>
    <tr>
        <th>Loai van phong:</th>
        <td>${product.getType()}</td>
    </tr>
    <tr>
        <th>Mo ta chi tiet:</th>
        <td>${product.getDesc()}</td>
    </tr>
    <tr>
        <th>Gia tien:</th>
        <td><fmt:formatNumber value="${product.getPrice()}" type="currency" currencySymbol="VND"/></td>
    </tr>
    <tr>
        <th>Ngay bat dau:</th>
        <td><fmt:formatDate value="${product.getBegin()}" pattern="dd-MM-yyyy"/></td>
    </tr>
    <tr>
        <th>Ngay ket thuc:</th>
        <td><fmt:formatDate value="${product.getEnd()}" pattern="dd-MM-yyyy"/></td>
    </tr>
    <tr>
        <td><a role="button" class="btn btn-outline-primary" href="/products">Danh sach</a></td>
        <td>
            <a role="button" class="btn btn-outline-primary" href="/products?action=edit&id=${product.getId()}">Chinh sua</a>
            <a role="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#modalDelete">Xoa</a>
        </td>
    </tr>
</table>
</div>
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xac nhan</h5>
            </div>
            <div class="modal-body">
                <p>Xac nhan xoa mat bang da chon</p>
                <p>Thao tac khong the hoan lai</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Huy</button>
                <a role="button" class="btn btn-danger" href="/products?action=delete&id=${product.getId()}">Xac nhan</a>
            </div>
        </div>
    </div>
</div>
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