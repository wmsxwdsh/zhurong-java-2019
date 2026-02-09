package com.zhurong.generator.persistence.mybatis.domain;

import java.util.Date;

/**
* tb_dictionary Domain
* @author LZG Robot
* 2019/06/05
*/
public class TbDictionary {

    /**
     * 表主键
     */
    private String id;

    /**
     * 字典标识
     */
    private String dictNo;

    /**
     * 字典项目编码
     */
    private String itemCode;

    /**
     * 字典项目名称
     */
    private String itemName;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 可视模式
     */
    private String modelFlag;

    /**
     * 父级项目编码
     */
    private String parentItemCode;

    /**
     * 父级字典编码
     */
    private String parentDictNo;

    /**
     * 可视顺序
     */
    private Integer modelOrder;

    /**
     * 审核状态，可从字典100001取值，如：00 已保存，01 待审核，02 审核通过，03 审核拒绝
     */
    private String chkSts;

    /**
     * 操作类型，可从字典100003中取值，如：add 新增，edit 修改，del  删除，chk_pass 审核通过，审核拒绝 chk_deny
     */
    private String operType;

    /**
     * 审核者
     */
    private String auditor;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictNo() {
        return this.dictNo;
    }

    public void setDictNo(String dictNo) {
        this.dictNo = dictNo;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getParentItemCode() {
        return this.parentItemCode;
    }

    public void setParentItemCode(String parentItemCode) {
        this.parentItemCode = parentItemCode;
    }

    public String getParentDictNo() {
        return this.parentDictNo;
    }

    public void setParentDictNo(String parentDictNo) {
        this.parentDictNo = parentDictNo;
    }

    public Integer getModelOrder() {
        return this.modelOrder;
    }

    public void setModelOrder(Integer modelOrder) {
        this.modelOrder = modelOrder;
    }

    public String getChkSts() {
        return this.chkSts;
    }

    public void setChkSts(String chkSts) {
        this.chkSts = chkSts;
    }

    public String getOperType() {
        return this.operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getAuditor() {
        return this.auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditOpinion() {
        return this.auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Date getAuditTime() {
        return this.auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}