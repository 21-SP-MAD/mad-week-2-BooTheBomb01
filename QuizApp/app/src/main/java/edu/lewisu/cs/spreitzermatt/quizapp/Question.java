package edu.lewisu.cs.spreitzermatt.quizapp;

public class Question {
    private int textResID;
    private boolean answer;

    public Question(int textResID, boolean answer) {
        this.textResID = textResID;
        this.answer = answer;
    }

    public int getTextResID() {
        return textResID;
    }

    public void setTextResID(int textResID) {
        this.textResID = textResID;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
