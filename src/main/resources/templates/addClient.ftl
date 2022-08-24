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

<h1>Add new client</h1>
<div>
    <fieldset>
        <form name="item" action="" method="post">
            name:<@spring.formInput "form.name" "" "text" />
            <br>
            activity:<@spring.formInput "form.activity" "" "text" />
            <br>
            address:<@spring.formInput "form.address" "" "text" />
            <br>
            phone number:<@spring.formInput "form.phoneNumber" "" "text" />
            <br>
            <input type="submit" value="Create">
        </form>
    </fieldset>
</div>

</body>
</html>