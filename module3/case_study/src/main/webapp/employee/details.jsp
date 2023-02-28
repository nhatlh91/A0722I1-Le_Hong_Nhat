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
        <form class="form-inline my-2 my-lg-0" action="/employees">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
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
        <label><h3>Employee details:</h3></label>
        <table class="table table-bordered">
            <tr>
                <th scope="col">ID</th>
                <td>${employee.getEmployee_id()}</td>
            </tr>
            <tr>
                <th scope="col">Name</th>
                <td>${employee.getName()}</td>
            </tr>
            <tr>
                <th scope="col">Birthday</th>
                <td>${employee.getBirthday()}</td>
            </tr>
            <tr>
                <th scope="col">ID No.</th>
                <td>${employee.getId_card()}</td>
            </tr>
            <tr>
                <th scope="col">Phone</th>
                <td>${employee.getPhone()}</td>
            </tr>
            <tr>
                <th scope="col">Email</th>
                <td>${employee.getEmail()}</td>
            </tr>
            <tr>
                <th scope="col">Address</th>
                <td>${employee.getAddress()}</td>
            </tr>
            <tr>
                <th scope="col">Salary</th>
                <td>
                    <fmt:formatNumber type="currency" currencySymbol="VND">
                        ${employee.getSalary()}
                    </fmt:formatNumber>
                </td>
            </tr>
            <tr>
                <th scope="col">Position</th>
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
            </tr>
            <tr>
                <th scope="col">Education</th>
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
            </tr>
            <tr>
                <th scope="col">Division</th>
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
            </tr>
            <tr>
                <th scope="col">Username</th>
                <td>${employee.getUsername()}</td>
            </tr>
            <tr>
                <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal">Edit</button></td>
                <td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button></td>
            </tr>
        </table>
        <c:forEach var="position" items="${positions}">
            <p>${position}</p>
        </c:forEach>
    </div>
</div>

<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit employee</h5>
            </div>
            <div class="modal-body">
                <form method="post" action="/employees">
                    <table class="table table-bordered">
                        <tr>
                            <th scope="col">Employee ID</th>
                            <td>${employee.getEmployee_id()}</td>

                        </tr>
                        <tr>
                            <th scope="col">Name</th>
                            <td><input type="text" name="name" value="${employee.getName()}"></td>

                        </tr>
                        <tr>
                            <th scope="col">Birthday</th>
                            <td><input type="date" name="birthday" value="${employee.getBirthday()}"></td>

                        </tr>
                        <tr>
                            <th scope="col">ID No.</th>
                            <td><input type="text" name="id_card" value="${employee.getId_card()}"></td>

                        </tr>
                        <tr>
                            <th scope="col">Phone</th>
                            <td><input type="text" name="phone" value="${employee.getPhone()}"></td>

                        </tr>
                        <tr>
                            <th scope="col">Email</th>
                            <td><input type="email" name="email" value="${employee.getEmail()}"></td>

                        </tr>
                        <tr>
                            <th scope="col">Address</th>

                            <td><input type="text" name="address" value="${employee.getAddress()}"></td>
                        </tr>
                        <tr>
                            <th scope="col">Salary</th>
                            <td><input type="number" name="salary" value="${employee.getSalary()}"></td>
                        </tr>
                        <tr>
                            <th scope="col">Position</th>
                            <td>
                                <select name="position">
                                    <option value="1">Reception </option>
                                    <option value="2">Serving</option>
                                    <option value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option value="6">Director</option>
                                </select>
                            </td>

                        </tr>
                        <tr>
                            <th scope="col">Education</th>
                            <td>
                                <select name="education">
                                    <option value="1">Intermediate </option>
                                    <option value="2">College</option>
                                    <option value="3">University</option>
                                    <option value="4">Post-graduated</option>
                                </select>
                            </td>

                        </tr>
                        <tr>
                            <th scope="col">Division</th>
                            <td>
                                <select name="division">
                                    <option value="1">Sale - Marketing </option>
                                    <option value="2">Office</option>
                                    <option value="3">Serving</option>
                                    <option value="4">Management</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="col">Username</th>
                            <td>${employee.getUsername()}</td>

                        </tr>
                        <tr>
                            <td><input type="reset" class="btn btn-secondary" data-dismiss="modal" value="Close"></td>
                            <td><input type="submit" class="btn btn-primary" value="Submit"></td>
                        </tr>
                    </table>
                    <input type="hidden" class="form-control" value="edit" name="action">
                    <input type="hidden" class="form-control" value="${employee.getUsername()}" name="username">
                    <input type="hidden" class="form-control" value="${employee.getEmployee_id()}" name="employee_id">
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm to delete</h5>
            </div>
            <div class="modal-body">
                <p>Are you sure to delete this employee</p>
                <p>Your action can not be undone !</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <a href="/employees?action=delete&id=${employee.getEmployee_id()}">
                    <button type="button" class="btn btn-danger">Confirm</button>
                </a>
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