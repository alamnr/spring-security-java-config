<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Area | Account Login</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/style.css" />">
    <script type="text/javascript" src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>

    </script>
  </head>
  <body>

    <!-- Nav Bar -->
    <nav class="navbar navbar-inverse ">
      <!--<div class="container-fluid">-->
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapsed" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand">AdminStrap</a>

        </div>

        <!-- Collect the nav links, and other content for toggling -->
        <div class="collapse navbar-collapse">

        </div><!--  /.nav bar collapse -->

      </div><!-- /.container-fluid -->

    </nav>

    <header id="header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center"> Admin Area <small> Account Login</small></h1>
          </div>

        </div>
      </div>
    </header>



    <section id="main">
      <div class="container">
        <div class="row">
			
          <div class="col-md-4 col-md-offset-4"> 
           <c:if  test="${ param.error  != null }">
                	<p>Username and password is not valid.</p>
           </c:if>            
           <c:if  test="${ param.logout  != null }">
                	<p>You have successfully been logged out.</p>
           </c:if> 
           <c:url value="/login" var="loginVar"></c:url>
              <form class="well" action="${loginVar}" method="post" id="login" >
                <div class="form-group">
                  <label>Name</label>
                  <input type="text" name="custom_name" class="form-control" placeholder="Enter Email">
                </div>
                <div class="form-group">
                  <label>Password</label>
                  <input type="password" name="custom_password" class="form-control" placeholder="Enter Password">
                </div>
                <sec:csrfInput/>
               
                <button type="submit" class="btn btn-default btn-block">Login</button>
              </form>

          </div>
        </div>
      </div>
    </section>
    <footer id="footer">
      <p>Copyright AdminStrap &copy;2017</p>
    </footer>

    <!-- CKEditor -->
    <script type="text/javascript">
      CKEDITOR.replace('editor1');
    </script>

    <!-- JQuery (necessary for Bootstrap's JavaScript plugin) -->
    <script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.4.min.js" />"></script>
    <!--  Include all compiled plugins (below), or include individual files as needed  -->
    <script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>">

    </script>
  </body>
</html>
