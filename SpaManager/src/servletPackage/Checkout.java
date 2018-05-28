package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(
				java.sql.Connection con = dbRes.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTI WHERE id = ?");
				PreparedStatement ps1 = con.prepareStatement("SELECT produsCumparat,pretProdus FROM SERVICES WHERE id_client = ?");
				PreparedStatement ps3 = con.prepareStatement("SELECT SUM(pretProdus) FROM SERVICES WHERE id_client = ?");
				PrintWriter out = response.getWriter()
		   )
		{
			ps.setInt(1, Integer.parseInt(request.getParameter("idClient")));
			ps3.setInt(1, Integer.parseInt(request.getParameter("idClient")));
			
			 try(ResultSet rs = ps.executeQuery())
	           {
	        	   if(rs.next())
	        	   {
	        		   
	        		   ps1.setInt(1, Integer.parseInt(request.getParameter("idClient")));
	        		   
	        		   try(
	        				   ResultSet rs1 = ps1.executeQuery();
	        				   ResultSet rs3 = ps3.executeQuery()
	        				   
	        		  	  )
	        		   {
	        			   request.getRequestDispatcher("checkout.jsp").include(request, response);
	        			   out.println("<h1>Clientul cu id-ul " + request.getParameter("idClient") + " a solicitat serviciile :</h1><br>");
	        			   int x = 0;
	        			   
	        			   while(rs1.next())
	        			   {
	        				   out.println("<h3>" + rs1.getString(1) + " : " + rs1.getString(2) + " LEI <br></h3>");
	        				   x++;
	        			   }
	        			   if(x == 0)
	        			   {	
	        				   out.println("<h1>Niciun serviciu</h1><br>");
	        				   out.println("<h3>Credit ramas : " + rs.getDouble("credit") + "</h3><br>");
	        			   }
	        			   else
	        			   {
	        				   if(rs3.next())
	        					   {
	        					   		out.println("<h3>Total :     " + rs3.getDouble(1) + " LEI</h3></br>");	        					   
	        					   		out.println("<h3>Credit ramas : " + rs.getDouble("credit") + "</h3><br>");
	        					   }
	        			   }
	        		   }
	        	   }
	        	   else
	        	   {
	        		   request.getRequestDispatcher("checkout.jsp").include(request, response);
		               response.getWriter().println("<h1>ID Invalid!</h1>");           
	        	   }
	           }
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
