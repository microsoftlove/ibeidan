package com.ibeidan.web.dutychain2;

/**
 * @author lee
 * @DATE 2019/12/16 15:13
 */
public class Rule1 implements Filter {
    @Override
    public void execute(Alarm alarm,FilterChain filterChain) {
        if (alarm.getAlarmName().contains("A")){
            System.out.println("执行测试1");
        }
        filterChain.doFilter(alarm,filterChain);
    }
}
