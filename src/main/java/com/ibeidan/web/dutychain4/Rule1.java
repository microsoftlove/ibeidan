package com.ibeidan.web.dutychain4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * DATE 2019/12/16 15:13
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

    @Override
    public void execute(Request request, Response response, FilterChain filterChain) {
        //处理用户端验证
        User user = new User();
        List<Result> results = new ArrayList<>();
        Result result = new Result();
        result.setCode(200);
        result.setMsg("user-success");
        results.add(result);
        user.setUserResultList(results);
        response.setUser(user);

        filterChain.doFilter(request,response,filterChain);//下一个执行器

    }
}
