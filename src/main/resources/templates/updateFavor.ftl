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
<h1 style="text-align: center">UPDATE FAVOR</h1>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-md-4">
            <fieldset>
                <form name="favor" action="" method="post">
                    id:<input class="form-control"<@spring.formInput "form.id" "" "text" />
                    <br>
                    favorname:<select class="form-control"<@spring.formSingleSelect "form.favorName", favornames ""/>
                    <br>
                    price:<input class="form-control"<@spring.formInput "form.price" "" "number" />
                    <br>
                    description:<input class="form-control"<@spring.formInput "form.description" "" "text" />
                    <br>
                    <input type="submit" value="Update" class="btn btn-warning" style="width: 100%">
                </form>
            </fieldset>
        </div>
    </div>

</div>




</body>
</html>