package cs320.lab2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrivingTest {
	List<Questions> question = new ArrayList<Questions>();
	int currentQuestionIndex;
	Questions currentQuestion;
	boolean lastQuestion = false;
	
	public DrivingTest(){	
	}
	
	public DrivingTest(String file){	
		try{
			readData(file);
		}catch(IOException e){
			System.out.print(e.getMessage());
		}
		currentQuestionIndex = 0;
	
	}
	
	public int getCurrentQuestionIndex() {
		return currentQuestionIndex;
	}

	public void setCurrentQuestionIndex(int currentQuestionIndex) {
		this.currentQuestionIndex = currentQuestionIndex;
	}
	public Questions getCurrentQuestion(int index){
		return question.get(index);
	}	

	public boolean isLastQuestion() {
		if(currentQuestionIndex == question.size()-1)
			lastQuestion = true;
		return lastQuestion;
	}

	public void readData(String filename) throws IOException{
    	
    	File file = new File(filename);
    	Scanner read = new Scanner(file);
    	
    	while(read.hasNext()){
			String line = read.nextLine().trim();
		    if(line.isEmpty()){
		    	continue;
		    }
		    if(!(line.isEmpty())){
    			String q = line;
        		String aa = read.nextLine().trim();
        		String ab = read.nextLine().trim();
        		String ac = read.nextLine().trim();
        		String c_ans = read.nextLine().trim();
        		//change to int
        		int cans = Integer.parseInt(c_ans);
        		Questions qst = new Questions();
        		qst.writeDescription(q);
        		qst.writeAnswerA(aa);
        		qst.writeAnswerB(ab);
        		qst.writeAnswerC(ac);
        		qst.writeCorrectAnswer(cans);
        		question.add(qst);
    		}
    	}
    	
        read.close();
    }
}
