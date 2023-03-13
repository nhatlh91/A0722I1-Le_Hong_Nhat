<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<head>
    <title>Title</title>
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
    </div>
    <div>
        <form:form action="save" method="post" modelAttribute="declare">
            <table class="table table-bordered">
                <tr>
                    <th colspan="6">Họ và tên (ghi chữ IN HOA):</th>
                </tr>
                <tr>
                    <th colspan="6"><form:input path="fullname"/></th>
                </tr>
                <tr>
                    <th colspan="2">Năm sinh:</th>
                    <th colspan="2">Giới tính:</th>
                    <th colspan="2">Quốc tịch:</th>
                </tr>
                <tr>
                    <th colspan="2"><form:input path="yearOfBirth"/></th>
                    <th colspan="2">
                        <form:select path="gender">
                            <form:option value="nam">Nam</form:option>
                            <form:option value="nữ">Nữ</form:option>
                        </form:select>
                    </th>
                    <th colspan="2">
                        <form:select path="national">
                            <form:options items="${nationals}"/>
                        </form:select>
                    </th>
                </tr>
                <tr>
                    <th colspan="6">Số hộ chiếu hoặc CMND hoặc số giấy thông hành hợp pháp khác:</th>
                </tr>
                <tr>
                    <th colspan="6"><form:input path="id"/></th>
                </tr>
                <tr>
                    <th colspan="6">Thông tin đi lại:</th>
                </tr>
                <tr>
                    <th>
                        <form:radiobutton path="transport" value="máy bay"/>
                        <form:label path="transport">Máy bay</form:label>
                    </th>
                    <th>
                        <form:radiobutton path="transport" value="tàu thuyền"/>
                        <form:label path="transport">Tàu thuyền</form:label>
                    </th>
                    <th>
                        <form:radiobutton path="transport" value="ô tô"/>
                        <form:label path="transport">Ô-tô</form:label>
                    </th>
                    <th>
                        <input type="radio" name="transport" id="other-transport" value=""/>
                        <form:label path="transport">Khác (ghi rõ):</form:label>
                    </th>
                    <th colspan="2">
                        <form:input path="transport" onfocus="tick_the_radio()"/>
                    </th>
                </tr>
                <tr>
                    <th colspan="3">Số hiệu phương tiện:</th>
                    <th colspan="3">Số ghế:</th>
                </tr>
                <tr>
                    <th colspan="3"><form:input path="vehicleId"/></th>
                    <th colspan="3"><form:input path="seatNumber"/></th>
                </tr>
                <tr>
                    <th colspan="3">Ngày khởi hành</th>
                    <th colspan="3">Ngày kết thúc</th>
                </tr>
                <tr>
                    <th colspan="3"><input name="department" type="date" required></th>
                    <th colspan="3"><input name="arrival" type="date" required></th>
                </tr>
                <tr>
                    <th colspan="6">Các tỉnh thành đã đi trong vòng 14 ngày qua:</th>
                </tr>
                <tr>
                    <th colspan="6"><form:textarea rows="4" cols="160" path="travelHistory"/></th>
                </tr>
                <tr>
                    <td colspan="6">Địa chỉ liên lạc:</td>
                </tr>
                <tr>
                    <td colspan="2">Tỉnh/thành:</td>
                    <td colspan="2">Quận/huyện:</td>
                    <td colspan="2">Phường/xã:</td>
                </tr>
                <tr>
                    <td colspan="2"><form:input path="city"/></td>
                    <td colspan="2"><form:input path="district"/></td>
                    <td colspan="2"><form:input path="ward"/></td>
                </tr>
                <tr>
                    <td colspan="6">Địa chỉ nơi ở:</td>
                </tr>
                <tr>
                    <td colspan="6"><form:input path="address"/></td>
                </tr>
                <tr>
                    <td colspan="3">Điện thoại:</td>
                    <td colspan="3">Email:</td>
                </tr>
                <tr>
                    <td colspan="3"><form:input path="phone"/></td>
                    <td colspan="3"><form:input path="email"/></td>
                </tr>
                <tr>
                    <th colspan="6">Trong vòng 14 ngày qua, anh/chị có xuất hiện các triệu chứng nào sau đây không:</th>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:checkbox path="status" value="Sốt"/>
                        Sốt
                    </td>
                    <td colspan="3">
                        <form:checkbox path="status" value="Nôn/buồn nôn"/>
                        Nôn/Buồn nôn
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:checkbox path="status" value="Ho"/>
                        Ho
                    </td>
                    <td colspan="3">
                        <form:checkbox path="status" value="Tiêu chảy"/>
                        Tiêu chảy
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:checkbox path="status" value="Khó thở"/>
                        Khó thở
                    </td>
                    <td colspan="3">
                        <form:checkbox path="status" value="Xuất huyết ngoài da"/>
                        Xuất huyết ngoài da
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:checkbox path="status" value="Đau họng"/>
                        Đau họng
                    </td>
                    <td colspan="3">
                        <form:checkbox path="status" value="Nổi ban ngoài da" title="Nổi ban ngoài da"/>
                    </td>
                </tr>
                

                <tr>
                    <th></th>
                    <td colspan="2"><input type="submit" role="button" class="btn btn-outline-primary" value="Gửi tờ khai">
                    </td>
                    <td colspan="2"><input type="reset" role="button" class="btn btn-outline-secondary" value="Khai lại">
                    </td>
                    <th></th>
                </tr>
            </table>
        </form:form>
    </div>
    <c:if test="${message != null}">
        <div style="color: red">
            <h3>
                <c:out value="${message}"/>
            </h3>
        </div>
    </c:if>
</div>

<script>
    function tick_the_radio() {
        document.getElementById("other-transport").checked = true;
    }
</script>
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
