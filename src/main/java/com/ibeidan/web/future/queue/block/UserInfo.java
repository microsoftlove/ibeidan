package com.ibeidan.web.future.queue.block;

/**
 * @author lee
 * DATE 2020/5/6 14:21
 */
public class UserInfo implements Comparable<UserInfo>{

    private Integer id;

    public UserInfo() {
    }

    public UserInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(UserInfo o) {
        if (this.id < o.id){
            return -1;
        }
        if (this.id > o.getId()){
            return 1;
        }
        return 0;
    }
}
