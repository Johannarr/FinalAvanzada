<!DOCTYPE html>
<!--Nota no se pueden copiar y pegar la misma plantilla para usarse, pues dara error, por lo tanto es necesario poner una plantilla
 de base y que las demas hereden-->

<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${titulo}</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Nota importante para agregar recursos. los recursos se guardan en la carpeta static y esta no es necesario que se mencione
     cuando se esta agregando el link como se ve en el link de abajo no mencione static en ningun momento
     por ultimo para indicar que saldremos de una carpeta para ir para atras esto se indica con ../ -->
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>C</b>XA</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>E&J</b>CXA</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->

                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${usuario}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>

                                    <!--Aqui agrego el nombre del usuario logueado -->
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">

                                    </div>
                                    <div class="col-xs-4 text-center">

                                    </div>
                                    <div class="col-xs-4 text-center">

                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                </div>
                                <div class="pull-right">
                                    <a href="/logout" class="btn btn-danger">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->

                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <!--Aqui pongo el nombre del usuario tambien -->
                    <p>${usuario}</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->

            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <!-- Optionally, you can add icons to the links -->
                <li><a href="/cliente/"><i class="fa fa-users"></i> <span>Clientes</span></a></li>
                <li><a href="/plan/"><i class="fa fa-users"></i> <span>Planes</span></a></li>
                <li><a href="/compra/"><i class="fa fa-desktop"></i> <span>Facturacion</span></a></li>
                <li><a href="/empleado/"><i class="fa fa-desktop"></i> <span>Empleados</span></a></li>
                <li><a href="/usuario/"><i class="fa fa-desktop"></i> <span>Usuarios</span></a></li>


            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1 class="text-center">
                <!--Aqui agregare el texto de la pagina -->
                <strong>${listaalquileri18n}</strong>
            </h1>
            <a class="btn btn-primary" href="/alquiler/creacion" role="button">${agregaralquileri18n}</a>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-condensed table-hover">
                            <thead>

                            <th>${clientealquileri18n}</th>
                            <th>${fechaalquileri18n}</th>
                            <th>${fechaentregaalquileri18n}</th>
                            <th>${totalalquileri18n}</th>
                            <th>${opcionei18n}</th>
                            </thead>

                            <!--De esta forma se crea un foreach en freemarker -->
                            <#list alquileres as alquiler >
                            <tr>

                                <!-- Como ya tengo una relacion establecida con la clase cliente, puedo llamarlo de esta forma  -->
                                <td>${alquiler.cliente.nombre}</td>

                                <!-- Como equipos representraba una lista no es correcto mostrarse en el index ya que son varios elementos
                                y en la cuadriculas del index normalmente solo se guarda 1 elemento-->


                                <!--De esta forma puedo representar fechas en el index como texto -->
                                <td>${alquiler.fecha?date}</td>
                                <td>${alquiler.fechaEntrega?date}</td>


                                <td>${alquiler.total}</td>
                                <td>
                                    <a href="/alquiler/mostrar/?id=${alquiler.id}">  <i class="fa fa-eye" style="font-size:25px"></i></a>
                                    <a href="/alquiler/borrar/?id=${alquiler.id}" data-toggle="modal"> <i class="fa fa-trash" style="font-size:23px;color:red"></i> </a>
                                </td>
                            </tr>
                            <!--Aqui cierro el foreach -->
                            </#list>
                        </table>

                    </div>
                </div>

            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <!-- Default to the left -->
        <strong>Copyright &copy; 2019 <a href="#">E&J</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->

     <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>