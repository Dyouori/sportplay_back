package com.deyunjiaoyu.sportplay.bean;

public class ClassInfo {
    private int id;
    private int classificationId;
    private String title;
    private String price;
    private String description;
    private String level;
    private String suitable;
    private  String effect;
    private  String status;
    private String cover;
    private Integer rate;
    private Integer pv;
    private Integer recommendCount;
    private  Integer wish_count;
    private  Integer collect_count;
    private  String ctitle;
    private  String teacher;

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    public Integer getWish_count() {
        return wish_count;
    }

    public void setWish_count(Integer wish_count) {
        this.wish_count = wish_count;
    }

    public Integer getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(Integer collect_count) {
        this.collect_count = collect_count;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }



    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id=" + id +
                ", classificationId=" + classificationId +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", suitable='" + suitable + '\'' +
                ", effect='" + effect + '\'' +
                ", status='" + status + '\'' +
                ", cover='" + cover + '\'' +
                ", rate=" + rate +
                ", pv=" + pv +
                ", recommend_count=" + recommendCount +
                ", wish_count=" + wish_count +
                ", collect_count=" + collect_count +
                ", ctitle='" + ctitle + '\'' +
                ", teacher='" + teacher + '\'' +
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
