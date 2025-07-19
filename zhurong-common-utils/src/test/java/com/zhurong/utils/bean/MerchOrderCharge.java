/**
 * @Title: MerchOrderCharge.java
 * @Package: com.zhurong.utils.mapbeanconvert
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.bean;

/**
 * @description:
 * @author LZG
 * @date 2018/8/27
 */
public class MerchOrderCharge {

    private static final long serialVersionUID = 7689251293603813547L;

    // 商户支付订单号，注意不同的支付通道对订单号会有不同的要求，
    private String order_no;

    // 支付类型: 支付使用的第三方支付渠道。取值范围见4.1。
    private String channel;

    // 三位ISO货币代码，目前仅支持人民币cny。
    private String currency;

    // 订单总金额, 单位：分
    private int amount;

    // 商品的标题，该参数最长为 32，汉字最长为16
    private String subject;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "MerchOrderCharge [order_no=" + order_no + ", channel=" + channel + ", currency=" + currency + ", amount=" + amount + ", subject=" + subject + "]";
    }
}