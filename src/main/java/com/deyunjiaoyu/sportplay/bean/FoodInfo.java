package com.deyunjiaoyu.sportplay.bean;

public class FoodInfo {
    private int id;
    private Integer foodType;
    private String foodName;
    private String calorie;
    private int score;
    private String foodTypeTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFoodType() {
        return foodType;
    }

    public void setFoodType(Integer foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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

    public String getFoodTypeTitle() {
        return foodTypeTitle;
    }

    public void setFoodTypeTitle(String foodTypeTitle) {
        this.foodTypeTitle = foodTypeTitle;
    }
}
