<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        .table-center {
            display: flex;
            place-content: center;
        }
    </style>
</head>
<body>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-clients-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-clients-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/ui/v1/clients/" class="nav-link px-2 text-white">Clients</a></li>
                <li><a href="/ui/v1/favors/" class="nav-link px-2 text-white">Favors</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Logs</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Agreement</a></li>
                <li><a href="/ui/v1/items/" class="nav-link px-2 text-white">Items</a></li>
            </ul>
        </div>
    </div>
</header>
<div class="table-center" style="display: flex; align-content: center">
    <div class="h-100 p-5 text-bg-dark text-center border border-warning" style="width: 100%">
        <h2>Clients</h2>
    </div>
</div>
<div class="table-center ">
    <div class="table-center" style="width: 100%; display: flex; align-content: center">
        <table class="table table-dark table-striped-columns text-primary">
            <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>ACTIVITY</th>
                <th>ADDRESS</th>
                <th>PHONE NUMBER</th>
                <th>CREATED AT</th>
                <th>UPDATED AT</th>
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            </thead>
            <tbody>
            <#list clients as client>
                <tr>
                    <td>${client.id}</td>
                    <td>${client.name}</td>
                    <td>${client.activity}</td>
                    <td>${client.address}</td>
                    <td>${client.phoneNumber}</td>
                    <td>${client.createdAt}</td>
                    <td>${client.updatedAt?if_exists}</td>
                    <td>
                        <a href="/ui/v1/clients/edit/${client.id}">
                            <button type="button" class="btn btn-warning">UPDATE</button>
                        </a>
                    </td>
                    <td>
                        <a href="/ui/v1/clients/del/${client.id}">
                            <button type="button" class="btn btn-danger">DELETE</button>
                        </a>
                    </td>
                </tr>
            </#list>
            <tr>
                <td colspan="9"><a href="/ui/v1/clients/add" class="btn btn-success" style="width: 100%">CREATE</a></td>
            </tr>
            </tbody>
        </table>
        <br>
    </div>
</div>


</body>
</html>