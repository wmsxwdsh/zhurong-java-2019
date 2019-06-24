package com.zhurong.db.persistence.domain;

import java.util.Date;

public class CityInfo {
    private Integer id;

    private String cityCode;

    private String cityName;

    private Integer version;

    private String modelFlag;

    private Date createTime;

    private String creator;

    private Date modifyTime;

    private String updater;

    private String parentCityCode;

    private Integer modelOrder;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getModelFlag() {
        return modelFlag;
    }

    public void setModelFlag(String modelFlag) {
        this.modelFlag = modelFlag == null ? null : modelFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public String getParentCityCode() {
        return parentCityCode;
    }

    public void setParentCityCode(String parentCityCode) {
        this.parentCityCode = parentCityCode == null ? null : parentCityCode.trim();
    }

    public Integer getModelOrder() {
        return modelOrder;
    }

    public void setModelOrder(Integer modelOrder) {
        this.modelOrder = modelOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}