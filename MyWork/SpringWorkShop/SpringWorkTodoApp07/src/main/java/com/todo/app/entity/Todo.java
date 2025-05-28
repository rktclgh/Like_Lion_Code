package com.todo.app.entity;


import lombok.Data;

@Data
public class Todo {
    private long id;
    private String title;
    private Integer doneFlg;
    private String timeLimit;


    public String getTime_limit() {
        return timeLimit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDoneFlg() {
        return doneFlg;
    }

    public void setDoneFlg(int doneFlg) {
        this.doneFlg = doneFlg;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }
}
