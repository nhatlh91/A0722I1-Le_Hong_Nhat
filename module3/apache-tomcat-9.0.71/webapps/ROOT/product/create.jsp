<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Quan ly san pham</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="alert alert-primary" role="alert">
<h3>Them moi san pham</h3>
</div>
<c:if test="${fail}">
    <div class="alert alert-danger" role="alert">
        <h4>Nhap sai, hay nhap lai</h4>
    </div>
</c:if>
<div>
<form action="/products" method="post">
    <table>
        <tr>
            <th>Ten san pham: </th>
            <td><input type="text" name="name" required autofocus/></td>
        </tr>
        <tr>
            <th>Gia: </th>
            <td><input type="number" min="10000000" name="price" required/></td>
        </tr>
        <tr>
            <th>So luong: </th>
            <td><input type="number" min="1" name="quantity" required/></td>
        </tr>
        <tr>
            <th>Mau sac</th>
            <td>
                <select name="color">
                    <option value="Do" selected>Do</option>
                    <option value="Xanh">Xanh</option>
                    <option value="Den">Den</option>
                    <option value="Trang">Trang</option>
                    <option value="Vang">Vang</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>Mo ta</th>
            <td><input type="text" name="desc" maxlength="200"/></td>
        </tr>
        <tr>
            <th>Danh muc</th>
            <td>
                <select name="category_id">
                    <option value="1" selected>Dien thoai</option>
                    <option value="2">Tivi</option>
                    <option value="3">Tu lanh</option>
                    <option value="4">May giat</option>
                </select>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="hidden" name="action" value="create"/>
                <input type="submit" class="btn btn-success" value="Luu"/>
                <input type="reset" value="Xoa" class="btn btn-secondary"/>
            </td>
        </tr>
    </table>
</form>
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
<script>
    const value = document.querySelector("#value")
    const input = document.querySelector("#floor_input")
    value.textContent = input.value
    input.addEventListener("input", (event) => {
        value.textContent = event.target.value
    })
</script>
</body>
</html>