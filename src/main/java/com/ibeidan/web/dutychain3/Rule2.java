package com.ibeidan.web.dutychain3;

/**
 * @author lee
 * @DATE 2019/12/16 15:13
 */
@EnableFilter
public class Rule2 implements Filter {
    @Override
    public void execute(Alarm alarm, FilterChain filterChain) {
        if (alarm.getAlarmName().contains("B")){
            System.out.println("执行测试2");
        }
        filterChain.doFilter(alarm,filterChain);
    }
}
