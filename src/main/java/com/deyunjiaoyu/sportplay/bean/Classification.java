package com.deyunjiaoyu.sportplay.bean;

public class Classification {
    private int id;
    private String title;

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
