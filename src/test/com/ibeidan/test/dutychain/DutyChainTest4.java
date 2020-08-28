package com.ibeidan.test.dutychain;


import com.alibaba.fastjson.JSON;
import com.ibeidan.web.dutychain4.*;
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


    @Test
    public void testChain5() throws Exception{
        Long sys = System.currentTimeMillis();
        Request request = new Request(1L,"131");
        Response response = new Response();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilters(FilterFactory.getFilters("com.ibeidan.web.dutychain4","a"));
        //filterChain.addFilter(new Rule1()).addFilter(new Rule2());
        filterChain.doFilter(request,response,filterChain);
        System.out.println(response.getUser().getUserResultList());
        System.out.println(response.getCourier().getCourierResultList());
        System.out.println(JSON.toJSONString(response));
        System.out.println(System.currentTimeMillis()-sys);
    }

    @Test
    public void testChain6() throws Exception{
        Long sys = System.currentTimeMillis();
        Request request = new Request(1L,"131");
        Response response = new Response();
        FilterChain filterChain = new FilterChain();
      //  filterChain.addFilters(FilterFactory.getFilters("com.ibeidan.web.dutychain4","a"));
        filterChain.addFilter(new Rule1()).addFilter(new Rule2());
        filterChain.doFilter(request,response,filterChain);
        System.out.println(response.getUser().getUserResultList());
        System.out.println(response.getCourier().getCourierResultList());
        System.out.println(JSON.toJSONString(response));
        System.out.println(System.currentTimeMillis()-sys);
    }


}
