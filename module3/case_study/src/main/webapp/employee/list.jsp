<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <title>Employee management</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
    <style>
        a:hover{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="header-panel col-md-12">
    <img src="\static\img\logo.avif" alt="logo" width="100px" style="display: inline"/>
    <h1 style="display: inline">Furama resort system</h1>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light col-md-12">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Employee
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/employees">List of employee</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/employees?action=create">Add new employee</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Customer</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Services
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/services">List all services</a>
                    <a class="dropdown-item" href="/services?service_type=1">List of Villas</a>
                    <a class="dropdown-item" href="/services?service_type=2">List of House</a>
                    <a class="dropdown-item" href="/services?service_type=3">List of Room</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/services?action=create">Add new service</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contact</a>
            </li>
        </ul>
<%--        <form class="form-inline my-2 my-lg-0">--%>
<%--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--        </form>--%>
    </div>
</nav>
<div class="row" style="height: 400px">
    <div class="list-group col-md-2">
        <a href="/employees">
            <button type="button" class="list-group-item list-group-item-action active" aria-current="true">List all employee</button>
        </a>
        <a href="/employee/create.jsp">
            <button type="button" class="list-group-item list-group-item-action">Add new employee</button>
        </a>
    </div>

    <div class="col-md-10">
            <label><h3>List of Employee:</h3></label>
                    <table class="table table-bordered" id="employee-table">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Birthday</th>
                            <th scope="col">ID No.</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">Address</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Position</th>
                            <th scope="col">Education</th>
                            <th scope="col">Division</th>
                            <th scope="col">Username</th>
                            <th scope="col">Details</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <th scope="row">${employee.getEmployee_id()}</th>
                                <td><a href="/employees?action=detail&id=${employee.getEmployee_id()}">${employee.getName()}</a></td>
                                <td>${employee.getBirthday()}</td>
                                <td>${employee.getId_card()}</td>
                                <td>${employee.getPhone()}</td>
                                <td>${employee.getEmail()}</td>
                                <td>${employee.getAddress()}</td>
                                <td>
                                    <fmt:formatNumber type="currency" currencySymbol="VND">
                                        ${employee.getSalary()}
                                    </fmt:formatNumber>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test = "${employee.getPosition_id() == 1}">
                                            Receptionist
                                        </c:when>
                                        <c:when test = "${employee.getPosition_id() == 2}">
                                            Server
                                        </c:when>
                                        <c:when test = "${employee.getPosition_id() == 3}">
                                            Expert
                                        </c:when>
                                        <c:when test = "${employee.getPosition_id() == 4}">
                                            Supervisor
                                        </c:when>
                                        <c:when test = "${employee.getPosition_id() == 5}">
                                            Manager
                                        </c:when>
                                        <c:otherwise>
                                            Director
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test = "${employee.getEducation_degree_id() == 1}">
                                            Intermediate
                                        </c:when>
                                        <c:when test = "${employee.getEducation_degree_id() == 2}">
                                            College
                                        </c:when>
                                        <c:when test = "${employee.getEducation_degree_id() == 3}">
                                            University
                                        </c:when>
                                        <c:otherwise>
                                            Post-graduated
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test = "${employee.getDivision_id() == 1}">
                                            Sale - Marketing
                                        </c:when>
                                        <c:when test = "${employee.getDivision_id() == 2}">
                                            Office
                                        </c:when>
                                        <c:when test = "${employee.getDivision_id() == 3}">
                                            Serving
                                        </c:when>
                                        <c:otherwise>
                                            Management
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${employee.getUsername()}</td>
                                <td><a href="/employees?action=detail&id=${employee.getEmployee_id()}"><button class="btn btn-primary">Details</button></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
        $('#employee-table').dataTable({
            // 'searching': false,
            'pageLength' : 5,
            'info': false,
        })
    })
</script>
</body>
</html>