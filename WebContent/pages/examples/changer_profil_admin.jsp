<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>

<!DOCTYPE html>
<html>
<head>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Projet J2ee</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <!-- DataTables -->

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>G</b>U</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Griffin</b>Uploads</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>


              <%@include  file="menu_admin2.jsp" %>
            
    </nav>
  </header>

  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->

  <%@include  file="menu_admin.jsp" %>


  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1 class="text-center">
        Modifier votre Profil
      </h1>
    </section>

    <br>
    <br>

    <!-- Main content -->
      <section class="content">

      <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
       <div class="box">
          <div class="box-body">
            <div class="register-box-body">
    <p class="login-box-msg"></p>

    <form id="form1" name="form1" action="admin" onsubmit="return validateForm()" method="post">
    <input type="hidden" name="actionName" value="changerProfil"/>
      <div class="form-group has-feedback row">
      <label for="nom" class="col-2 col-form-label">Nom :</label>
      <div class="col-10">
        <input type="text" class="form-control" required id="nom" name="nom" value="<c:out value="${user.nom}" />">

      </div>
      </div>
      <div class="form-group has-feedback row">
            <label for="nom" class="col-2 col-form-label">Prenom :</label>
      <div class="col-10">
        <input type="text" class="form-control" name="prenom" id="prenom" required value="<c:out value="${user.prenom}" />">

      </div>
      </div>
      <div class="form-group has-feedback row">
       <label for="nom" class="col-2 col-form-label">Email :</label>
      <div class="col-10">
        <input type="email" class="form-control" name="email" required type="email" value="<c:out value="${user.email}" />">

        </div>
      </div>

      <div id="demo"></div>
      <div class="row">
        <div class="col-xs-8">

        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Valider</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

  
  </div>
          
          </div>     
        </div>
      <!-- /.box -->
</div>
  
</div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  </div>

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Projet J2ee</b>  2016-2017 
    </div>
    Abdlhadi NAJIH , Ismail MELLIL , Ismail MOUSSAOUI  
    
  </footer>

  <!-- Control Sidebar -->
  
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<!-- SlimScroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>


</body>
</html>
