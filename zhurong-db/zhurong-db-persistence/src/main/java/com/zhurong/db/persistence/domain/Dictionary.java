package com.zhurong.db.persistence.domain;

import java.util.Date;

public class Dictionary {
    private String id;

    private String dictNo;

    private String itemCode;

    private String itemName;

    private Integer version;

    private String modelFlag;

    private String parentItemCode;

    private String parentDictNo;

    private Integer modelOrder;

    private String chkSts;

    private String operType;

    private String auditor;

    private String auditOpinion;

    private Date auditTime;

    private String creator;

    private Date createTime;

    private String updater;

    private Date modifyTime;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDictNo() {
        return dictNo;
    }

    public void setDictNo(String dictNo) {
        this.dictNo = dictNo == null ? null : dictNo.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
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

    public String getParentItemCode() {
        return parentItemCode;
    }

    public void setParentItemCode(String parentItemCode) {
        this.parentItemCode = parentItemCode == null ? null : parentItemCode.trim();
    }

    public String getParentDictNo() {
        return parentDictNo;
    }

    public void setParentDictNo(String parentDictNo) {
        this.parentDictNo = parentDictNo == null ? null : parentDictNo.trim();
    }

    public Integer getModelOrder() {
        return modelOrder;
    }

    public void setModelOrder(Integer modelOrder) {
        this.modelOrder = modelOrder;
    }

    public String getChkSts() {
        return chkSts;
    }

    public void setChkSts(String chkSts) {
        this.chkSts = chkSts == null ? null : chkSts.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion == null ? null : auditOpinion.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}