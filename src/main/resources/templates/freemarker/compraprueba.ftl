<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${titulo}</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

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
            <span class="logo-lg"><b>MULTIMEDIA</b>CXA</span>
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

                <strong>Compra Paquetes</strong>
            </h1>
            <#--            <a class="btn btn-primary" href="/usuario/creacion" role="button">${agregarusuarioi18n}</a>-->
            <#--            <a class="btn btn-success" href="/usuario/default" role="button">Default creator</a>-->
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="table-responsive">
                        <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                            <table class="table">
                                <#--                                <form method="post" action="/compra/crear/">-->
                                <thead>
                                <tr>
                                    <th scope="col">Planes</th>
                                    <th scope="col">Costo</th>
                                    <th scope="col">Seleccionar Pedido</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list planes as plan>
                                    <tr>
                                        <th scope="row" value="${plan.id}">${plan.nombre}</th>
                                        <td value="${plan.costo}">${plan.costo}</td>
                                        <td style="text-align: center">
                                            <input class="seleccionPlan" id="${plan.id}" type="checkbox"/>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>

                        <#--                        <table class="table table-striped table-bordered table-condensed table-hover">-->
                        <#--                            <thead>-->

                        <#--                            <th>${nombreusuarioi18n}</th>-->
                        <#--                            <th>${activousuarioi18n}</th>-->
                        <#--                            <th>${opcionei18n}</th>-->
                        <#--                            </thead>-->

                        <#--                            <#list usuarios as usuario>-->

                        <#--                                <tr>-->
                        <#--                                    <!-- Para los campos esAdmin y active es necesario poner un ?c para representar-->
                        <#--                                     estos campos en el index ya que estos campos son boolean y a la hora de presentarlos-->
                        <#--                                     da error, ?c lo que hace es transformar estos boolean a un String "true" y false-->
                        <#--                                     solo para ser presentados aqui&ndash;&gt;-->
                        <#--                                    <td>${usuario.username}</td>-->
                        <#--                                    <td>${usuario.active?c}</td>-->
                        <#--                                    <td>-->
                        <#--                                        <a href="/usuario/borrar/?id=${usuario.id}"  data-toggle="modal"> <i class="fa fa-trash" style="font-size:23px;color:red"></i> </a>-->
                        <#--                                    </td>-->
                        <#--                                </tr>-->
                        <#--                            </#list>-->
                        <#--                        </table>-->

                    </div>

                    <label for="plan">Fotografo</label>
                    <select name="empleado" class="form-control" id="plan" required>
                        <#list empleados as empleado >
                            <option value="${empleado.id}">${empleado.nombre}</option>
                        </#list>
                    </select>
                    <label>Fecha Actual</label>
                    <input name="fecha" type="date" id="fecha" required
                           placeholder="Fecha" <#if formulario??> value="${fechaeventoi18n}" </#if>/> <br/>
                    <label>Fecha del Evento</label>
                    <input name="fechaevento" type="date" id="fechaevento" required
                           placeholder="Fecha" <#if formulario??> value="${fechaeventoi18n}" </#if>/> <br/>
                    <button class="btn btn-success" onclick="guardar()">Guardar</button>
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

<script>
    var a = "10";
    var newtotal = parseInt(a);
    let plan = [];
    $(document).ready(function () {

        console.log('ready');

        //    seleccionPlan
        $('.seleccionPlan').click(function () {
            let seleccion = $(this);

            // $('.seleccionPlan').not(this).prop('checked', false);
            let id = seleccion.attr('id');
            if (seleccion.prop("checked") === true) {
                plan.push(id);

            } else {
                plan.splice(plan.indexOf(id), 1);

            }

            console.log({'plan': plan});

        });


    });

    function guardar() {

        let idEmpleado = $('#plan').children("option:selected").val();
        let fechaevento = $('#fechaevento').val();
        let fecha = $('#fecha').val();
        let usuarioactual = $('#usuario').val();

        let request = new XMLHttpRequest();

        request.open('POST', '/compra/crear?idPlanes=' + plan +'&idUsuario='+ usuarioactual + '&idEmpleado=' + idEmpleado + '&fechaEvento=' + fechaevento + '&fecha=' + fecha + '&total=' + newtotal, true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        request.send();

    }


</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>