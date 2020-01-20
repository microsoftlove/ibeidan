package com.ibeidan.web.dutychain3;

import java.io.Serializable;

/**
 * @author lee
 * @DATE 2019/12/16 15:08
 */

public class Alarm implements Serializable {



    public Alarm(Integer id, String alarmName, Integer alarmAck) {
        this.id = id;
        this.alarmName = alarmName;
        this.alarmAck = alarmAck;
    }

    private Integer id;
    private String alarmName;
    private Integer alarmAck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public Integer getAlarmAck() {
        return alarmAck;
    }

    public void setAlarmAck(Integer alarmAck) {
        this.alarmAck = alarmAck;
    }
}
