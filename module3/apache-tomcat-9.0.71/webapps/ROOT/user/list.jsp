<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>List of users</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>User Management</h1>
<div>
<form class="form-inline" action="/users" method="post">
    <input type="hidden" name="action" value="search">
    <input type="text" class="form-control" id="searchCountry" aria-describedby="country" name="country" placeholder="Search by country">
    <button type="submit" class="btn btn-primary">Search</button>
</form>
</div>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUser">
    Add new user
</button>

<!-- Modal -->
<div class="modal fade" id="addUser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create a new user</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/users">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" aria-describedby="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" aria-describedby="email" name="email">
                    </div>
                    <div class="form-group">
                        <label for="country">Country</label>
                        <input type="text" class="form-control" id="country" aria-describedby="country" name="country">
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control" id="action" value="create" name="action">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </form>
            </div>
            <div class="modal-footer">
                <p>Modal footer</p>
            </div>
        </div>
    </div>
</div>

<h2>List of user:</h2>
<table class="table table-bordered">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td>
<%--                <a href="/users?action=edit&id=${user.id}">Edit</a>--%>
<%--                <a href="/users?action=delete&id=${user.id}">Delete</a>--%>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal${user.id}">Edit</button>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteModal${user.id}">Delete</button>
            </td>
        </tr>

        <!-- Modal -->

        <div class="modal fade" id="editModal${user.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModal${user.id}">Edit user</h5>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="/users">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name-edit" aria-describedby="name" name="name" value="${user.getName()}">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" id="email-edit" aria-describedby="email" name="email" value="${user.getEmail()}">
                            </div>
                            <div class="form-group">
                                <label for="country">Country</label>
                                <input type="text" class="form-control" id="country-edit" aria-describedby="country" name="country" value="${user.getCountry()}">
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" value="${user.getId()}" name="id">
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

        <div class="modal fade" id="deleteModal${user.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteModal${user.id}">Confirm to delete user</h5>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure to delete this user, Your action can not be undone !</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a href="/users?action=delete&id=${user.id}">
                            <button type="button" class="btn btn-primary">Confirm</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

<%--        <div class="modal fade" id="editModal${user.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--            <div class="modal-form">--%>
<%--                <div class="modal-content">--%>
<%--                    <div class="modal-header">--%>
<%--                        <h5 class="modal-title" id="editmodal${user.id}">Edit user</h5>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body">--%>
<%--                        <form method="post" action="/users">--%>
<%--                            <input type="hidden" name="id" value="${user.id}" />--%>
<%--                            <table>--%>
<%--                                <tr>--%>
<%--                                    <th>User Name:</th>--%>
<%--                                    <td>--%>
<%--                                        <input type="text" name="name" size="45"--%>
<%--                                               value="${user.name}"/>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <th>User Email:</th>--%>
<%--                                    <td>--%>
<%--                                        <input type="text" name="email" size="45"--%>
<%--                                               value="${user.email}"/>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <th>Country:</th>--%>
<%--                                    <td>--%>
<%--                                        <input type="text" name="country" size="15"--%>
<%--                                               value="${user.country}"/>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <td>--%>
<%--                                        <input type="submit" class="btn btn-secondary" value="Save"/>--%>
<%--                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                            </table>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

    </c:forEach>
</table>

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