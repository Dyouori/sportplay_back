package com.deyunjiaoyu.sportplay.bean;

public class FoodBook {
    private int id;
    private int food_id;
    private String cook_name;
    private String cookinfo;
    private String description;
    private String img;
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

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getCook_name() {
        return cook_name;
    }

    public void setCook_name(String cook_name) {
        this.cook_name = cook_name;
    }

    public String getCookinfo() {
        return cookinfo;
    }

    public void setCookinfo(String cookinfo) {
        this.cookinfo = cookinfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
