package com.deyunjiaoyu.sportplay.bean;

public class FoodInfo {
    private int id;
    private String food_name;
    private int food_type;
    private String calorie;
    private int score;
private String food_type_title;

    public String getFood_type_title() {
        return food_type_title;
    }

    public void setFood_type_title(String food_type_title) {
        this.food_type_title = food_type_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getFood_type() {
        return food_type;
    }

    public void setFood_type(int food_type) {
        this.food_type = food_type;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
