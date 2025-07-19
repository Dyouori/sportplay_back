package com.deyunjiaoyu.sportplay.bean;

public class Classification {
    private int id;
    private String ctitle;

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", ctitle='" + ctitle + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }
}
