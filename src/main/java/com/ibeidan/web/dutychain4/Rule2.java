package com.ibeidan.web.dutychain4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @DATE 2019/12/16 15:13
 */
@EnableFilter(value = "a")
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

    @Override
    public void execute(Request request, Response response, FilterChain filterChain) {
//处理用户端验证
        Courier user = new Courier();
        List<Result> results = new ArrayList<>();
        Result result = new Result();
        result.setCode(200);
        result.setMsg("courier-success");
        results.add(result);
        user.setCourierResultList(results);
        response.setCourier(user);

        filterChain.doFilter(request,response,filterChain);//下一个执行器
    }
}
