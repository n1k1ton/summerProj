<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        body{
            background: url("https://img.freepik.com/free-photo/hand-painted-watercolor-background-with-sky-and-clouds-shape_24972-1095.jpg?w=2000");
        }
    </style>
</head>
<body>

<h1 class="text-center">CONCLUDE AN AGREEMENT</h1>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-md-4">
            <fieldset>

                <form name="agreement" action="" method="post" >
                    Name:<input class="form-control" <@spring.formInput "form.name" "" "text"/>
                    <br>
                    Client name:<select class="form-control" <@spring.formSingleSelect "form.client", names, ""/>
                    <br>
                    Favor:<select class="form-control" <@spring.formSingleSelect "form.favor", favors, ""/>
                    <br>
                    Description:<input class="form-control" <@spring.formInput "form.description" "" "text" />
                    <br>
                    <input type="submit" value="Create/Edit" class="btn btn-dark" style="width: 100%">
                </form>
            </fieldset>
        </div>

    </div>

</div>

</body>
</html>