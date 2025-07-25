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
 * @TableName face
 */
@TableName(value ="face")
@Data
public class Face implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer fid;

    /**
     * 图片数据 base_64编码
     */
    private String faceBase;

    /**
     * 插入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 验证次数
     */
    private Integer vefNum;

    /**
     * 人脸名称
     */
    private String faceName;

    /**
     * 人脸备注
     */
    private String remark;

    /**
     * 人脸是否可用，(0==可用，1,不可用)
     */
    private Integer faceStatus;

    /**
     * 扩展字段1
     */
    private String updateExtend1;

    /**
     * 扩展字段2
     */
    private String updateExtend2;

    /**
     * 扩展字段3
     */
    private String updateExtend3;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFaceBase() {
        return faceBase;
    }

    public void setFaceBase(String faceBase) {
        this.faceBase = faceBase;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getVefNum() {
        return vefNum;
    }

    public void setVefNum(Integer vefNum) {
        this.vefNum = vefNum;
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFaceStatus() {
        return faceStatus;
    }

    public void setFaceStatus(Integer faceStatus) {
        this.faceStatus = faceStatus;
    }

    public String getUpdateExtend1() {
        return updateExtend1;
    }

    public void setUpdateExtend1(String updateExtend1) {
        this.updateExtend1 = updateExtend1;
    }

    public String getUpdateExtend2() {
        return updateExtend2;
    }

    public void setUpdateExtend2(String updateExtend2) {
        this.updateExtend2 = updateExtend2;
    }

    public String getUpdateExtend3() {
        return updateExtend3;
    }

    public void setUpdateExtend3(String updateExtend3) {
        this.updateExtend3 = updateExtend3;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}