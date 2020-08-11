package com.ibeidan.web.future;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author lee
 * @DATE 2019/12/24 11:38
 */
public class MyRunnable implements Runnable {
    private UserInfo userInfo;

    public MyRunnable(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity result = restTemplate.getForEntity("http://localhost:8088/test",String.class);
            System.out.println(result);
        }
        userInfo.setUserName("libeibei");
        userInfo.setPassWord("****");
    }
}
