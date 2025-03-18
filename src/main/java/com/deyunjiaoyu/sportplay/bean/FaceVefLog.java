package com.deyunjiaoyu.sportplay.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName face_vef_log
 */
@TableName(value ="face_vef_log")
@Data
public class FaceVefLog implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer lid;

    /**
     * 验证时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vefTime;

    /**
     * 返回code
     */
    private Integer vefCode;

    /**
     * 返回的消息
     */
    private String vefMsg;

    /**
     * 验证人
     */
    private String loginName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Date getVefTime() {
        return vefTime;
    }

    public void setVefTime(Date vefTime) {
        this.vefTime = vefTime;
    }

    public Integer getVefCode() {
        return vefCode;
    }

    public void setVefCode(Integer vefCode) {
        this.vefCode = vefCode;
    }

    public String getVefMsg() {
        return vefMsg;
    }

    public void setVefMsg(String vefMsg) {
        this.vefMsg = vefMsg;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}