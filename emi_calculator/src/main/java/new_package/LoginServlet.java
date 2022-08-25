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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
	        throws ServletException, IOException{
	    response.setContentType("text/html;charset=UTF-8");
	    try(PrintWriter out = response.getWriter()){
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet LoginServlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	        String logemail = request.getParameter("email");
            String logpass = request.getParameter("password");
            
            UserDatabase db =  new UserDatabase(ConnectionPro.getConnection());
            User user = db.logUser(logemail, logpass);
            
            if(user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("logUser", user);
                response.sendRedirect("welcome.jsp");
            }else{
                out.println("user not found");
            }
	        
	       out.println("</body>");
	       out.println("</html>");
	    }
}}