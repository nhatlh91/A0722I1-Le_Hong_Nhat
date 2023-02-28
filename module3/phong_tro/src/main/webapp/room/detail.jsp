<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <title>He thong quan ly thong tin phong tro</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<h3>Chi tiet phong tro:</h3>
    <div class="rooms">
        <table class="table table-bordered">
            <tr>
                <th>Ma phong tro</th>
                <td><fmt:formatNumber pattern="PT - " minIntegerDigits="3" value="${room.getId()}"/></td>
            </tr>
            <tr>
                <th>Nguoi thue</th>
                <td>${room.getName()}</td>
            </tr>
            <tr>
                <th>So dien thoai</th>
                <td>${room.getPhone()}</td>
            </tr>
            <tr>
                <th>Ngay bat dau thue</th>
                <td><fmt:formatDate value="${room.getDate()}" pattern="dd-MM-yyyy"/></td>
            </tr>
            <tr>
                <th>Hinh thuc thanh toan</th>
                <td>
                    <c:choose>
                        <c:when test="${room.getPayment()==1}">Thang</c:when>
                        <c:when test="${room.getPayment()==2}">Quy</c:when>
                        <c:when test="${room.getPayment()==3}">Nam</c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Ghi chu</th>
                <td>${room.getNote()}</td>
            </tr>
        </table>
    </div>
    <a class="btn btn-danger" role="button" data-toggle="modal" data-target="#modalDelete">Xoa</a>
    <a class="btn btn-primary" role="button" href="/room/create.jsp">Them moi</a>
    <a class="btn btn-primary" role="button" href="/rooms?action=edit&id=${room.getId()}">Chinh sua</a>

    <!-- Modal -->
    <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Xac nhan</h5>
                </div>
                <div class="modal-body">
                    <p>Ban co chac chan muon xoa phong tro da chon hay khong ?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Huy</button>
                    <a class="btn btn-danger" role="button" href="/rooms?action=delete&id=${room.getId()}">Xac nhan</a>
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