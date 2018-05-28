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
 * Servlet implementation class IndexPage
 */
@WebServlet("/IndexPage")
public class IndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexPage() {
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
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// TODO Auto-generated method stub
			  
			try (
					java.sql.Connection con = dbRes.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE user = ? AND parola = ?");
				) 
			{
	            
			   ps.setString(1,request.getParameter("username"));
	           ps.setString(2,request.getParameter("password"));
	            
	           try( ResultSet rs = ps.executeQuery())
	           {
	             if (rs.next()) 
	             {
	                response.sendRedirect("admin.jsp");
	             } 
	             else 
	            {
	                PrintWriter out = response.getWriter();

	                request.getRequestDispatcher("index.jsp").include(request, response);
	                out.print("<h3>Username sau parola incorecte!</h3>");
	                out.close();
	            }
	           }
	           catch (Exception ex) 
	           {
	        	   PrintWriter out = response.getWriter();

	               request.getRequestDispatcher("index.jsp").include(request, response);
	               out.print("<h3>Username sau parola incorecte!</h3>");
	               out.close();
	           }
	        }
	        catch (SQLException ex) 
			{
	                Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
			
		doGet(request, response);
	}

}
