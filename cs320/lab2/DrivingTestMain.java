package cs320.lab2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DrivingTestMain")
public class DrivingTestMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DrivingTestMain() {
        super();
        
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String file = getServletContext().getRealPath("/WEB-INF/driving.txt");
		DrivingTest dtest = new DrivingTest(file);
		dtest.setCurrentQuestionIndex(0);
		getServletContext().setAttribute("dtest", dtest);
		getServletContext().setAttribute("quest", dtest.question);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DrivingTest dtest = (DrivingTest)getServletContext().getAttribute("dtest");
		
		PrintWriter out  = response.getWriter();
		out.println("<html>\n");
        out.println("<head><meta charset=\"utf-8\"><title>Driving Test</title></head>\n");
        out.println("<body>\n");
        out.println("<form action=\"DrivingTestMain\" method=\"post\">\n");
        
        int currIndex = dtest.getCurrentQuestionIndex();
        Questions currQ = dtest.getCurrentQuestion(currIndex);
        String rgName = "question" + currIndex;
        
    	out.println("<p>" + currQ.readDescription() + "</p>");
    	out.println("A <input type=\"radio\" name=\"" + rgName +  "\" value=1 />" + currQ.readAnswerA() + "<br>\n");
    	out.println("B <input type=\"radio\" name=\"" + rgName +  "\" value=2 />" + currQ.readAnswerB() + "<br>\n");
    	out.println("C <input type=\"radio\" name=\"" + rgName +  "\" value=3 />" + currQ.readAnswerC() + "<br>\n"); 
    	//System.out.println("A <input type=\"radio\" name=\"" + rgName +  "\" value=1 />" + currQ.readAnswerA() + "<br>\n");
        
        out.println("<input type=\"submit\" value=\"Submit!\"/>");
        out.println("</form>\n");
        out.println("</body>\n");
        out.println("</html>\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Questions> question = (List<Questions>)getServletContext().getAttribute("quest");
		DrivingTest dtest = (DrivingTest)getServletContext().getAttribute("dtest");
		int correct=0;
		int score=0;
		int userAnswer;
		//before the end of question
		if(!dtest.isLastQuestion()){
			
			//get user input answer
			int currIndex = dtest.getCurrentQuestionIndex();
			String rgName = "question" + currIndex;
			if(request.getParameter(rgName) !=null){
				userAnswer = Integer.parseInt(request.getParameter(rgName));
			}else{
				//when user didn't select any answer
				userAnswer = -1;
			}
			
			//update user answer
			Questions currQ = dtest.getCurrentQuestion(currIndex);
			currQ.writeAnswer(userAnswer);
			
			//show next question
			currIndex = currIndex + 1;
			dtest.setCurrentQuestionIndex(currIndex);
			currQ = dtest.getCurrentQuestion(currIndex);
			rgName = "question" + currIndex;
			PrintWriter out  = response.getWriter();
			out.println("<html>\n");
	        out.println("<head><meta charset=\"utf-8\"><title>Driving Test</title></head>\n");
	        out.println("<body>\n");
	        out.println("<form action=\"DrivingTestMain\" method=\"post\">\n");
			
			out.println("<p>" + currQ.readDescription() + "</p>");
	    	out.println("A <input type=\"radio\" name=\"" + rgName +  "\" value=1 />" + currQ.readAnswerA() + "<br>\n");
	    	out.println("B <input type=\"radio\" name=\"" + rgName +  "\" value=2 />" + currQ.readAnswerB() + "<br>\n");
	    	out.println("C <input type=\"radio\" name=\"" + rgName +  "\" value=3 />" + currQ.readAnswerC() + "<br>\n"); 
	    	//System.out.println("A <input type=\"radio\" name=\"" + rgName +  "\" value=1 />" + currQ.readAnswerA() + "<br>\n");
	        
	        out.println("<input type=\"submit\" value=\"Submit!\"/>");
	        out.println("</form>\n");
	        out.println("</body>\n");
	        out.println("</html>\n");
		}else{
			//after the end of question
			int currIndex = dtest.getCurrentQuestionIndex();
			String rgName = "question" + currIndex;
			if(request.getParameter(rgName) !=null){
				userAnswer = Integer.parseInt(request.getParameter(rgName));
			}else{
				//when user didn't select any answer
				userAnswer = -1;
			}
			
			//update user answer
			Questions currQ = dtest.getCurrentQuestion(currIndex);
			currQ.writeAnswer(userAnswer);
			
			for(int i=0;i<question.size();i++){
				
				int replyNum = question.get(i).readAnswer();
				if(replyNum == question.get(i).readCorrectAnswer()){
					correct++;
				}
			 }
			//System.out.println("size" + question.size() + "correct" + correct);
			score = (int) (correct * 100/ question.size());
			String score1 = String.format("%d", correct / question.size());
			 
			PrintWriter out  = response.getWriter();
			out.println("<html>\n");
		    out.println("<head><meta charset=\"utf-8\"><title>Driving Test</title></head>\n");
		    out.println("<body>\n");
		    out.println("<p>Your score: " + score + "</p>\n");
		    out.println("</body>\n");
		    out.println("</html>\n");
		}
			
	}

}
