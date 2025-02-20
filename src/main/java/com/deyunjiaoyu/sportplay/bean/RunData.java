package com.deyunjiaoyu.sportplay.bean;

import java.util.Date;

public class RunData {
    private int id;
    private String step;
    private int user_id;
    private Date currentTime;
    private String date;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


}
