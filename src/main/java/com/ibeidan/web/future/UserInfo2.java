package com.ibeidan.web.future;

/**
 * @author lee
 * @ date 2019/12/24 11:36
 */
public class UserInfo2 {
    private String userName;

    private String passWord;

    public UserInfo2() {
    }

    public UserInfo2(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
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


    @Override
    public String toString() {
        return "UserInfo2{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
