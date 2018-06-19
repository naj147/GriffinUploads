<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

  <%@include  file="menu_user2.jsp" %>



  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->
  
      <!-- sidebar menu: : style can be found in sidebar.less -->
      
   <%@include  file="menu_user.jsp" %>

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1 class="text-center">
        Mon  Profil
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
             <c:if test="${!(empty info)}">
				<div class="alert alert-info alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h6><i class="icon fa fa-info"></i><c:out value="${info}" /></h6>
              </div>
              </c:if>
          <br>
              <div class="row">
                  <div class="col-lg-10 col-lg-offset-1">
              <h4 >
                <strong class="text-light-blue">
                Nom :&nbsp;&nbsp;
                </strong>
                ${user.nom}
              </h4>

              <br>
              <h4 >
                <strong class="text-light-blue">
                Prenom :&nbsp;&nbsp;
                </strong>
                ${user.prenom}
              </h4>

              <br>
              <h4 >
                <strong class="text-light-blue">
                Email :&nbsp;&nbsp;
                </strong>
                ${user.email}
              </h4>
              
              <br>
               <h4 >
                <strong class="text-light-blue">
                URL :&nbsp;&nbsp;
                </strong>
                ${user.url}
              </h4>
              
              <br>
               <h4 >
                <strong class="text-light-blue">
                Date de création du compte :&nbsp;&nbsp;
                </strong>
                ${user.dateCreation}
              </h4>
              
              <br>
              <h4 >
                <strong class="text-light-blue">
               Taille max:&nbsp;&nbsp;
                </strong>
                <fmt:formatNumber type="number" 
            maxFractionDigits="2"  value="${taille}" /> Mo
              </h4>

              <br>
              <br>


                    
                      <a href="user?action=changerProfil" type="button" class="btn btn-block btn-primary btn-sm">
                      Modifier  profil
                      </a>
                  <br>
                  <br>

                </div>
                  
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
