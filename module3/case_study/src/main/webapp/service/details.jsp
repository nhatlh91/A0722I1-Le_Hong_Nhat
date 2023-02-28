<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <title>Service management</title>
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
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Employees
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/employees">List of employee</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/employee/create.jsp">Add new employee</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Customer</a>
            </li>

            <li class="nav-item active dropdown">
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
        <form method="get" action="/services" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="row" style="height: 400px">
    <div class="list-group col-md-2">
        <a href="/service/create.jsp">
            <button type="button" class="list-group-item list-group-item-action">Add new service</button>
        </a>
        <a href="/services">
            <button type="button" class="list-group-item list-group-item-action">All services</button>
        </a>
    </div>
    <div class="col-md-10">
        <table class="table table-bordered">
            <tr>
                <th>ID:</th>
                <td>${service.getId()}</td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>${service.getService_name()}</td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>${service.getService_area()}</td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td><fmt:formatNumber currencySymbol="VND" type="currency" value="${service.getService_cost()}"/></td>
            </tr>
            <tr>
                <th>Capacity:</th>
                <td>${service.getService_max_people()}</td>
            </tr>
            <tr>
                <th>Rent type:</th>
                <td>
                    <c:choose>
                        <c:when test = "${service.getRent_type_id() == 1}">
                            Year
                        </c:when>
                        <c:when test = "${service.getRent_type_id() == 2}">
                            Month
                        </c:when>
                        <c:when test = "${service.getRent_type_id() == 3}">
                            Day
                        </c:when>
                        <c:otherwise>
                            Hour
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${service.getService_type_id() != 3}">
                <tr>
                    <th>Room standard:</th>
                    <td>${service.getRoom_standard()}</td>
                </tr>
                <tr>
                    <th>Other conveniences:</th>
                    <td>${service.getDescription_other_convenience()}</td>
                </tr>
                <tr>
                    <th>Floors:</th>
                    <td>${service.getNumber_of_floors()}</td>
                </tr>
            </c:if>
            <c:if test="${service.getService_type_id() == 1}">
                <tr>
                    <th>Pool area:</th>
                    <td>${service.getPool_area()}</td>
                </tr>
            </c:if>
            <tr>
                <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal">Edit</button></td>
                <td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#deleteModal">Delete</button></td>
            </tr>
        </table>

        <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Edit service</h5>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="/services">
                            <div class="form-group">
                                <label for="service_name">Name:</label>
                                <input type="text" class="form-control" id="service_name" aria-describedby="name" name="service_name" value="${service.getService_name()}">
                            </div>
                            <div class="form-group">
                                <label for="service_area">Area:</label>
                                <input type="number" class="form-control" id="service_area" aria-describedby="name" name="service_area" value="${service.getService_area()}">
                            </div>
                            <div class="form-group">
                                <label for="service_cost">Cost:</label>
                                <input type="text" class="form-control" id="service_cost" aria-describedby="name" name="service_cost" value=<fmt:formatNumber type="currency" value="${service.getService_cost()}"/>>
                            </div>
                            <div class="form-group">
                                <label for="service_max_people">Capacity:</label>
                                <input type="number" class="form-control" id="service_max_people" aria-describedby="name" name="service_max_people" value="${service.getService_max_people()}">
                            </div>
                            <div class="form-group">
                                <label for="rent_type_id">Rent type:</label>
                                <select name="rent_type_id" id="rent_type_id">
                                    <option value="1">Year</option>
                                    <option value="2">Month</option>
                                    <option value="3">Day</option>
                                    <option value="4">Hour</option>
                                </select>
                            </div>
                            <c:if test="${service.getService_type_id() != 3}">
                                <div class="form-group">
                                    <label for="room_standard">Room standard:</label>
                                    <input type="text" class="form-control" id="room_standard" aria-describedby="name" name="room_standard" value="${service.getRoom_standard()}">
                                </div>
                                <div class="form-group">
                                    <label for="description_other_convenience">Other convenience:</label>
                                    <input type="text" class="form-control" id="description_other_convenience" aria-describedby="name" name="description_other_convenience" value="${service.getDescription_other_convenience()}">
                                </div>
                                <div class="form-group">
                                    <label for="room_standard">Floors:</label>
                                    <input type="number" class="form-control" id="number_of_floors" aria-describedby="name" name="number_of_floors" value="${service.getNumber_of_floors()}">
                                </div>
                                <c:if test="${service.getService_type_id() == 1}">
                                    <div class="form-group">
                                        <label for="pool_area">Pool area:</label>
                                        <input type="text" class="form-control" id="pool_area" aria-describedby="name" name="pool_area" value="${service.getPool_area()}">
                                    </div>
                                </c:if>
                            </c:if>
                            <div class="form-group">
                                <input type="hidden" class="form-control" value="${service.getId()}" name="id">
                                <input type="hidden" class="form-control" value="${service.getService_type_id()}" name="service_type_id">
                                <input type="hidden" class="form-control" value="edit" name="action">
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
                        <p>Are you sure to delete this service</p>
                        <p>Your action can not be undone !</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <a href="/services?action=delete&id=${service.getId()}">
                            <button type="button" class="btn btn-warning">Confirm</button>
                        </a>
                    </div>
                </div>
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