<!doctype html>
<html lang="en">
<head>
    <title>Furama resort</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        a:hover {
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
            <li class="nav-item active">
                <a class="nav-link" href="/index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
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
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="row" style="height: 400px">
    <div class="list-group col-md-2">
        <a href="/index.jsp">
            <button type="button" class="list-group-item list-group-item-action active" aria-current="true">Home
            </button>
        </a>
        <button type="button" class="list-group-item list-group-item-action">Employee management</button>
        <button type="button" class="list-group-item list-group-item-action">Customer management</button>
        <a href="/services">
            <button type="button" class="list-group-item list-group-item-action">Service management</button>
        </a>
        <button type="button" class="list-group-item list-group-item-action" disabled>Contact us</button>
    </div>
    <div class="col-md-10">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas elementum, dolor in auctor suscipit, magna
        quam dapibus mi, nec consectetur erat odio in nisl. Proin euismod quis mauris non tempus. Duis congue, orci non
        semper rhoncus, nisi libero lobortis justo, sed sodales arcu ipsum eu velit. Nulla tellus dolor, lacinia ut
        velit quis, venenatis dapibus augue. Pellentesque elementum ex eget posuere facilisis. Donec dignissim leo
        massa, quis imperdiet sem luctus condimentum. Donec tincidunt dignissim mollis. Praesent vitae diam non mi
        ullamcorper elementum id id nisl. Donec vulputate facilisis accumsan. Sed viverra augue vel elit commodo
        interdum. Suspendisse ultrices porttitor efficitur. Maecenas lacinia nisi et lobortis tempus. Fusce at tincidunt
        mauris. Pellentesque eu libero in risus vulputate convallis. Ut rutrum ac eros ornare imperdiet. Curabitur
        pretium nibh non cursus ultricies.
        Quisque urna augue, porta quis elementum at, laoreet eget justo. Pellentesque habitant morbi tristique senectus
        et netus et malesuada fames ac turpis egestas. Pellentesque ut maximus purus. Etiam velit ipsum, imperdiet nec
        lorem vel, dictum ultricies leo. Nunc ornare euismod ligula, non efficitur dolor tempus nec. Suspendisse
        elementum lacinia turpis facilisis blandit. Proin ac sem orci. Proin ac purus nulla. Quisque lobortis, leo quis
        congue consequat, lorem libero mattis magna, nec malesuada mauris nisl ac mauris.
        Sed vitae arcu ligula. Etiam sit amet lobortis ante. Aliquam elementum tincidunt urna vel venenatis. Morbi a
        turpis in tortor lacinia volutpat. Pellentesque ultricies, lacus sit amet elementum ornare, justo justo luctus
        risus, id gravida libero metus nec ante. Cras mauris dolor, pulvinar quis ultrices non, congue quis libero.
        Proin accumsan, elit vitae rhoncus aliquet, nibh mauris hendrerit lorem, at interdum quam nunc quis ipsum. Fusce
        fringilla commodo euismod. Sed ut lectus vel mi convallis pharetra.
        Vestibulum convallis in massa in fringilla. In et nibh felis. Aliquam vitae viverra libero. Etiam mattis cursus
        sem vitae consectetur. Aenean nulla arcu, laoreet eu suscipit vestibulum, consequat ac massa. Ut et tellus
        mauris. Suspendisse sed varius sem, ac faucibus risus. Curabitur posuere dui nisl, at porta lorem cursus sed.
        Nulla venenatis, ex sed suscipit tincidunt, nunc dui congue turpis, et mattis urna enim id tortor. Mauris varius
        urna ac velit porttitor, et imperdiet massa vestibulum. Aliquam commodo, tellus at fringilla mattis, lectus nisl
        tincidunt massa, vitae tempor dui sem eu lorem.
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