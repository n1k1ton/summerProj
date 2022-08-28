<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Favors</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        .table-center {
            display: flex;
            place-content: center;
        }
        body {
            background: url("https://t3.ftcdn.net/jpg/04/09/81/22/360_F_409812204_DB79pC30Mid4zQgUwEFOMbniRhzUUk2X.jpg") no-repeat center center fixed;
            background-size: cover;
        }
        .favors_heading{
            border-top-left-radius: 20px;
            border-top-right-radius: 20px;
        }
    </style>
</head>
<body>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/ui/v1/clients/" class="nav-link px-2 text-white">Clients</a></li>
                <li><a href="/ui/v1/favors/" class="nav-link px-2 text-white">Favors</a></li>
                <li><a href="/ui/v1/loggers/" class="nav-link px-2 text-white">Logs</a></li>
                <li><a href="/ui/v1/agreements/" class="nav-link px-2 text-white">Agreement</a></li>
                <li><a href="/ui/v1/items/" class="nav-link px-2 text-white">Items</a></li>
            </ul>
        </div>
    </div>
</header>
<div class="table-center" style="display: flex; align-content: center">
    <div class="h-100 p-5 text-bg-dark text-center border border-warning mt-5 agreement_heading favors_heading" style="width: 84%">
        <h2>FAVORS</h2>
    </div>
</div>
<div class="table-center">
    <div class="table-center" style="width: 84%; display: flex; align-content: center">
        <table class="table table-primary table-striped-columns">
            <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>DESCRIPTION</th>
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            </thead>
            <tbody>
            <#list favors as favor>
                <tr>
                    <td>${favor.id}</td>
                    <td>${favor.favorName}</td>
                    <td>${favor.price}</td>
                    <td>${favor.description}</td>
                    <td>
                        <a href="/ui/v1/favors/edit/${favor.id}">
                            <button type="button" class="btn btn-warning">UPDATE</button>
                        </a>
                    </td>
                    <td>
                        <a href="/ui/v1/favors/del/${favor.id}">
                            <button type="button" class="btn btn-danger">DELETE</button>
                        </a>
                    </td>
                </tr>
            </#list>
            <tr>
                <td colspan="6"><a href="/ui/v1/favors/add" class="btn btn-primary" style="width: 100%">CREATE FAVOR</a>
                </td>
            </tr>
            </tbody>
        </table>
        <br>
    </div>
</div>


</body>
</html>