package com.zhurong.db.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class MerchUser implements Serializable {
    private String id;//表数据主键

    private String merchUserId;//用户ID

    private String merchId;//商户号，图书馆商户以L开头，出版社商户以P开头

    private String merchUserName;//用户姓名

    private String accountPwd;//登录密码密文

    private String nickName;//用户昵称

    private Date userBirthday;//用户出生日期

    private String birthplace;//出生地

    private String gender;//性别，1男，2女，3未知

    private String merchUserEmail;//商户用户邮箱

    private String merchUserEmailAuth;//商户用户邮箱认证状态 0：未认证 1：已认证

    private String allowEmailLogin;//是否允许使用邮箱登录0：不允许，1：允许

    private String merchUserMobile;//商户用户手机号码

    private String merchUserMobileAuth;//商户用户手机号码认证状态 0：未认证 1：已认证

    private String allowMobileLogin;//是否允许使用手机号登录0：不允许，1：允许

    private String accountStatus;//账户状态，0 未激活，1 已激活，2 已失效

    private String roleCode;//商户用户角色

    private String isFirstLogin;//是否为首次登录，0 首次，1 非首次

    private Date lastLoginTime;//最后登录时间

    private Integer lastFailTimes;//登录失败次数，默认为0，登录失败一次增加1，登录成功后重置为0

    private String resetPwdFlag;//密码设置标识  0：未设置密码  1：已设置完密码

    private String idFrontFacePicPath;//身份证正面

    private String idBackFacePicPath;//背面

    private String idAuthFlag;//身份证是否经过认证，0：未认证 1：已认证

    private String isVip;//是否为VIP，0 是，1否

    private String creator;//创建者

    private Date createTime;//创建时间

    private String updater;//修改者

    private Date modifyTime;//修改时间

    private String remark;//备注

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchUserId() {
        return merchUserId;
    }

    public void setMerchUserId(String merchUserId) {
        this.merchUserId = merchUserId;
    }

    public String getMerchId() {
        return merchId;
    }

    public void setMerchId(String merchId) {
        this.merchId = merchId;
    }

    public String getMerchUserName() {
        return merchUserName;
    }

    public void setMerchUserName(String merchUserName) {
        this.merchUserName = merchUserName;
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMerchUserEmail() {
        return merchUserEmail;
    }

    public void setMerchUserEmail(String merchUserEmail) {
        this.merchUserEmail = merchUserEmail;
    }

    public String getMerchUserEmailAuth() {
        return merchUserEmailAuth;
    }

    public void setMerchUserEmailAuth(String merchUserEmailAuth) {
        this.merchUserEmailAuth = merchUserEmailAuth;
    }

    public String getAllowEmailLogin() {
        return allowEmailLogin;
    }

    public void setAllowEmailLogin(String allowEmailLogin) {
        this.allowEmailLogin = allowEmailLogin;
    }

    public String getMerchUserMobile() {
        return merchUserMobile;
    }

    public void setMerchUserMobile(String merchUserMobile) {
        this.merchUserMobile = merchUserMobile;
    }

    public String getMerchUserMobileAuth() {
        return merchUserMobileAuth;
    }

    public void setMerchUserMobileAuth(String merchUserMobileAuth) {
        this.merchUserMobileAuth = merchUserMobileAuth;
    }

    public String getAllowMobileLogin() {
        return allowMobileLogin;
    }

    public void setAllowMobileLogin(String allowMobileLogin) {
        this.allowMobileLogin = allowMobileLogin;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(String isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLastFailTimes() {
        return lastFailTimes;
    }

    public void setLastFailTimes(Integer lastFailTimes) {
        this.lastFailTimes = lastFailTimes;
    }

    public String getResetPwdFlag() {
        return resetPwdFlag;
    }

    public void setResetPwdFlag(String resetPwdFlag) {
        this.resetPwdFlag = resetPwdFlag;
    }

    public String getIdFrontFacePicPath() {
        return idFrontFacePicPath;
    }

    public void setIdFrontFacePicPath(String idFrontFacePicPath) {
        this.idFrontFacePicPath = idFrontFacePicPath;
    }

    public String getIdBackFacePicPath() {
        return idBackFacePicPath;
    }

    public void setIdBackFacePicPath(String idBackFacePicPath) {
        this.idBackFacePicPath = idBackFacePicPath;
    }

    public String getIdAuthFlag() {
        return idAuthFlag;
    }

    public void setIdAuthFlag(String idAuthFlag) {
        this.idAuthFlag = idAuthFlag;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        this.updater = updater;
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
        this.remark = remark;
    }

    private MerchUser(Builder b) {
        id = b.id;
        merchUserId = b.merchUserId;
        merchId = b.merchId;
        merchUserName = b.merchUserName;
        accountPwd = b.accountPwd;
        nickName = b.nickName;
        userBirthday = b.userBirthday;
        birthplace = b.birthplace;
        gender = b.gender;
        merchUserEmail = b.merchUserEmail;
        merchUserEmailAuth = b.merchUserEmailAuth;
        allowEmailLogin = b.allowEmailLogin;
        merchUserMobile = b.merchUserMobile;
        merchUserMobileAuth = b.merchUserMobileAuth;
        allowMobileLogin = b.allowMobileLogin;
        accountStatus = b.accountStatus;
        roleCode = b.roleCode;
        isFirstLogin = b.isFirstLogin;
        lastLoginTime = b.lastLoginTime;
        lastFailTimes = b.lastFailTimes;
        resetPwdFlag = b.resetPwdFlag;
        idFrontFacePicPath = b.idFrontFacePicPath;
        idBackFacePicPath = b.idBackFacePicPath;
        idAuthFlag = b.idAuthFlag;
        isVip = b.isVip;
        creator = b.creator;
        createTime = b.createTime;
        updater = b.updater;
        modifyTime = b.modifyTime;
        remark = b.remark;
    }

    public MerchUser() {
        super();
    }

    public static class Builder {
        private String id;//表数据主键

        private String merchUserId;//用户ID

        private String merchId;//商户号，图书馆商户以L开头，出版社商户以P开头

        private String merchUserName;//用户姓名

        private String accountPwd;//登录密码密文

        private String nickName;//用户昵称

        private Date userBirthday;//用户出生日期

        private String birthplace;//出生地

        private String gender;//性别，1男，2女，3未知

        private String merchUserEmail;//商户用户邮箱

        private String merchUserEmailAuth;//商户用户邮箱认证状态 0：未认证 1：已认证

        private String allowEmailLogin;//是否允许使用邮箱登录0：不允许，1：允许

        private String merchUserMobile;//商户用户手机号码

        private String merchUserMobileAuth;//商户用户手机号码认证状态 0：未认证 1：已认证

        private String allowMobileLogin;//是否允许使用手机号登录0：不允许，1：允许

        private String accountStatus;//账户状态，0 未激活，1 已激活，2 已失效

        private String roleCode;//商户用户角色

        private String isFirstLogin;//是否为首次登录，0 首次，1 非首次

        private Date lastLoginTime;//最后登录时间

        private Integer lastFailTimes;//登录失败次数，默认为0，登录失败一次增加1，登录成功后重置为0

        private String resetPwdFlag;//密码设置标识  0：未设置密码  1：已设置完密码

        private String idFrontFacePicPath;//身份证正面

        private String idBackFacePicPath;//背面

        private String idAuthFlag;//身份证是否经过认证，0：未认证 1：已认证

        private String isVip;//是否为VIP，0 是，1否

        private String creator;//创建者

        private Date createTime;//创建时间

        private String updater;//修改者

        private Date modifyTime;//修改时间

        private String remark;//备注

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder merchUserId(String merchUserId) {
            this.merchUserId = merchUserId;
            return this;
        }

        public Builder merchId(String merchId) {
            this.merchId = merchId;
            return this;
        }

        public Builder merchUserName(String merchUserName) {
            this.merchUserName = merchUserName;
            return this;
        }

        public Builder accountPwd(String accountPwd) {
            this.accountPwd = accountPwd;
            return this;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder userBirthday(Date userBirthday) {
            this.userBirthday = userBirthday;
            return this;
        }

        public Builder birthplace(String birthplace) {
            this.birthplace = birthplace;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder merchUserEmail(String merchUserEmail) {
            this.merchUserEmail = merchUserEmail;
            return this;
        }

        public Builder merchUserEmailAuth(String merchUserEmailAuth) {
            this.merchUserEmailAuth = merchUserEmailAuth;
            return this;
        }

        public Builder allowEmailLogin(String allowEmailLogin) {
            this.allowEmailLogin = allowEmailLogin;
            return this;
        }

        public Builder merchUserMobile(String merchUserMobile) {
            this.merchUserMobile = merchUserMobile;
            return this;
        }

        public Builder merchUserMobileAuth(String merchUserMobileAuth) {
            this.merchUserMobileAuth = merchUserMobileAuth;
            return this;
        }

        public Builder allowMobileLogin(String allowMobileLogin) {
            this.allowMobileLogin = allowMobileLogin;
            return this;
        }

        public Builder accountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
            return this;
        }

        public Builder roleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        public Builder isFirstLogin(String isFirstLogin) {
            this.isFirstLogin = isFirstLogin;
            return this;
        }

        public Builder lastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
            return this;
        }

        public Builder lastFailTimes(Integer lastFailTimes) {
            this.lastFailTimes = lastFailTimes;
            return this;
        }

        public Builder resetPwdFlag(String resetPwdFlag) {
            this.resetPwdFlag = resetPwdFlag;
            return this;
        }

        public Builder idFrontFacePicPath(String idFrontFacePicPath) {
            this.idFrontFacePicPath = idFrontFacePicPath;
            return this;
        }

        public Builder idBackFacePicPath(String idBackFacePicPath) {
            this.idBackFacePicPath = idBackFacePicPath;
            return this;
        }

        public Builder idAuthFlag(String idAuthFlag) {
            this.idAuthFlag = idAuthFlag;
            return this;
        }

        public Builder isVip(String isVip) {
            this.isVip = isVip;
            return this;
        }

        public Builder creator(String creator) {
            this.creator = creator;
            return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder updater(String updater) {
            this.updater = updater;
            return this;
        }

        public Builder modifyTime(Date modifyTime) {
            this.modifyTime = modifyTime;
            return this;
        }

        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public MerchUser build() {
            return new MerchUser(this);
        }
    }
}