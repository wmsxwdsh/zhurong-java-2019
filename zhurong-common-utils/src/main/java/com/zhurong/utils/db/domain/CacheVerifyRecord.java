/**   
 * @Title: CacheVerifyRecord.java
 * @Package: com.zhurong.utils.db.domain
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.domain;

import java.util.Date;

/**
 * @description: 银行鉴权流水
 * @author LZG
 * @date 2018/8/27
 */
public class CacheVerifyRecord {

    private String id; //key

    private String merchId; //商户号

    private String orderId; //商户订单号

    private String txnId; //系统单号

    private String outTxnId; //发送三方单号

    private String idType; //证件类型

    private String idNo; //证件号

    private String cardTp; //卡类型

    private String cardNo; //银行卡号

    private String cardName; //银行卡姓名

    private String phoneNum; //预留手机号

    private String bankId; //银行编码

    private String bankName; //银行名称

    private Date receiveTime; //订单接收时间

    private Date completeTime; //订单完成时间

    private Integer takeTime; //鉴权花费时间

    private String tunnelId; //鉴权通道ID

    private String respCode; //响应码

    private String respInfo; //响应信息

    private String orgRespCode; //三方原始响应码

    private String orgRespInfo; //三方原始响应信息

    private String fstFailTunnelId; //第一次失败鉴权通道ID

    private String fstFailRespCode; //第一次失败响应码

    private String fstFailRespInfo; //第一次失败响应信息

    private String serverIp; //机器ip

    private String md5Value; //MD5值

    private String remark; //备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMerchId() {
        return merchId;
    }

    public void setMerchId(String merchId) {
        this.merchId = merchId == null ? null : merchId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId == null ? null : txnId.trim();
    }

    public String getOutTxnId() {
        return outTxnId;
    }

    public void setOutTxnId(String outTxnId) {
        this.outTxnId = outTxnId == null ? null : outTxnId.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getCardTp() {
        return cardTp;
    }

    public void setCardTp(String cardTp) {
        this.cardTp = cardTp == null ? null : cardTp.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhone(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Integer takeTime) {
        this.takeTime = takeTime;
    }

    public String getTunnelId() {
        return tunnelId;
    }

    public void setTunnelId(String tunnelId) {
        this.tunnelId = tunnelId == null ? null : tunnelId.trim();
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode == null ? null : respCode.trim();
    }

    public String getRespInfo() {
        return respInfo;
    }

    public void setRespInfo(String respInfo) {
        this.respInfo = respInfo == null ? null : respInfo.trim();
    }

    public String getOrgRespCode() {
        return orgRespCode;
    }

    public void setOrgRespCode(String orgRespCode) {
        this.orgRespCode = orgRespCode == null ? null : orgRespCode.trim();
    }

    public String getOrgRespInfo() {
        return orgRespInfo;
    }

    public void setOrgRespInfo(String orgRespInfo) {
        this.orgRespInfo = orgRespInfo == null ? null : orgRespInfo.trim();
    }

    public String getFstFailTunnelId() {
        return fstFailTunnelId;
    }

    public void setFstFailTunnelId(String fstFailTunnelId) {
        this.fstFailTunnelId = fstFailTunnelId == null ? null : fstFailTunnelId.trim();
    }

    public String getFstFailRespCode() {
        return fstFailRespCode;
    }

    public void setFstFailRespCode(String fstFailRespCode) {
        this.fstFailRespCode = fstFailRespCode == null ? null : fstFailRespCode.trim();
    }

    public String getFstFailRespInfo() {
        return fstFailRespInfo;
    }

    public void setFstFailRespInfo(String fstFailRespInfo) {
        this.fstFailRespInfo = fstFailRespInfo == null ? null : fstFailRespInfo.trim();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public String getMd5Value() {
        return md5Value;
    }

    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value == null ? null : md5Value.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "CacheVerifyRecord [id=" + id + ", merchId=" + merchId + ", orderId=" + orderId + ", txnId=" + txnId
            + ", outTxnId=" + outTxnId + ", idType=" + idType + ", idNo=" + idNo + ", cardTp=" + cardTp
            + ", cardNo=" + cardNo + ", cardName=" + cardName + ", phoneNum=" + phoneNum + ", bankId=" + bankId
            + ", bankName=" + bankName + ", receiveTime=" + receiveTime + ", completeTime=" + completeTime
            + ", takeTime=" + takeTime + ", tunnelId=" + tunnelId + ", respCode=" + respCode + ", respInfo="
            + respInfo + ", orgRespCode=" + orgRespCode + ", orgRespInfo=" + orgRespInfo + ", fstFailTunnelId="
            + fstFailTunnelId + ", fstFailRespCode=" + fstFailRespCode + ", fstFailRespInfo=" + fstFailRespInfo
            + ", serverIp=" + serverIp + ", md5Value=" + md5Value + ", remark=" + remark + "]";
    }

}