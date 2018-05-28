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
 * Servlet implementation class ClientNou
 */
@WebServlet("/ClientNou")
public class ClientNou extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/myDb")
    private DataSource dbRes;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientNou() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try(
				java.sql.Connection con = dbRes.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTI WHERE nume = ? and prenume = ?");
				PrintWriter out = response.getWriter()
		   )
		{
			   ps.setString(1,request.getParameter("numeClient"));
	           ps.setString(2,request.getParameter("prenumeClient"));
	           
	           try(ResultSet rs = ps.executeQuery())
	           {
	        	   if(rs.next())
	        	   {
		                request.getRequestDispatcher("clientNou.jsp").include(request, response);
		                out.print("<h3>Clientul introdus se afla deja in Spa</h3>");
		                out.close();
	        	   }
	        	   else
	        	   {
	        		   try(
	        				   PreparedStatement p = con.prepareStatement("INSERT INTO CLIENTI (id,nume,prenume,email,credit,zona_curenta) VALUES (?,?,?,?,?,?)");
	        				   PreparedStatement q = con.prepareStatement("SELECT max(id) FROM clienti WHERE id > ? and id < ?")
	        			  )
	        		   {
	        			        			   
	        			   String choice = request.getParameter("zona");
	        			   String zonaID;
	        			  	   
	        			   if(choice.equals("ABC"))				// Spa-ul nostru va contine 6 zone : A,B,C,D,E,F
	        				   {
	        				   		p.setString(6, "A");
	        				   		zonaID = "A";					// Accesul pentru fiecare tip de bilet se va face prin prima zona de pe bilet.
	        				   }
	        			   else
	        				   if(choice.equals("BCD"))
	        					   {
	        					   		p.setString(6, "B");
	        					   		zonaID = "B";
	        					   }
	        				   else
	        					   if(choice.equals("CDE"))
	        						   {
	        						   		p.setString(6, "C");
	        						   		zonaID = "C";
	        						   }
	        					   else
	        						   {
	        						   		p.setString(6, "D");
	        						   		zonaID = "D";
	        						   }
	        			
	        			   	   if(zonaID.equals("A"))
	        					   {
	        			   		 
	        					   		q.setInt(1, 0);
	        					   		q.setInt(2, 1001);
	        					   		p.setInt(1, 1);
	        					   }
	        				   else
	        					   if(zonaID.equalsIgnoreCase("B"))
	        					   {
	        						   q.setInt(1, 1000);
	        						   q.setInt(2, 2001);
	        						   p.setInt(1, 1001);
	        					   }
	        					   else
	        						   if(zonaID.equals("C"))
	        						   {
	        							   q.setInt(1, 2000);
	        							   q.setInt(2, 3001);
	        							   p.setInt(1, 2001);
	        						   }
	        						   else
	        						   {
	        							   q.setInt(1, 3000);
	        							   q.setInt(2, 4001);
	        							   p.setInt(1, 3001);
	        						   }

	        			
	        			   	try(ResultSet r = q.executeQuery())
		        			{
		        				if(r.next())
		        				{
		        					if(r.getInt(1) != 0)
		        						p.setInt(1, r.getInt(1) + 1);
		        				}
		        			}
	        			   	catch(SQLException ex)
	        			   	{
	        			   		request.getRequestDispatcher("clientNou.jsp").include(request, response);
	        					response.getWriter().println("<h3>Introducere esuata!</h3>");
	        			   	}
	        			   	
	        			  
	        		    p.setString(2, request.getParameter("numeClient"));	        			
	        		    p.setString(3, request.getParameter("prenumeClient"));	        			 
	        		    p.setString(4, request.getParameter("emailClient"));	        			
	        		    p.setDouble(5, Double.parseDouble(request.getParameter("creditClient")));
	        			  	        			        
	        		    int success = p.executeUpdate();
	        		    
	        		    request.getRequestDispatcher("clientNou.jsp").include(request, response);
	    	        			 
	    	            if(success > 0)
	    	                  out.println("<h3>Clientul introdus cu succes!</h3>");
	    	            else
	    	                  out.println("<h3>Introducere esuata!</h3>");

	        				   
	        			   
	        		   }
	        		   catch(SQLException ex)
	        		   {
	        			   request.getRequestDispatcher("clientNou.jsp").include(request, response);
	        			   response.getWriter().println("<h3>Introducere esuata!</h3>");
	        		   }
	        		   
	        	   }
	           }
	           catch(Exception ex)
	           {
	        	   request.getRequestDispatcher("clientNou.jsp").include(request, response);
    			   response.getWriter().println("<h1>Introducere esuata!</h1>");
	           }
		} 
		catch (SQLException ex) 
		{
			request.getRequestDispatcher("clientNou.jsp").include(request, response);
			response.getWriter().println("<h1>Introducere esuata!</h1>");
			Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		doGet(request, response);
	}

}
