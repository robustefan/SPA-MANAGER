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
 * Servlet implementation class ClientCumpara
 */
@WebServlet("/ClientCumpara")
public class ClientCumpara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientCumpara() {
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
				PreparedStatement ps1 = con.prepareStatement("SELECT * FROM CLIENTI WHERE id = ?");
				PreparedStatement ps2 = con.prepareStatement("INSERT INTO SERVICES (id_client,produsCumparat,pretProdus) VALUES(?,?,?)");
				PreparedStatement ps3 = con.prepareStatement("SELECT pretProdus FROM preturi WHERE numeProdus = ?");
				PreparedStatement ps4 = con.prepareStatement("SELECT credit FROM CLIENTI WHERE id = ?");
	    		PreparedStatement ps5 = con.prepareStatement("UPDATE CLIENTI SET credit = ? WHERE id = ?");
				PrintWriter out = response.getWriter()
		   )
		{
			   ps1.setInt(1, Integer.parseInt(request.getParameter("idClient")));
	           
	           try(ResultSet rs = ps1.executeQuery())
	           {
	        	   if(rs.next())
	        	   {
	        		    double bilant = 0,pret = 0;
	        		    int succes;
	        		    
		                ps2.setInt(1, Integer.parseInt(request.getParameter("idClient")));
		                ps2.setString(2, request.getParameter("servicii"));
		                ps3.setString(1, request.getParameter("servicii"));
		                ps4.setInt(1, Integer.parseInt(request.getParameter("idClient")));
		                ps5.setInt(2, Integer.parseInt(request.getParameter("idClient")));
		                
		                try(ResultSet rs1 = ps4.executeQuery())
		                {
		                	if(rs1.next())
		                		bilant = rs1.getDouble(1);
		                }
		                
		                try(ResultSet rs2 = ps3.executeQuery())
		                {
		                	if(rs2.next())
		                	{
		                		ps2.setDouble(3, rs2.getDouble(1));
		                		pret = rs2.getDouble(1);		            
		                	}
		                }
		                
		                if(bilant - pret >= 0)
		                {
		               		succes = ps2.executeUpdate();
		               		if(succes > 0 )		               			
		               		{
		               		
			               		ps5.setDouble(1, bilant - pret);
			               		
			               		succes = ps5.executeUpdate();
			               		
			               		if(succes > 0 )
		               			{
			               			request.getRequestDispatcher("clientCumpara.jsp").include(request, response);
		               				out.println("<h1>Tranzactie Efectuata!</h1><br><br><h1>Bilant Updatat!</h1>");
		               			}
			               		else
		               			{
		               				System.out.println("<h1>Nu s-a putut updata bilantul clientului!</h1>");
		               			}
		               		}
		               	}
		                else
		                {
		                	request.getRequestDispatcher("clientCumpara.jsp").include(request, response);
				            response.getWriter().println("<h1>Credit Insuficient!</h1>");
		                }
		                
		                
	        	   }
	        	   else
	        	   {
	        		   request.getRequestDispatcher("clientCumpara.jsp").include(request, response);
		               response.getWriter().println("<h1>ID Invalid!</h1>");
		               
	        	   }
	           }
	           catch(Exception ex)
	           {
	        	   request.getRequestDispatcher("clientCumpara.jsp").include(request, response);
	               response.getWriter().println("<h1>Cumparare esuata!</h1>");
	           }
		} 
		catch (SQLException e) 
		{
			request.getRequestDispatcher("clientCumpara.jsp").include(request, response);
            response.getWriter().println("<h1>Cumparare esuata!</h1>");
		}
		
		doGet(request, response);
	}

}
