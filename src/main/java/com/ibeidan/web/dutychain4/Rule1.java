package com.ibeidan.web.dutychain4;

/**
 * @author lee
 * @DATE 2019/12/16 15:13
 */
@EnableFilter(value="a")
public class Rule1 implements Filter {
    @Override
    public void execute(Alarm alarm, FilterChain filterChain) {
        if (alarm.getAlarmName().contains("A")){
            //满足返回
            System.out.println("执行测试1");
            alarm.setAlarmAck(1);
            alarm.setAlarmAckMsg("rule1 execute");
            return;
        }else {
            filterChain.doFilter(alarm,filterChain);
        }



    }
}
