<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
     <link rel="stylesheet" type="text/css" href="webapp/login.css">
    
    <title>Login</title>
    <style type="text/css">
   
    </style>
    </head>
    <body>
    <div class="global-container">
	<div class="card login-form">
	<div class="card-body">
		<h3 class="card-title text-center">Log in</h3>
		<div class="card-text">
			<!--
			<div class="alert alert-danger alert-dismissible fade show" role="alert">Incorrect username or password.</div> -->
			<form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
				<!-- to error: add class "has-danger" -->
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<input type="text" name="username" class="form-control form-control-sm" id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<a href="#" style="float:right;font-size:12px;">Forgot password?</a>
					<input name="password" type="password" class="form-control form-control-sm" id="exampleInputPassword1">
				</div>
				<button type="submit"  value="Login" class="btn btn-primary btn-block">Sign in</button>
				
				<div class="sign-up">
					Don't have an account? <a href="#">Create One</a>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
    <!--  
        <form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
 
        <table align="center">
        <tr>
        <td>Email</td>
        <td><input type="text" name="username" /></td>
        </tr>
        <tr>
        <td>Password</td>
        <td><input type="text" name="password" /></td>
        </tr>
        <tr>
        <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
        <td></td>
        <td><input type="submit" value="Login"></input><input type="reset" value="Reset"></input></td>
        </tr>
        </table>
        </form>-->
    </body>
</html>