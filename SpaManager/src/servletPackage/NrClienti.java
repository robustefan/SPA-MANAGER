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
 * Servlet implementation class NrClienti
 */
@WebServlet("/NrClienti")
public class NrClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NrClienti() {
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
		try (java.sql.Connection con = dbRes.getConnection();
				 PreparedStatement ps = con.prepareStatement("SELECT COUNT(id) FROM CLIENTI WHERE zona_curenta= ? ");) {
	            
			   ps.setString(1,request.getParameter("zona"));
	      
	            
	           try( ResultSet rs = ps.executeQuery();){
	             if (rs.next()) {
	            	 int nr=rs.getInt(1);
	            	 PrintWriter out = response.getWriter();

		                request.getRequestDispatcher("nrClienti.jsp").include(request, response);
		                out.print("<h1>" + nr +" clienti </h1>");
		                out.close();
		                return;
	            } 
	            
	           }
	           catch (Exception ex) {
	        	   PrintWriter out = response.getWriter();

	               request.getRequestDispatcher("nrClienti.jsp").include(request, response);
	               out.print("<h3>Eroare!</h3>");
	               out.close();
	               return;
	           }
	        }
	        catch (SQLException ex) {
	                Logger.getLogger(NrClienti.class.getName()).log(Level.SEVERE, null, ex);
	        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}