package com.example.session;

public class Todo {

    private String title;
    private boolean done;

    // 기본 생성자
    public Todo() {
    }

    // 전체 필드 생성자
    public Todo(String title, boolean done) {
        this.title = title;
        this.done = done;
    }

    // getter
    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    // setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}