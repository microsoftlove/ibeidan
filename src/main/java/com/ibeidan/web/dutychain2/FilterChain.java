package com.ibeidan.web.dutychain2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @DATE 2019/12/16 15:11
 */
public class FilterChain {

    private List<Filter> filterList = new ArrayList<>();

    private int index = 0;

    public FilterChain addFilter(Filter filter){
        this.filterList.add(filter);
        return this;
    }


    public void doFilter(Alarm alarm,FilterChain filterChain){
        if (index == filterList.size()){
            return;
        }
        Filter filter = filterList.get(index);
        index ++ ;
        filter.execute(alarm,filterChain);
    }
}
