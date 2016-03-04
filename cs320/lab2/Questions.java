package cs320.lab2;

public class Questions {
    private String description;
    private String answerA;
    private String answerB;
    private String answerC;
    private int correctAnswer;
    private int inputAnswer;
    private boolean answerCorrect;
    private int currentQuestionIndex;
    
    
	public Questions(){
    }
    public Questions(String d, String aa, String ab, String ac, int cans){
    	description = d;
    	aa = answerA;
    	ab = answerB;
    	ac = answerC;
    	correctAnswer = cans;
    }

	public String readDescription() {
		return description;
	}

	public void writeDescription(String question) {
		this.description = question;
	}

	public String readAnswerA() {
		return answerA;
	}

	public void writeAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String readAnswerB() {
		return answerB;
	}

	public void writeAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String readAnswerC() {
		return answerC;
	}

	public void writeAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public int readCorrectAnswer() {
		return correctAnswer;
	}

	public void writeCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int readAnswer() {
		return inputAnswer;
	}

	public void writeAnswer(int answer) {
		this.inputAnswer = answer;
	}

	public boolean isAnswerCorrect() {
		return answerCorrect;
	}

	public int getCurrentQuestionIndex() {
		return currentQuestionIndex;
	}
	public void setCurrentQuestionIndex(int currentQuestionIndex) {
		this.currentQuestionIndex = currentQuestionIndex;
	}
	public Questions currentQuestion(){
		return this;
	}
}
