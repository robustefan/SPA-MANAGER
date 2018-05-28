<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spa manger - Nr Clienti</title>
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
			<p>Selectati zona pentru care doriti sa vedeti numarul de clienti (A-F): </p> <br>
			<form action="NrClienti" method="get">
	              
	              <br> Zona(A-F):<br> <input type="text" name="zona" pattern="[A-Z]{1}" title="Zona (A-F)">
	              <br><br><input type="submit" class="btn btn-success" value="Introduceti">
			</form>
	    
		</div>




</body>
</html>