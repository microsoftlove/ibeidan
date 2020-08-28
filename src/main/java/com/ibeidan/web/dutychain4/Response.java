package com.ibeidan.web.dutychain4;

import org.hibernate.validator.constraints.EAN;

import java.util.List;

/**
 * @author lee
 * @DATE 2020/8/11 12:51
 */
public class Response {


    private  User user;

    private  Courier courier;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
