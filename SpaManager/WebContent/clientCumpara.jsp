<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spa Manager - Servicii </title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<style>
		h1 {
			font-size: 5vh;
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
	        <h1>Introduceti id-ul clientului si selectati serviciile cerute!</h1>
			<br> <br> <br> <br> <br> 
			<form action="ClientCumpara" method="post">
	                <br><h3>Id Client</h3> <br><input type="text" name="idClient">
	                <br><br><br>	        
	                <select name ="servicii">
	                	<option value = "masajTailandez">Masaj tailandez</option>
	                	<option value = "masajFacial">Masaj facial</option>
	                	<option value = "tratamentFacial">Tratament facial</option>
	                	<option value = "tratamentCorporal">Tratament corporal</option>
	                	<option value = "baieTurceasca">Baie turceasca</option>
	                	<option value = "sauna">Sauna</option>
	                	<option value = "meniu1">Meniu mancare 1</option>
	                	<option value = "meniu2">Meniu mancare 2</option>
	                	<option value = "meniu3">Meniu mancare 3</option>
	                </select>
	                <br><br><br><br><br><br><br><br><br><br>
	                <input type="submit" class="btn btn-success" value="Introduceti">
			</form>
	    
		</div>
	</body>
</html>