<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<head>
    <title>Khai bao thanh cong</title>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="col-md-12">
    <div class="text-center">
        <h4>TỜ KHAI Y TẾ</h4>
        <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</h5>
        <h5 style="color: orangered">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý
            hình sự</h5>
        <h5 class="alert alert-primary">Khai báo thành công</h5>
    </div>
    <div>
        <form:form action="save" method="post" modelAttribute="declare">
            <table class="table table-bordered">
                <tr>
                    <th colspan="6">Họ và tên (ghi chữ IN HOA):</th>
                </tr>
                <tr>
                    <th colspan="6"><form:input path="fullname" readonly="true"/></th>
                </tr>
                <tr>
                    <th colspan="2">Năm sinh:</th>
                    <th colspan="2">Giới tính:</th>
                    <th colspan="2">Quốc tịch:</th>
                </tr>
                <tr>
                    <th colspan="2"><form:input path="yearOfBirth" readonly="true"/></th>
                    <th colspan="2"><form:input path="gender" readonly="true"/></th>
                    <th colspan="2"><form:input path="national" readonly="true"/></th>
                </tr>
                <tr>
                    <th colspan="6">Số hộ chiếu hoặc CMND hoặc số giấy thông hành hợp pháp khác:</th>
                </tr>
                <tr>
                    <th colspan="6"><form:input path="id" readonly="true"/></th>
                </tr>
                <tr>
                    <th colspan="3">Thông tin đi lại:</th>
                    <th colspan="3"><form:input path="transport" readonly="true"/></th>
                </tr>
                <tr>
                    <th colspan="3">Số hiệu phương tiện:</th>
                    <th colspan="3">Số ghế:</th>
                </tr>
                <tr>
                    <th colspan="3"><form:input path="vehicleId" readonly="true"/></th>
                    <th colspan="3"><form:input path="seatNumber" readonly="true"/></th>
                </tr>
                <tr>
                    <th colspan="3">Ngày khởi hành</th>
                    <th colspan="3">Ngày kết thúc</th>
                </tr>
                <tr>
                    <th colspan="3"><form:input path="department" readonly="true"/></th>
                    <th colspan="3"><form:input path="arrival" readonly="true"/></th>
                </tr>
                <tr>
                    <th colspan="6">Các tỉnh thành đã đi trong vòng 14 ngày qua:</th>
                </tr>
                <tr>
                    <th colspan="6"><form:textarea rows="4" cols="160" path="travelHistory"/></th>
                </tr>
                <tr>
                    <td colspan="6"><a href="/home" role="button" class="btn btn-outline-primary">Quay về</a>
                </tr>
            </table>
        </form:form>
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