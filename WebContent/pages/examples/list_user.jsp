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
  <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">

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
    <a href="#" class="logo">
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
  
      <!-- sidebar menu: : style can be found in sidebar.less -->
      
   <%@include  file="menu_admin.jsp" %>
    

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Gestion des utilisateurs
      </h1>
    </section>



    <!-- Main content -->
    <section class="content">


          <div class="box">
			<c:if test="${!(empty info)}">
				<div class="alert alert-info alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h6><i class="icon fa fa-info"></i><c:out value="${info}" /></h6>
              </div>
              </c:if>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Nom</th>
                  <th>Prenom</th>
                  <th>Email</th>
                  <th>Date creation</th>
                  <th>taille Max</th>
                  <th>taille utilise</th>
                  <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="u">
                <tr>
                
                  <td><c:out value="${u.nom}" /></td>
                  <td><c:out value="${u.prenom}" /></td>
                  <td><c:out value="${u.email}" /></td>
                 <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${u.dateCreation}" /></td>
                  <td><fmt:formatNumber type="number" 
            maxFractionDigits="2"  value="${map_max[u.id]}" /> Mo</td>
                              <td><fmt:formatNumber type="number" 
            maxFractionDigits="2"  value="${map_utilise[u.id]}" /> Ko</td>
            

                  <td>
                  <c:if test="${u.etat==1}">

                    
                    <a href="admin?action=changeTaille&userId=<c:out value="${u.id}"/>"
                     class="btn btn-success btn-xs">Changer taille Max
                    </a>
                    
                    
  	                <a href="admin?action=bloquer&userId=<c:out value="${u.id}"/>"
                     class="btn  btn-danger btn-xs">Bloquer</a>
					</c:if>
					<c:if test="${u.etat==0}">
					

                    
					<a href="admin?action=debloquer&userId=<c:out value="${u.id}"/>"
                     class="btn  btn-danger btn-xs">Débloquer</a> 
					</c:if>


                  </td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                  <th>Nom</th>
                  <th>Prenom</th>
                  <th>Email</th>
                  <th>Date creation</th>
                  <th>taille Max</th>
                  <th>taille utilise</th>
                  <th>Actions</th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    
  </div>

  <br>

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
<!-- DataTables -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script>
  $(function () {
    $("#example1").DataTable();
/*    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });*/
  });
</script>
</body>
</html>