<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title>Pagina admin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <h1> Manager SPA </h1><br><br><br><br><br><br><br><br><br><br>
            <p> Optiuni: </p> <br> <br> <br>
            <a href="comutaClient.jsp"  class="btn btn-success">Schimbati starea unui client!</a>
            <a href="clientNou.jsp" class="btn btn-warning">Introduceti un nou client!</a>
            <a href="zoneAcces.jsp" class="btn btn-danger">Vezi clienti din zone SPA!</a>
            <br><br><br>
            <a href="clientCumpara.jsp" class="btn btn-warning">Selectati serviciile dorite de client!</a>
            <a href="checkout.jsp" class = "btn btn-danger">Checkout</a>
            <br>
        </div>
        
  
    </body>
</html>