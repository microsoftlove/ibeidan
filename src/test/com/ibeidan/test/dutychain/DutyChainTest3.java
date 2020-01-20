package com.ibeidan.test.dutychain;


import com.ibeidan.web.dutychain3.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author lee 责任链模式测试
 * @DATE 2019/5/21 17:03
 */
public class DutyChainTest3 {




    @Test
    public void testChain3() throws Exception{
        Alarm alarm =new Alarm(1,"AB",1);
        FilterChain filterChain = new FilterChain();
        filterChain.addFilters(FilterFactory.getFilters("com.ibeidan.web.dutychain3"));
        //filterChain.addFilter(new Rule1()).addFilter(new Rule2());
        filterChain.doFilter(alarm,filterChain);
    }



}
