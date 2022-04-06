package com.zhurong.jwt.entity;

/**
 *
 * @author LZG
 * @date 2022.04.06
 */
public class User {

    private String userID;
    private String userName;
    private String passWord;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
