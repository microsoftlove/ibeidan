package com.ibeidan.web.dutychain4;

/**
 * @author lee
 * @DATE 2019/12/16 15:13
 */
@EnableFilter(value = "b")
public class Rule2 implements Filter {
    @Override
    public void execute(Alarm alarm, FilterChain filterChain) {
        if (alarm.getAlarmName().contains("B")){
            System.out.println("执行测试2");
            alarm.setAlarmAck(2);
            alarm.setAlarmAckMsg("rule2 execute");
            return;
        }else {
            filterChain.doFilter(alarm,filterChain);
        }

    }
}
