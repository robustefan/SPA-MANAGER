<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title>Pagina admin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
       
    </head>
    <style>
    	h1 {
			font-size: 5vh;
			fot-weight: bold;
			text-align: center;
		}
		h3{
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
	        <h1>Introduceti id-ul clientului pentru a efectua checkout-ul!</h1>
			<br> <br> <br> <br> <br> 
			<form action="Checkout" method="post">
	                <br><h3>Id Client</h3> <br><input type="text" name="idClient">
	                <br><br><br>	        
	                
	                <input type="submit" class="btn btn-success" value="Introduceti">
			</form>
	    
		</div>
	</body>
</html>