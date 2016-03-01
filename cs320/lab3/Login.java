package cs320.lab3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter();
		out.println("<html>\n");
        out.println("<head><meta charset=\"utf-8\"><title>Cookie and Session</title></head>\n");
        out.println("<body>\n");
        out.println("<form action=\"Login\" method=\"post\">\n");
        out.println("First Name: <input type=\"text\" name=\"name\" placeholder=\"Enter Name\"/><br>\n");
        out.println("<input type=\"checkbox\" name=\"remember\" value=\"remember\"/>Remember Me<br>\n");
        out.println("<input type=\"submit\" value=\"Submit\"/>");
        out.println("</form>\n");
        out.println("</body>\n");
        out.println("</html>\n");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String User = request.getParameter("name");
		request.getSession().setAttribute("User", User);
		String Remember = request.getParameter("remember");
		if(Remember != null){
			Cookie cookie = new Cookie("Usercookie",User);
			cookie.setMaxAge(10800);
			response.addCookie(cookie);
		}
		response.sendRedirect("Welcome");
	}

}
