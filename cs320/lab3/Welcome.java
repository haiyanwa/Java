package cs320.lab3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String getUserCookie ( HttpServletRequest request){
    	for(Cookie cookie : request.getCookies()){
    		if(cookie.getName().equals("Usercookie")){
    			return cookie.getValue();
    		}
    	}
    	return null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get session
		String user_name = (String) request.getSession().getAttribute("User");
		PrintWriter out  = response.getWriter();
		out.println("<html>\n");
        out.println("<head><meta charset=\"utf-8\"><title>Cookie and Session</title></head>\n");
        out.println("<body>\n");
        //check session
		if(user_name != null){
			out.println("<p>Welcome " + user_name+ "</p>");
		}else{
			String usercookie = getUserCookie(request);
			//check cookie
			if(usercookie == null){
				//no cookie, redirect
				response.sendRedirect("Login");
			}else{
				out.println("<p>Welcome" + usercookie+ "</p>");
			}
		}
		out.println("</body>\n");
        out.println("</html>\n");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
