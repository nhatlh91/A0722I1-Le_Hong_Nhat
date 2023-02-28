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
            <button type="button" class="list-group-item list-group-item-action active" aria-current="true">Add new service</button>
        </a>
        <a href="/services">
            <button type="button" class="list-group-item list-group-item-action">All services</button>
        </a>
    </div>
    <div class="col-md-10">
        <table>
            <tr>
                <th><label for="service_type">Service type:</label></th>
                <td>
                    <select id="service_type" name="service_type">
                        <option value="1">Villa</option>
                        <option value="2">House</option>
                        <option value="3">Room</option>
                    </select>
                </td>
            </tr>
        </table>
        <div id="villa-information">
            <form action="/services" method="post">
                <input type="hidden" value="create" name="action">
                <input type="hidden" value="1" name="service_type">
                <table>
                    <tr>
                        <th>Name: </th>
                        <td><input type="text" name="service_name"></td>
                    </tr>
                    <tr>
                        <th>Area: </th>
                        <td><input type="number" name="service_area"></td>
                    </tr>
                    <tr>
                        <th>Cost: </th>
                        <td><input type="text" name="service_cost"></td>
                    </tr>
                    <tr>
                        <th>Max people: </th>
                        <td><input type="number" name="service_max_people"></td>
                    </tr>
                    <tr>
                        <th><label>Rent type:</label></th>
                        <td>
                            <select name="rent_type_id">
                                <option value="1">Year</option>
                                <option value="2">Month</option>
                                <option value="3">Day</option>
                                <option value="4">Hour</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Room standard: </th>
                        <td><input type="text" name="room_standard"></td>
                    </tr>
                    <tr>
                        <th>Other convenience: </th>
                        <td><input type="text" name="other_convenience"></td>
                    </tr>
                    <tr>
                        <th>Pool area: </th>
                        <td><input type="text" name="pool_area"></td>
                    </tr>
                    <tr>
                        <th>Floors: </th>
                        <td><input type="number" name="number_of_floors"></td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-secondary" type="reset" value="Reset"></td>
                        <td><input class="btn btn-primary" type="submit" value="Create"></td>
                    </tr>
                </table>
            </form>
        </div>

        <div id="house-information" style="display: none">
            <form action="/services" method="post">
                <input type="hidden" value="create" name="action">
                <input type="hidden" value="2" name="service_type">
                <table>
                    <tr>
                        <th>Name: </th>
                        <td><input type="text" name="service_name"></td>
                    </tr>
                    <tr>
                        <th>Area: </th>
                        <td><input type="number" name="service_area"></td>
                    </tr>
                    <tr>
                        <th>Cost: </th>
                        <td><input type="text" name="service_cost"></td>
                    </tr>
                    <tr>
                        <th>Max people: </th>
                        <td><input type="number" name="service_max_people"></td>
                    </tr>
                    <tr>
                        <th><label>Rent type:</label></th>
                        <td>
                            <select name="rent_type_id">
                                <option value="1">Year</option>
                                <option value="2">Month</option>
                                <option value="3">Day</option>
                                <option value="4">Hour</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Room standard: </th>
                        <td><input type="text" name="room_standard"></td>
                    </tr>
                    <tr>
                        <th>Other convenience: </th>
                        <td><input type="text" name="other_convenience"></td>
                    </tr>
                    <tr>
                        <th>Floors: </th>
                        <td><input type="number" name="number_of_floors"></td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-secondary" type="reset" value="Reset"></td>
                        <td><input class="btn btn-primary" type="submit" value="Create"></td>
                    </tr>
                </table>
            </form>
        </div>

        <div id="room-information" style="display: none">
            <form action="/services" method="post">
                <input type="hidden" value="create" name="action">
                <input type="hidden" value="3" name="service_type">
                <table>
                    <tr>
                        <th>Name: </th>
                        <td><input type="text" name="service_name"></td>
                    </tr>
                    <tr>
                        <th>Area: </th>
                        <td><input type="number" name="service_area"></td>
                    </tr>
                    <tr>
                        <th>Cost: </th>
                        <td><input type="text" name="service_cost"></td>
                    </tr>
                    <tr>
                        <th>Max people: </th>
                        <td><input type="number" name="service_max_people"></td>
                    </tr>
                    <tr>
                        <th><label>Rent type:</label></th>
                        <td>
                            <select name="rent_type_id">
                                <option value="1">Year</option>
                                <option value="2">Month</option>
                                <option value="3">Day</option>
                                <option value="4">Hour</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-secondary" type="reset" value="Reset"></td>
                        <td><input class="btn btn-primary" type="submit" value="Create"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script>
    var x = document.getElementById("service_type");
    x.onchange = function () {
        if (x.value == 1) {
        document.getElementById("villa-information").style.display = "block"
        document.getElementById("house-information").style.display = "none"
        document.getElementById("room-information").style.display = "none"
        } else if (x.value == 2) {
            document.getElementById("villa-information").style.display = "none"
            document.getElementById("house-information").style.display = "block"
            document.getElementById("room-information").style.display = "none"
        } else {
            document.getElementById("villa-information").style.display = "none"
            document.getElementById("house-information").style.display = "none"
            document.getElementById("room-information").style.display = "block"
        }
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