package com.ibeidan.web.network;

import com.ibeidan.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author lee
 * @DATE 2019/7/7 18:02
 */
public class NetWorkInfo {
    private final  static  Logger log = LoggerFactory.getLogger(NetWorkInfo.class);

    public static void main(String[] args){
        Enumeration<NetworkInterface> networkInterfaceEnumeration = null;
        try {
            networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            int i= 0;
            while (networkInterfaceEnumeration.hasMoreElements()) {
                i++;

                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
                log.info("getName获取网络设备名称={}", networkInterface.getName());
                log.info("getDisplayName获取网络设备显示名称={}", networkInterface.getDisplayName());
                log.info("getIndex获取网络接口的索引={}", networkInterface.getIndex());
                log.info("isUp网络设备是否已经开启运行={}", networkInterface.isUp());
                log.info("isLoopBack获取网络设备名称={}", networkInterface.isLoopback());
                log.info("getName获取网络设备名称={}", networkInterface.getName());
                log.info("mtu获取网络设备最大传输单元={}", networkInterface.getMTU());

                log.info("next========={}",i);


            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
