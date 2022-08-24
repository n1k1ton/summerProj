<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h1>Update Favor</h1>
<div>
    <fieldset>
        <form name="favor" action="" method="post">
            id:<@spring.formInput "form.id" "" "text" />
            <br>
            favorname:<@spring.formSingleSelect "form.favorName", favornames ""/>
            <br>
            price:<@spring.formInput "form.price" "" "number" />
            <br>
            description:<@spring.formInput "form.description" "" "text" />
            <br>
            <input type="submit" value="Create">
        </form>
    </fieldset>
</div>

</body>
</html>