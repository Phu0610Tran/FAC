package com.example.fac.Model;

public class Answer {
    private String content;
    private int isCorrect;

    public Answer(String content, int isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
}
