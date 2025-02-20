package com.deyunjiaoyu.sportplay.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private HttpStatus status = HttpStatus.OK; // 默认HTTP状态码为200 OK

    public R() {
        put("code", 0);
    }

    public R setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public static R error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(HttpStatus status, String msg) {
        R r = new R();
        r.put("code", status.value());
        r.put("msg", msg);
        r.setStatus(status);
        return r;
    }

    public ResponseEntity<String> toJsonResponseEntity() {
        return new ResponseEntity<>(JSON.toJSONString(this), this.status);
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
