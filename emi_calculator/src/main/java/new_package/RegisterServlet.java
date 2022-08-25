package new_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
	        throws ServletException,IOException
	        {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter())
	    {
	       /*TODO output your page here.You may use following sample code.*/
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet RegisterServlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	       
	        
	        //make user object
	        User userModel = new User(name, email, password);

	        
	        
	        //create a database model
	        UserDatabase regUser = new UserDatabase(ConnectionPro.getConnection());
	        if (regUser.saveUser(userModel)) {
	           response.sendRedirect("index.jsp");
	        } else {
	            String errorMessage = "User Available";
	            HttpSession regSession = request.getSession();
	            regSession.setAttribute("RegError", errorMessage);
	            response.sendRedirect("register.jsp");
	        }


	        out.println("</body>");
	        out.println("</html>");
	    	}
		}
}
