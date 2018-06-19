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
  
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
  <title>  Griffin Uploads</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">


    <style>
    /* FROM HTTP://WWW.GETBOOTSTRAP.COM
     * Glyphicons
     *
     * Special styles for displaying the icons and their classes in the docs.
     */

    .bs-glyphicons {
      padding-left: 0;
      padding-bottom: 1px;
      margin-bottom: 20px;
      list-style: none;
      overflow: hidden;
    }

    .bs-glyphicons li {
      float: left;
      width: 25%;
      height: 115px;
      padding: 10px;
      margin: 0 -1px -1px 0;
      font-size: 12px;
      line-height: 1.4;
      text-align: center;
      border: 1px solid #ddd;
    }

    .bs-glyphicons .glyphicon {
      margin-top: 5px;
      margin-bottom: 10px;
      font-size: 24px;
    }

    .bs-glyphicons .glyphicon-class {
      display: block;
      text-align: center;
      word-wrap: break-word; /* Help out IE10+ with class names */
    }

    .bs-glyphicons li:hover {
      background-color: rgba(86, 61, 124, .1);
    }

    @media (min-width: 768px) {
      .bs-glyphicons li {
        width: 12.5%;
      }
    }
  </style>
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">
    <div class="row">
    <div class="col-md-7 ">
    <section class="pull-right text-light-blue content-header">
      <h1>
        <strong>Griffin</strong> Uploads
      </h1>  

    </section>
    </div>

    <div class="col-md-5 ">
    <div class="pull-right">
<a href="login?action=addUser" class="btn  btn-primary btn-flat">S'inscrire</a>
<a href="login" class="btn  btn-success btn-flat">S'authentifier</a>
</div>

    </div>


    </div>
    
    
    <!-- Main content -->
   <section class="content">
<div class="box">
            <div class="box-header">
              <h3 class="box-title">Resulat de Recherche</h3>
            </div>
            <div class="box-body">
              
              <c:if test="${(empty files)}">
				<div class="alert alert-info alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
                <h6><i class="icon fa fa-info"></i>  Aucun fichier trouve</h6>
              </div>
              </c:if>
              
              
              
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Nom</th>
                  <th>Type</th>
                  <th>Taille</th>
                  <th>Date Creation</th>
                  <th>Description</th>
                  <th>nbr_tel</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
         
                <c:forEach items="${files}" var="f">
                	<tr>
                		<td><c:out value="${f.nom}" /></td>
                		<td><c:out value="${f.type}" /></td>
                		<td><fmt:formatNumber type="number" 
            maxFractionDigits="3"  value="${map_taille[f.id]}" />Mo</td>
            			<td><fmt:formatDate pattern="yyyy-MMM-dd" value="${f.dateCreation}" /></td>
                  		<td><c:out value="${f.descrip}" /></td>
                  		<td><c:out value="${f.nbr_tel}" /></td>
       			   <td>
                 
                     <a href="fichiers/<c:out value="${f.url}"/>"
							 class="btn  btn-success btn-xs">Telecharger
                    </a>
                    


                  </td>
               		</tr>
                </c:forEach>
             
                </tbody>
                <tfoot>
                <tr>
                  <th>Nom</th>
                  <th>Type</th>
                  <th>Taille</th>
                  <th>Date Creation</th>
                  <th>Description</th>
                  <th>nbr_tel</th>
                  <th>Actions</th>
                </tr>
                </tfoot>
              </table>
                <div class="row">
                   <div class="col-md-3 pull-right">
                      <button type="button" class="btn btn-block btn-primary btn-sm">Uploader
                      </button>
                   </div>

                   
                </div>
            
              
            </div>
            <!-- /.box-body -->

          </div>
          </section>
           <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
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
    $("#example1").DataTable({
        "order": [[ 5, "desc" ]]
    } );
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
