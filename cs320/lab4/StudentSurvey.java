package cs320.lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.GuestBookEntry;

@WebServlet("/StudentSurvey")
public class StudentSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ServletConfig config ) throws ServletException
    {
    	super.init( config );
    	List<Survey> survies = new ArrayList<Survey>();
    	getServletContext().setAttribute("survies", survies);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/StudentSurveyForm.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Survey> survies = (List<Survey>) getServletContext().getAttribute("survies");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String cin = request.getParameter("cin");
		String quarter = request.getParameter("quarter");
		String courseName = request.getParameter("course");
		String errmsg="";
		String message="Thank you for answering the survey!";
		boolean fname_valid=true;
		boolean lname_valid=true;
		boolean cin_valid=true;
		boolean quarter_valid=true;
		boolean courseName_valid=true;
		
		if(fname=="" ){
			errmsg += "First name cannot be empty!";
			fname_valid=false;
		}
		if(lname==""){
			errmsg += "last name cannot be empty!";
			lname_valid=false;
		}
		String cinPattern = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(cinPattern);
	    java.util.regex.Matcher mf = p.matcher(cin);
    	if(mf.matches()==false){
    		errmsg += "CIN has to be 9 numbers!";
    		cin_valid=true;
    	}
    	if(quarter==null){
			errmsg += "Please choose a Quarter!";
			quarter_valid=false;
		}
    	if(courseName==null){
			errmsg += "Please choose a Course!";
			courseName_valid=false;
		}		
		
		if(errmsg !=""){
			//show error message
			request.setAttribute("errmsg", errmsg);
			if(fname_valid)
				request.setAttribute("fname", fname);
			if(lname_valid)
				request.setAttribute("lname", fname);
			if(cin_valid)
				request.setAttribute("cin", cin);
			if(quarter_valid)
				request.setAttribute("quarter", quarter);
			if(courseName_valid)
				request.setAttribute("courseName", courseName);
			request.getRequestDispatcher("/WEB-INF/StudentSurveyForm.jsp").forward(request,response);
		}else{
			Survey survey = new Survey(fname,lname,cin,quarter,courseName);
			survies.add(survey);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/StudentSurveyForm.jsp").forward(request,response);
			//response.sendRedirect("StudentSurveyResult");
		}
	}

}
