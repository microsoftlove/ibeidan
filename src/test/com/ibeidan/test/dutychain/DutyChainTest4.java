package com.ibeidan.test.dutychain;


import com.ibeidan.web.dutychain4.Alarm;
import com.ibeidan.web.dutychain4.FilterChain;
import com.ibeidan.web.dutychain4.FilterFactory;
import org.junit.Test;

/**
 * @author lee 责任链模式测试
 * @DATE 2019/5/21 17:03
 */
public class DutyChainTest4 {




    @Test
    public void testChain4() throws Exception{
        Alarm alarm = new Alarm(1,"B",1);
        FilterChain filterChain = new FilterChain();
        filterChain.addFilters(FilterFactory.getFilters("com.ibeidan.web.dutychain4","b"));
        //filterChain.addFilter(new Rule1()).addFilter(new Rule2());
        filterChain.doFilter(alarm,filterChain);
        System.out.println(alarm.toString());
    }



}
