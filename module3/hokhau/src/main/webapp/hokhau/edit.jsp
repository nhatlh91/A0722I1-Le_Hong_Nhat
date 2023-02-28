<!doctype html>
<html lang="en">
<head>
    <title>Quan ly phong tro</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3>Chinh sua thong tin</h3>
<c:if test="${flag}">
    <h3 style="color: red">Thong tin nhap vao khong hop le, hay nhap lai</h3>
</c:if>
<form action="/rooms" method="post">
    <table>
        <tr>
            <th>Ten nguoi thue phong:</th>
            <td><input name="name" type="text" required value="${room.getName()}" autofocus pattern="[a-zA-Z ]+"></td>
        </tr>
        <tr>
            <th>So dien thoai:</th>
            <td><input name="phone" type="text" required value="${room.getPhone()}" pattern="0\d{9,10}"></td>
        </tr><tr>
        <th>Ngay bat dau:</th>
        <td><input name="date" type="date" required value="${room.getDate()}" min="2023-02-23"></td>
    </tr><tr>
        <th>Hinh thuc thanh toan:</th>
        <td>
            <select name="payment" required>
                <option value="1">Thang</option>
                <option value="2">Quy</option>
                <option value="3">Nam</option>
            </select>
        </td>
    </tr>
        <tr>
            <th>Ghi chu:</th>
            <td><input name="note" type="text" value="${room.getNote()}" maxlength="200"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${room.getId()}">
    <a class="btn btn-secondary" href="/rooms" role="button">Huy</a>
    <input type="submit" class="btn btn-primary" value="Luu">
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