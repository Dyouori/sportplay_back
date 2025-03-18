package com.deyunjiaoyu.sportplay.bean.result;

import lombok.Data;

/**
 * @author tanyongpeng
 * <p>des</p>
 **/
@Data
public class FaceResult {
    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public Float getScore() {
        return score;
    }

    public static Integer getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static Integer getSatisfyScore() {
        return SATISFY_SCORE;
    }

    public static Integer getFaceError() {
        return FACE_ERROR;
    }

    public static Integer getNotFoundFace() {
        return NOT_FOUND_FACE;
    }

    public static Integer getNullError() {
        return NULL_ERROR;
    }

    public static Integer getForbiddenFace() {
        return FORBIDDEN_FACE;
    }

    public static Integer getInitFace() {
        return INIT_FACE;
    }

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 状态码
     */
    private int code;

    /**
     * 验证人姓名
     */
    private String name;

    /**
     * 返回token
     */
    private String token;

    /**
     * 数据集
     */
    private Object data;

    /**
     * 相似度
     */
    private Float score;
    private String UserToken;

    public String getUserToken() {
        return UserToken;
    }

    public void setUserToken(String userToken) {
        UserToken = userToken;
    }

    /*成功*/
    public static final Integer SUCCESS_CODE = 200;
    /*相似匹配度*/
    public static final Integer SATISFY_SCORE = 80;
    /*调用腾讯云接口发生的异常*/
    public static final Integer FACE_ERROR = -1;
    /*数据库没有该人脸*/
    public static final Integer NOT_FOUND_FACE = -2;
    /*人脸数据为空*/
    public static final Integer NULL_ERROR = -3;
    /*当前人脸被禁用*/
    public static final Integer FORBIDDEN_FACE = -4;
    /*初始化人脸*/
    public static final Integer INIT_FACE = 201;


    public FaceResult setCode(int code) {
        this.code = code;
        return this;
    }

    public FaceResult setData(Object data) {
        this.data = data;
        return this;
    }

    public FaceResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public FaceResult setScore(Float score) {
        this.score = score;
        return this;
    }

    public static FaceResult error(int code, String msg){
        return new FaceResult().setCode(code).setMsg(msg);
    }

    public static FaceResult error(int code,String msg,Float score){
        return new FaceResult().setCode(code).setMsg(msg).setScore(score);
    }

    public static FaceResult error(int code){
        return new FaceResult().setCode(code);
    }

    public static FaceResult success(){
        return new FaceResult().setCode(SUCCESS_CODE);
    }
    public static FaceResult success(Object data){
        return new FaceResult().setCode(SUCCESS_CODE).setData(data);
    }
    public static FaceResult success(String msg){
        return new FaceResult().setCode(SUCCESS_CODE).setMsg(msg);
    }
}
