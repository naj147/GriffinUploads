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
  <title>  Griffin Uploads</title>
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
          <div class="box-body text-center">
          <br>
          <br>
			   <br/>
              <br/>
              <br/>
              <br/>
              <br/>
                <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
         
			

          <p class="lead text-centre">Rechercher un fichier public sur <span class="logo-lg text-light-blue"><b>Griffin </b>Uploads </span></p>
          <br>
          <br>
          <br>
   <form action="recherche" method="post" id="form-1">
     <div class="col-lg-8 col-lg-offset-2">
     
        <div class="input-group">
          <input type="text" name="filename" class="form-control" placeholder="Rechercher un fichier..">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
       
        </div>

        <br>
        <br>
        <br>
        <br>

        <div class="row">
          <div class="col-lg-8 col-lg-offset-2">

              <div class="row">

         

              <div class="col-lg-3">
                <ul class="bs-glyphicons">
                  <span class="glyphicon glyphicon-music text-aqua"></span>
                  <span class="glyphicon-class text-light-blue lead"><label><input type="checkbox" name="extension" value="audio"> <strong>  Music </strong> </label> 
                  </span>

                </ul>
              </div>

             <div class="col-lg-3">
                <ul class="bs-glyphicons">
                  <span class="glyphicon glyphicon-picture text-aqua"></span>
                  <span class="glyphicon-class text-light-blue lead"><label><input type="checkbox" name="extension" value="image"> <strong>  Photo </strong> </label> 
                  </span>

                </ul>
	         </div>

            <div class="col-lg-3">

                <ul class="bs-glyphicons">
                  <span class="glyphicon glyphicon-facetime-video text-aqua"></span>
                  <span class="glyphicon-class text-light-blue lead"><label><input type="checkbox" name="extension" value="video"> <strong>  Video </strong> </label> 
                  </span>

                </ul>

              </div>


            <div class="col-lg-3">
                <ul class="bs-glyphicons">
                  <span class="glyphicon glyphicon-file text-aqua"></span>
                  <span class="glyphicon-class text-light-blue lead"><label><input type="checkbox" name="extension" value="application"> <strong>  Fichier </strong> </label> 
                  </span>

                </ul>

              </div>
              
            
  <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
              <br/>
                <br/>
              <br/>
              <br/>
              <br/>
           
            </div>
          </div>
        </div>
  </form>  
          </div>
                
      </div>
               
        
      <!-- /.box -->




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
