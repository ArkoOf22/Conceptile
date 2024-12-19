package com.Conceptile.Conceptile_Project.dto;

public class UserStats {
    private String userName;
    private int correctAnswers;
    private int incorrectAnswers;
    private int totalQuestionsAnswered;

    // Constructor
    public UserStats(String userName, int correctAnswers, int incorrectAnswers, int totalQuestionsAnswered) {
        this.userName = userName;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }
}
