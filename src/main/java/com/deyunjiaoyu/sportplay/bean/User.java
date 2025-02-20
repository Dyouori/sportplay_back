package com.deyunjiaoyu.sportplay.bean;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;
    private String name;
    private String phone;
private String pic;
    private int money;
    private Date birth;
    private int dreamWeight;
    private int weight;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pic='" + pic + '\'' +
                ", money=" + money +
                ", birth=" + birth +
                '}';
    }

    public int getDreamWeight() {
        return dreamWeight;
    }

    public void setDreamWeight(int dreamWeight) {
        this.dreamWeight = dreamWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
