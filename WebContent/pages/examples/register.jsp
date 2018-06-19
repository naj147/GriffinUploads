<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Griffin Uploads | Registration Page</title>
  <link href="/bootstrap/css/style.css">
  <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="#"><b>Griffin</b>Uploads</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Créer un compte</p>
    

    <form id="form1" action="login" method="post" onsubmit="return validateForm()" name="ServletCnx">
        <input type="hidden" name="actionName"  value="addUser"/>
    
     <% if(request.getAttribute("existdeja")!=null && request.getAttribute("existdeja")=="false"){ %> 
                      
                               
    <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="icon fa fa-ban"></i> Erreur!</h4>
              cet e-mail est deja utiliser par un autre utilisateur.Veuillez changer cet e-mail pour s'inscrire.
              </div>
 <% } %>
      <div class="form-group has-feedback">
        <input type="text"  class="form-control" name="nom" placeholder="nom" required>
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control"  name="prenom" placeholder="prenom" required>
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" name="email" type="email" placeholder="Email" required>
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="mdp" id="mdp" placeholder="mot de passe" required>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
       <div class="form-group has-feedback">
        <input type="password" class="form-control" name="mdp2" id="mdp2" placeholder="Répéter mot de passe" required>
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
     <div id="demo"></div>
      <div class="row">
        <div class="col-xs-8">

        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit"  class="btn btn-primary btn-block btn-flat">Valider</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    

    <a href="pages/examples/login.jsp" class="text-center">Je suis déja  inscrit</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
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
