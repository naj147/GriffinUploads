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


    

     
				<%@include  file="menu_user2.jsp" %>



  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->

 <%@include  file="menu_user.jsp" %>


  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1 class="text-center">
        Changer le Mot de passe
      </h1>
      </section>
   <section class="content">

      <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
       <div class="box">
          <div class="box-body">
            <div class="register-box-body">
    <p class="login-box-msg"></p>
    <c:if test="${!(empty alert)}">
	<div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="icon fa fa-ban"></i> Formulaire non valid</h4>
				l'ancien mot de passe est incorrect
              </div>
      </c:if>
    <form id="form1" name="form1" action="user" onsubmit="return validateForm()" method="post">
    <input type="hidden" name="actionName" value="modifMdp"/>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="mdpA" id="mdpA" required placeholder="l'ancien mot de passe">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="mdp" id="mdp" required placeholder="nouveau mot de passe">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="mdp2" id="mdp2" required placeholder="Répéter mot de passe">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
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

<script>
function validateForm() {
    var x = document.forms["form1"]["mdp"].value;
    var y=document.forms["form1"]["mdp2"].value;
    if (x != y) {
    	document.getElementById("demo").innerHTML = "<div class=\"callout callout-danger\"><p>Les mots de passe ne correspondent pas. Voulez-vous réessayer ?</p></div>";
        return false;
    }
}
</script>
</body>
</html>
