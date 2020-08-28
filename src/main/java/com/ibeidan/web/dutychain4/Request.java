package com.ibeidan.web.dutychain4;

/**
 * @author lee
 * @DATE 2020/8/11 12:50
 */
public class Request {

    private Long userId ;

    private String mobile;

    public Request(Long userId, String mobile) {
        this.userId = userId;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Request{" +
                "userId=" + userId +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
