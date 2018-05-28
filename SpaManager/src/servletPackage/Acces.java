package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




/**
 * Servlet implementation class Acces
 */
@WebServlet("/Acces")
public class Acces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acces() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name = "jdbc/myDb")
    private DataSource dbRes;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (java.sql.Connection con = dbRes.getConnection();) {
	     
	        int idC = Integer.parseInt(request.getParameter("IDClient"));
	        String zonaDorita = request.getParameter("zona");
	        
	        if (idC >= 1 && idC <= 1000) {
	        	
	        	if(zonaDorita.equals("A") || zonaDorita.equals("B") || zonaDorita.equals("C")) {
	              try(PreparedStatement ps2 = con.prepareStatement("UPDATE TABLE CLIENTI SET zona_curenta = ? WHERE id = ?");){
	            	  
	            	  ps2.setString(1, zonaDorita);
	            	  ps2.setInt(2, idC);
	            	  int succes = ps2.executeUpdate();
	            	  request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	              	  if (succes > 0)
	              	  {
	              		PrintWriter out = response.getWriter();
	              		out.print("<h1>Zona modificata</h1>");
	              	  }
	              	  else {
	              		PrintWriter out = response.getWriter();
	            		out.print("<h1>Eroare</h1>");
	              	  }
	              }
	              catch (Exception ex) {
	            	  PrintWriter out = response.getWriter();
	            		
		                request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
		                out.print("<h1>Clientul nu are acces in zona selectata 71</h1>");
		                out.close();
		                return;
	              }
	        	}
	        	else {
	        		PrintWriter out = response.getWriter();
	
	                request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	                out.print("<h1>Clientul nu are acces in zona selectata</h1>");
	                out.close();
	                return;
	        	}
	        }
	        
	        else 
	        if (idC>=1001 && idC<=2000) {
	        	
	        	if(zonaDorita.equals("B") || zonaDorita.equals("C") || zonaDorita.equals("D")) {
	                try(PreparedStatement ps2=con.prepareStatement("UPDATE TABLE CLIENTI SET zona_curenta=? WHERE id=?");){
	              	  
	                	ps2.setString(1, zonaDorita);
	              	  	ps2.setInt(2, idC);
	              	  	int succes=ps2.executeUpdate();
	              	  	request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	              	  	if (succes> 0)
	              	  	{
	              	  		PrintWriter out = response.getWriter();
	              	  		out.print("<h1>Zona modificata</h1>");
	              	  	}
	              	  	else {
	              	  		PrintWriter out = response.getWriter();
	              	  		out.print("<h1>Eroare</h1>");
	              	  	}
	                }	
	        	}
	          	else {
	          		PrintWriter out = response.getWriter();
	
	                  request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	                  out.print("<h1>Clientul nu are acces in zona selectata</h1>");
	                  out.close();
	                  return;
	          	}
	        }
	        else 
	        if (idC>=2001 && idC<=3000) {
	        	
	        	if(zonaDorita.equals("C") || zonaDorita.equals("D") || zonaDorita.equals("E")) {
	                try(PreparedStatement ps2=con.prepareStatement("UPDATE TABLE CLIENTI SET zona_curenta=? WHERE id=?");){
	              	  
	              	  ps2.setString(1, zonaDorita);
	              	  ps2.setInt(2, idC);
	              	  int succes=ps2.executeUpdate();
	              	request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	              	  if (succes> 0)
	              	  {
	              		PrintWriter out = response.getWriter();
	              		out.print("<h1>Zona modificata</h1>");
	              	  }
	              	 else {
	              		 PrintWriter out = response.getWriter();
	              		 out.print("<h1>Eroare</h1>");}
	                }
	            }
	          	else 
	          		{
	          		PrintWriter out = response.getWriter();
	
	                  request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	                  out.print("<h1>Clientul nu are acces in zona selectata</h1>");
	                  out.close();
	                  return;
	          	}
	        }
	        else 
	        if (idC>=3001 && idC<=4000) {
	        	
	        	if(zonaDorita.equals("D") || zonaDorita.equals("E") || zonaDorita.equals("F")) {
	                try(PreparedStatement ps2=con.prepareStatement("UPDATE CLIENTI SET zona_curenta=? WHERE id=?");){
	              	  
	              	  ps2.setString(1, zonaDorita);
	              	  ps2.setInt(2, idC);
	              	 int succes=ps2.executeUpdate();
	              	request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	             	  if (succes> 0)
	             	  {
	             		PrintWriter out = response.getWriter();
	             		out.print("<h1>Zona modificata</h1>");
	             	  }
	             	 else {PrintWriter out = response.getWriter();
	         		out.print("<h1>Eroare</h1>");}
	                }
	        	}
	          	else {
	          		PrintWriter out = response.getWriter();
	
	                  request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
	                  out.print("<h1>Clientul nu are acces in zona selectata</h1>");
	                  out.close();
	                  return;
	          	}
	        }
	          
		}
	    catch (SQLException ex) {
	        PrintWriter out = response.getWriter();

		    request.getRequestDispatcher("zoneAcces.jsp").include(request, response);
		    out.print("<h1>Clientul nu are acces in zona selectata linia 177</h1>");
		    out.close();
	        Logger.getLogger(Acces.class.getName()).log(Level.SEVERE, null, ex);
	    }
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
