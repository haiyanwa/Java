package cs320.midterm;
/**
 * create a car inventory management system
 * /
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.lab2.Questions;


@WebServlet("/Midterm/CarAdmin")
public class CarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CarAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Car> cars = new ArrayList<Car>();
		getServletContext().setAttribute("cars", cars);
		
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> cars = (List<Car>)getServletContext().getAttribute("cars");
		//add car form
		PrintWriter out  = response.getWriter();
		out.println("<html>\n");
        out.println("<head><meta charset=\"utf-8\"><title>Add Car Form</title></head>\n");
        out.println("<body>\n");
        out.println("<p><h1>Car Administrator</h1></p>\n");
        out.println("<form action=\"CarAdmin\" method=\"post\">\n");
        out.println("Make<br>\n");
        out.println("<input type=\"text\" name=\"make\" placeholder=\"Ex:Honda,Lexus,etc...\"/><br>\n");
        out.println("Model<br>\n");
        out.println("<input type=\"text\" name=\"model\" placeholder=\"Ex:Civic,Accord,IS300,etc...\"/><br>\n");
        out.println("Year<br>\n");
        out.println("<input type=\"text\" name=\"year\" placeholder=\"Ex:1999,2014,etc...\"/><br>\n");        
        out.println("<input type=\"submit\" name=\"add\" value=\"Add\"/>");
        out.println("</form>\n");
        
      //search form
        out.println("<p><h1>Current Inventory</h1></p>\n");
        out.println("<form action=\"CarAdmin\" method=\"post\">\n");
        out.println("Search<br>\n");
        out.println("<input type=\"text\" name=\"searchterm\" placeholder=\"Enter a search term\"/><br>\n");
        out.println("Search Field<br>\n");
        out.println("<select name=\"searchoption\">\n");
        out.println("<option value=\"make\" selected>Make\n");
        out.println("<option value=\"model\">Model\n");
        out.println("<option value=\"year\">Year\n");
        out.println("<option value=\"all\">All\n");
        out.println("</select><br>\n");
        out.println("<input type=\"submit\" name=\"search\" value=\"Search\"/>");
        out.println("</form>\n");
        
        out.println("<table border=1 id=\"inventory\"><tr><th>Make</th><th>Model</th><th>Year</th><th></th></tr>\n");
		if(request.getParameter("delete") != null){
			System.out.println("test" + request.getParameter("delete") + "test" );
			int id = Integer.parseInt(request.getParameter("delete"));
			for(int i=0;i<cars.size();i++){
				if(cars.get(i).getId() == id){
					cars.remove(i);
				}
			}
			
	        for(int i=0;i<cars.size();i++){
	        	out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	out.println("<td><a href=CarAdmin?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        }
	        
		}
		out.println("</table>\n");
		out.println("</body>\n");
        out.println("</html>\n");
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> cars = (List<Car>)getServletContext().getAttribute("cars");
		
		String err = "";
		PrintWriter out  = response.getWriter();
		out.println("<html>\n");
        out.println("<head><meta charset=\"utf-8\"><title>Add Car Form</title></head>\n");
        out.println("<body>\n");
        out.println("<p><h1>Car Administrator</h1></p>\n");
       
		if(request.getParameter("add") != null){
			
			String make = request.getParameter("make").trim();
			String model = request.getParameter("model").trim();
			String year = request.getParameter("year").trim();
			boolean yearValid = true;
			
			if(make == ""){
				//error
				err="Error: Please input car make!";
			}else if(model == ""){
				//error
				err="Error: Please input car model!";
			}else if(year == ""){
				//error
				err="Error: Please input car year!";
				String yearPattern = "\\d\\d\\d\\d";
				java.util.regex.Pattern p = java.util.regex.Pattern.compile(yearPattern);
			    java.util.regex.Matcher mf = p.matcher(year);
		    	if(mf.matches()==false){
		    		err += "Year ex: 1999";
		    		yearValid = false;
		    	}
			}
			if(err != ""){			
	        	out.println("Error: " + err);
			}
			out.println("<form action=\"CarAdmin\" method=\"post\">\n");
	        out.println("Make<br>\n");
	        out.println("<input type=\"text\" name=\"make\" value = \"" + make +  "\" placeholder=\"Ex:Honda,Lexus,etc...\"/><br>\n");
	        out.println("Model<br>\n");
	        out.println("<input type=\"text\" name=\"model\" value = \"" + model + "\" placeholder=\"Ex:Civic,Accord,IS300,etc...\"/><br>\n");
	        out.println("Year<br>\n");
	        out.println("<input type=\"text\" name=\"year\" value = \"" + year + "\" placeholder=\"Ex:1999,2014,etc...\"/><br>\n");        
	        out.println("<input type=\"submit\" name=\"add\" value=\"Add\"/>");
	        out.println("</form>\n");
	        
	        //search form
	        out.println("<p><h1>Current Inventory</h1></p>\n");
	        out.println("<form action=\"CarAdmin\" method=\"post\">\n");
	        out.println("Search<br>\n");
	        out.println("<input type=\"text\" name=\"searchterm\" placeholder=\"Enter a search term\"/><br>\n");
	        out.println("Search Field<br>\n");
	        out.println("<select name=\"searchoption\">\n");
	        out.println("<option value=\"make\" selected>Make\n");
	        out.println("<option value=\"model\">Model\n");
	        out.println("<option value=\"year\">Year\n");
	        out.println("<option value=\"all\">All\n");
	        out.println("</select><br>\n");
	        out.println("<input type=\"submit\" name=\"search\" value=\"Search\"/>");
	        out.println("</form>\n");
	        
	        if((make!="") && (model!="") && yearValid){
				//add data
	        	
	        	int id = cars.size();
				cars.add(new Car(id,make,model,year));
			}
	        
	        //show tables of added cars
			out.println("<table border=1 id=\"inventory\"><tr><th>Make</th><th>Model</th><th>Year</th><th></th></tr>\n");
	        for(int i=0;i<cars.size();i++){
	        	out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	out.println("<td><a href=CarAdmin?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        }
	        out.println("</table>\n");
			
		}else if(request.getParameter("search") != null){
			
			String searchTerm = request.getParameter("searchterm").trim();
			String searchOpt = request.getParameter("searchoption").trim();
			System.out.println("term " + searchTerm + "serachopt" + searchOpt);
			
			if(searchTerm == null){
				err = "Please input search term!";
			}
			if(err != ""){			
	        	out.println("Error: " + err);
			}
			out.println("<form action=\"CarAdmin\" method=\"post\">\n");
	        out.println("Make\n");
	        out.println("<input type=\"text\" name=\"make\"  placeholder=\"Ex:Honda,Lexus,etc...\"/>\n");
	        out.println("Model\n");
	        out.println("<input type=\"text\" name=\"model\"  placeholder=\"Ex:Civic,Accord,IS300,etc...\"/>\n");
	        out.println("Year\n");
	        out.println("<input type=\"text\" name=\"year\"  placeholder=\"Ex:1999,2014,etc...\"/>\n");        
	        out.println("<input type=\"submit\" name =\"add\" value=\"Add\"/>");
	        out.println("</form>\n");
	        
	        //search form
	        out.println("<p><h1>Current Inventory</h1></p>\n");
	        out.println("<form action=\"CarAdmin\" method=\"post\">\n");
	        out.println("Search\n");
	        out.println("<input type=\"text\" name=\"searchterm\" placeholder=\"Enter a search term\"/>\n");
	        out.println("Search Field\n");
	        out.println("<select name=\"searchoption\">\n");
	        out.println("<option value=\"make\" selected>Make\n");
	        out.println("<option value=\"model\">Model\n");
	        out.println("<option value=\"year\">Year\n");
	        out.println("<option value=\"all\">All\n");
	        out.println("</select>\n");
	        out.println("<input type=\"submit\" name=\"search\" value=\"Search\"/>");
	        out.println("</form>\n");
	      
			
	        //show tables of car search result
			out.println("<table border=1 id=\"inventory\"><tr><th>Make</th><th>Model</th><th>Year</th><th></th>\n");
	        if(searchTerm!=null){
	        	//do search
	        	if(searchOpt.equals("make")){
	        		System.out.println("serach by make");
	        		for(int i=0;i<cars.size();i++){
	        			if(cars.get(i).getMake().contains(searchTerm)){
	        				out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	        	out.println("<td><a href=CarAdmin.java?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        			}
	        		}
	        	}else if(searchOpt.equals("model")){
	        		for(int i=0;i<cars.size();i++){
	        			if(cars.get(i).getModel().contains(searchTerm)){
	        				out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	        	out.println("<td><a href=CarAdmin.java?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        			}
	        		}
	        	}else if(searchOpt.equals("year")){
	        		for(int i=0;i<cars.size();i++){
	        			if(cars.get(i).getYear().contains(searchTerm)){
	        				out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	        	out.println("<td><a href=CarAdmin.java?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        			}
	        		}
	        	}else{
	        		//all
	        		for(int i=0;i<cars.size();i++){
	        			if(cars.get(i).getMake().contains(searchTerm)){
	        				out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	        	out.println("<td><a href=CarAdmin.java?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        			}
	        			if(cars.get(i).getModel().contains(searchTerm)){
	        				out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	        	out.println("<td><a href=CarAdmin.java?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        			}
	        			if(cars.get(i).getYear().contains(searchTerm)){
	        				out.println("<tr><td>" + cars.get(i).getMake() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getModel() + "</td>\n");
	        	        	out.println("<td>" + cars.get(i).getYear() + "</td>\n");
	        	        	out.println("<td><a href=CarAdmin.java?delete=" + cars.get(i).getId() + ">delete</a></td></tr>\n");
	        			}
	        		}
	        	}
	        	
	        }
	        
	        out.println("</table>\n");
		}
		
        out.println("</body>\n");
        out.println("</html>\n"); 
			
	}

}
