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
  
      <!-- sidebar menu: : style can be found in sidebar.less -->
      
   <%@include  file="menu_user.jsp" %>

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1 class="text-center">
        Uploader Un fichier
      </h1>
    </section>

<br>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-lg-6 col-lg-offset-3">

		<c:if test="${!(empty errFichier)}">
		<div class="alert alert-danger alert-dismissible">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
		<h4><i class="icon fa fa-ban"></i> Probleme d'upload</h4>
		<c:out value="${errFichier}" />
		</div>
		</c:if>
		<c:if test="${!(empty info)}">
		<div class="alert alert-info alert-dismissible">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
		<h6><i class="icon fa fa-info"></i><c:out value="${info}" /></h6>
		</div>
		</c:if>
       <div class="box box-primary">
          <div class="box-body">
          <br>

              <div class="row">
                  <div class="col-lg-10 col-lg-offset-1">


                  <form action="upload" method="post" enctype="multipart/form-data">

                    <!-- <div class="form-group">
                      <label for="exampleInputEmail1">Nom de fichier</label>
                      <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                    </div> -->

                    <div class="form-group">
                      <label>Description de fichier</label>
                      <input type="text"  class="form-control"  placeholder="Enter description... " name="description"/>
                    </div>

                    <div class="checkbox">
                    
                      <label>
                        <input type="checkbox" name="shared" value="1"> Partage
                      </label>
                    </div>

                    <div class="form-group">
                      <label for="exampleInputFile">Choisir un fichier</label>
                      <input type="file" id="exampleInputFile" name="fichier">
                      <p class="help-block">le ficher ne doit pas passe la taille </p>
                    </div>
                    <div class="text-center">
                    <button type="submit" class="btn btn-success btn-lg">
                         <i class="fa fa-fw fa-upload"></i>Uploader
                    </button>
                    </div>
                     </form>

                   </div>

                  



                </div>





         

              <br>

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
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>

<!-- SlimScroll -->
<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>


</body>
</html>
