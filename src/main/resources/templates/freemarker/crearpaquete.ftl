
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title> ${titulo}</title>

    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="../../dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="../../style/style.css">

</head>
<!--body background="../../pictures/fondo.png"-->

<div class="container-form-usuario center">

    <section class="content-header">
        <h1 class="text-center">
            <strong>${agregarplani18n}</strong>
        </h1>

        <br>
    </section>


    <form method="post" class="form-horizontal" action="/plan/crear/">
        <div class="row">

            <div class="form-group">
                <label for="nombre" class="control-label col-md-3">${nombreplani18n}:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="nombre" class="form-control" required placeholder="Nombre del plan...">
                </div>

            </div>


            <div class="form-group">
                <label for="costo" class="control-label col-md-3">${costoplani18n}:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="number" name="costo" class="form-control" required placeholder="Costo...">
                </div>

            </div>


            <div class="form-group">
                <button class="btn btn-primary col-md-offset-5" type="submit">${botonguardari18n}</button>
                <a class="btn btn-danger" href="/plan/" role="button">${botoncancelari18n}</a>
            </div>


        </div>

    </form>

</div>

</body>
</html>

