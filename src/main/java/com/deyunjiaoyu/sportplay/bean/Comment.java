package com.deyunjiaoyu.sportplay.bean;

import cn.hutool.core.date.DateTime;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private Date comment_time;
    private int like_count;
    private int user_id;
    private int class_id;
    private String pic;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }
//    public LocalDateTime getComment_time() {
//        return comment_time;
//    }
//
//    public void setComment_time(LocalDateTime comment_time) {
//        this.comment_time = comment_time;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
