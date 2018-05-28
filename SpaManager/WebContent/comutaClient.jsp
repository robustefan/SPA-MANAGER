<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spa manger - Comuta client</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<style>
		h1 {
			font-size: 8vh;
			fot-weight: bold;
			text-align: center;
	}
	</style>
	
	<body>
	
		<div class="text-center">
	        <h1>Introduceti id-ul clientului comutat!</h1>
			<br> <br> <br> <br> <br> 
			<form action="Signout" method="get">
	                <br><h3>Id client:</h3> <br><input type="text" name="idClientSignout">
	                <br><input type="submit" class="btn btn-success" value="Delogati">
			</form>
			<br><br><br>
			<form action="Login" method="get">
	                <br><h3>Id client:</h3> <br><input type="text" name="idClientLogin">
	                <br><input type="submit" class="btn btn-success" value="Logati">
			</form>
	    
		</div>
	</body>>
</html>