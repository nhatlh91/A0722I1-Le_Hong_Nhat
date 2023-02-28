<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <title>He thong quan ly san pham</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
</head>
<body class="col-md-12">
<div class="alert alert-info" role="alert">
<h3>He thong quan ly san pham</h3>
</div>
<c:if test="${createNoti}">
    <div class="alert alert-success" role="alert">
        Them moi san pham thanh cong
    </div>
</c:if>
<c:if test="${updateNoti}">
    <div class="alert alert-success" role="alert">
        Cap nhat thong tin san pham thanh cong
    </div>
</c:if>
<c:if test="${deleteNoti}">
    <div class="alert alert-success" role="alert">
        Da xoa san pham thanh cong
    </div>
</c:if>
<form style="float: right" class="form-inline" action="/products">
    <div class="form-group">
        <input type="search" name="keyword" placeholder="Tim kiem">
        <input type="hidden" name="action" value="search">
        <input type="submit" class="btn btn-outline-primary" value="Tim kiem">
        <a href="/product/create.jsp" type="buton" class="btn btn-outline-primary">Tao moi</a>
    </div>
</form>
<div class="products">
    <table class="table table-bordered" id="room-pagination">
        <thead>
        <th>So thu tu</th>
        <th>Ma san pham</th>
        <th>Ten san pham</th>
        <th>Gia tien</th>
        <th>So luong</th>
        <th>Mau sac</th>
        <th>Mo ta</th>
        <th>Danh muc</th>
        <th>Thao tac</th>
        </thead>
        <tbody>
        <c:set var="count" value="0"/>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>
                    <c:set var="count" value="${count + 1}"/>
                    <c:out value="${count}"/>
                </td>
                <td><fmt:formatNumber value="${product.getId()}" minIntegerDigits="3" pattern="SP#"/>  </td>
                <td>${product.getName()}</td>
                <td><fmt:formatNumber value="${product.getPrice()}" currencySymbol="VND" type="currency"/></td>
                <td>${product.getQuantity()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getDesc()}</td>
                <td>
                    <c:choose>
                        <c:when test="${product.getCategory_id() == 1}">Dien thoai</c:when>
                        <c:when test="${product.getCategory_id() == 2}">Tivi</c:when>
                        <c:when test="${product.getCategory_id() == 3}">Tu lanh</c:when>
                        <c:when test="${product.getCategory_id() == 4}">May giat</c:when>
                    </c:choose>
                </td>
                <td><a class="btn btn-outline-danger" role="button" data-toggle="modal" data-target="#modalDelete"
                       onclick="onDelete(${product.getId()})">Xoa</a>
                    <a class="btn btn-outline-primary" role="button" href="/products?action=edit&id=${product.getId()}">Chinh sua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xac nhan</h5>
            </div>
            <form action="/products">
                <input type="hidden" name="action" value="delete">

                <div class="modal-body">
                    <p>Xac nhan xoa san pham</p>
                    <input type="hidden" name="id" value="" id="idDelete">
                    <p id="idDelete2"></p>
                    <p>Thao tac khong the hoan lai</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Huy</button>
                    <button type="submit" class="btn btn-danger">Xac nhan</button>
                </div>
            </form>
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
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#room-pagination').dataTable({
            'searching': false,
            'pageLength': 5,
            'info': false,
            'sort':false,
        })
    })

    function onDelete(id) {
        document.getElementById("idDelete").value = id;
    }
</script>
</body>
</html>