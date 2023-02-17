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

        .table-responsive {height:180px;}
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
            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
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
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="row" style="height: 400px">
    <div class="list-group col-md-2">
        <a href="/index.jsp">
            <button type="button" class="list-group-item list-group-item-action">Home</button>
        </a>
        <a href="/service/create.jsp">
            <button type="button" class="list-group-item list-group-item-action">Add new service</button>
        </a>
        <a href="/services">
            <button type="button" class="list-group-item list-group-item-action active" aria-current="true">All services</button>
        </a>
    </div>

    <div class="col-md-10">
        <c:if test="${!villas.isEmpty()}">
            <label><h3>List of Villas:</h3></label>
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-bordered">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Service Name</th>
                        <th scope="col">Area</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Max people</th>
                        <th scope="col">Type of rent</th>
                        <th scope="col">Standard room</th>
                        <th scope="col">Other convenience</th>
                        <th scope="col">Pool area</th>
                        <th scope="col">Floors</th>
                        <th scope="col">Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${villas}" var="villa">
                    <tr>
                        <th scope="row">${villa.getId()}</th>
                        <td><a href="/services?action=display&id=${villa.getId()}">${villa.getService_name()}</a></td>
                        <td>${villa.getService_area()}</td>
                        <td><fmt:formatNumber currencySymbol="VND" type="currency" value="${villa.getService_cost()}"/></td>
                        <td>${villa.getService_max_people()}</td>
                        <td>
                            <c:choose>
                                <c:when test = "${villa.getRent_type_id() == 1}">
                                    Year
                                </c:when>
                                <c:when test = "${villa.getRent_type_id() == 2}">
                                    Month
                                </c:when>
                                <c:when test = "${villa.getRent_type_id() == 3}">
                                    Day
                                </c:when>
                                <c:otherwise>
                                    Hour
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${villa.getRoom_standard()}</td>
                        <td>${villa.getDescription_other_convenience()}</td>
                        <td>${villa.getPool_area()}</td>
                        <td>${villa.getNumber_of_floors()}</td>
                        <td><a href="/services?action=display&id=${villa.getId()}"><button class="btn btn-primary">Details</button></a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                    </table>
                </div>
            </div>
            <br>
        </c:if>

        <c:if test="${!houses.isEmpty()}">
            <label><h3>List of Houses:</h3></label>
                    <div class="row">
                        <div class="table-responsive">
            <table class="table table-bordered">

                <thead class="thead-light">
                <tr>
                    <th>ID</th>
                    <th>Service Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max people</th>
                    <th>Type of rent</th>
                    <th>Standard room</th>
                    <th>Other convenience</th>
                    <th>Floors</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${houses}" var="house">
                    <tr>
                        <td>${house.getId()}</td>
                        <td><a href="/services?action=display&id=${house.getId()}">${house.getService_name()}</a></td>
                        <td>${house.getService_area()}</td>
                        <td>
                            <fmt:formatNumber currencySymbol="VND" type="currency" value="${house.getService_cost()}"/>
                        </td>
                        <td>${house.getService_max_people()}</td>
                        <td>
                            <c:choose>
                                <c:when test = "${house.getRent_type_id() == 1}">
                                    Year
                                </c:when>
                                <c:when test = "${house.getRent_type_id() == 2}">
                                    Month
                                </c:when>
                                <c:when test = "${house.getRent_type_id() == 3}">
                                    Day
                                </c:when>
                                <c:otherwise>
                                    Hour
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${house.getRoom_standard()}</td>
                        <td>${house.getDescription_other_convenience()}</td>
                        <td>${house.getNumber_of_floors()}</td>
                        <td><a href="/services?action=display&id=${house.getId()}"><button class="btn btn-primary">Details</button></a></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
                        </div>
                    </div>
            <br>
        </c:if>

        <c:if test="${!rooms.isEmpty()}">
            <label><h3>List of Rooms:</h3></label>
            <div class="row">
                <div class="table-responsive">
            <table class="table table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>ID</th>
                    <th>Service Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max people</th>
                    <th>Type of rent</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${rooms}" var="room">
                    <tr>
                        <td>${room.getId()}</td>
                        <td><a href="/services?action=display&id=${room.getId()}">${room.getService_name()}</a></td>
                        <td>${room.getService_area()}</td>
                        <td><fmt:formatNumber currencySymbol="VND" type="currency" value="${room.getService_cost()}"/></td>
                        <td>${room.getService_max_people()}</td>
                        <td>
                            <c:choose>
                                <c:when test = "${room.getRent_type_id() == 1}">
                                    Year
                                </c:when>
                                <c:when test = "${room.getRent_type_id() == 2}">
                                    Month
                                </c:when>
                                <c:when test = "${room.getRent_type_id() == 3}">
                                    Day
                                </c:when>
                                <c:otherwise>
                                    Hour
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td><a href="/services?action=display&id=${room.getId()}"><button class="btn btn-primary">Details</button></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                </div>
            </div>
        </c:if>
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