<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spa manger - Login</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<style>
		h1 {
			font-size: 8vh;
			fot-weight: bold;
			text-align: center;
		}
		
		p {
			font-size: 3vh;
			text-align: center;
			font-weight: bold;
		}
	</style>
	<body>
	
		<div class="text-center">
	        <h1>Manager SPA</h1>
			<br> <br> <br> <br> <br> 
			<p> Pentru a continua, va rugam sa va logati: </p> <br>
			<form action="IndexPage" method="post">
	                <br><h3>User</h3> <br><input type="text" name="username">
	                <br><h3>Parola</h3> <br> <input type ="password" name="password">
	                <br><br>
	                <input type="submit" class="btn btn-success" value="Login">
			</form>
	    
		</div>
	</body>
</html>