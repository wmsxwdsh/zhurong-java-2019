/**
 * @Title: BizRequest.java
 * @Package: com.zhurong.utils.mapbeanconvert
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.mapbean;

/**
 * @description:
 * @author LZG
 * @date 2018/8/27
 */
public class BizRequest {

    private static final long serialVersionUID = 6034511914100313418L;

    // 商户应用的唯一身份标识
    private String app_id;

    // 请求使用的编码格式[UTF-8]
    private String charset;

    // 发起支付请求客户端的 ip 地址，格式为 IPV4 整型，如127.0.0.1
    private String client_ip;

    // 设备类型，目前取值只支持[ios, android,pc,h5]
    private String device;

    private MerchOrderCharge charge;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    // the charge
    public MerchOrderCharge getCharge() {
        return charge;
    }

    // charge the charge to set
    public void setCharge(MerchOrderCharge charge) {
        this.charge = charge;
    }

    public String toString() {
        return "BizRequest [app_id=" + app_id + ", charset=" + charset + ", client_ip=" + client_ip + ", device=" + device + ", charge=" + charge + "]";
    }

}