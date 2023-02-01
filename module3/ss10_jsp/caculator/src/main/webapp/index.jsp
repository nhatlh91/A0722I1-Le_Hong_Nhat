<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1><%= "Simple Calculator" %>
</h1>
<form action="/calculator" method="post">
    <label>Calculator</label>
    <table>
        <tr>
            <td>First operand:</td>
            <td><input type="number" name="first"></td>
        </tr>
        <tr>
            <td>Operator:</td>
            <td>
                <select name="operand">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value=":">:</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Second operand:</td>
            <td><input type="number" name="second"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" id="submit" value="Calculate"></td>
        </tr>
    </table>

</form>
</body>
</html>