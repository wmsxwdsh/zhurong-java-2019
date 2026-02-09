package com.zhurong.generator.persistence.mybatis.domain;

import java.util.Date;

/**
* tb_city_info Domain
* @author LZG Robot
* 2019/06/05
*/
public class TbCityInfo {

    /**
     * 表主键
     */
    private Integer id;

    /**
     * 城市项目编码
     */
    private String cityCode;

    /**
     * 城市项目名称
     */
    private String cityName;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 可视模式
     */
    private String modelFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 父级项目编码
     */
    private String parentCityCode;

    /**
     * 可视顺序
     */
    private Integer modelOrder;

    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getModelFlag() {
        return this.modelFlag;
    }

    public void setModelFlag(String modelFlag) {
        this.modelFlag = modelFlag;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getParentCityCode() {
        return this.parentCityCode;
    }

    public void setParentCityCode(String parentCityCode) {
        this.parentCityCode = parentCityCode;
    }

    public Integer getModelOrder() {
        return this.modelOrder;
    }

    public void setModelOrder(Integer modelOrder) {
        this.modelOrder = modelOrder;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}