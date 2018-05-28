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
 * Servlet implementation class ComutaClient
 */
@WebServlet("/ComutaClient")
public class Signout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signout() {
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
			 PreparedStatement ps = con.prepareStatement("UPDATE TABEL CLIENTI SET HASCHECKEDOUT = TRUE WHERE ID = ?");) {
	            
			ps.setString(1,request.getParameter("idClientSignout"));
            
            try( ResultSet rs = ps.executeQuery();){
              if (rs.next()) {
                 
                 int id = rs.getInt("id");
                 String nume = rs.getString("nume");
            
                 if(id == 0) 
                 	response.sendRedirect("admin.jsp");
                 else {
                	PrintWriter out = response.getWriter();

                    request.getRequestDispatcher("index.jsp").include(request, response);
                    out.print("<h1>Contul nu corespunde unui administrator!</h1>");
                    out.close();
                    return;
                }
             } 
            else {
                PrintWriter out = response.getWriter();

                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<h1>Username sau parola incorecte!</h1>");
                out.close();
                return;
            }
           }
	    }
	    catch (SQLException ex) {
	                Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
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
