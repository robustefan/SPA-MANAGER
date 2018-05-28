<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spa manger - Client nou</title>
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
	        <h1>Introduceti date client nou!</h1>
			<br> <br> <br> <br> <br> 
			<form action="ClientNou" method="post">
	                <br><h3>Nume</h3> <br><input type="text" name="numeClient">
	                <br><h3>Prenume</h3> <br> <input type ="text" name="prenumeClient">
	                <br><h3>Email</h3> <br> <input type ="text" name="emailClient">
	                <br><h3>Credit</h3> <br> <input type ="text" name="creditClient">
	                <br><h3>Tip Bilet</h3><br><br>
	                <select name ="zona">
	                	<option value = "ABC">Zona A,B,C</option>
	                	<option value = "BCD">Zona B,C,D</option>
	                	<option value = "CDE">Zona C,D,E</option>
	                	<option value = "DEF">Zona D,E,F</option>
	                </select>
	                <br><br>
	                <input type="submit" class="btn btn-success" value="Introduceti">
			</form>
	    
		</div>
	</body>
</html>