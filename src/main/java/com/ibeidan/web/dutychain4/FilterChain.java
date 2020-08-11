package com.ibeidan.web.dutychain4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * DATE 2019/12/16 15:11
 */
public class FilterChain {

    private List<Filter> filterList = new ArrayList<>();

    private int index = 0;

    public FilterChain addFilter(Filter filter){
        this.filterList.add(filter);
        return this;
    }

    public FilterChain addFilters(List<Filter> filters){
        this.filterList.addAll(filters);
        return  this;
    }


    public void doFilter(Alarm alarm, FilterChain filterChain){
        if (index == filterList.size()){
            return;
        }

        /*if (filterList.iterator().hasNext()){
            Filter filter2 = filterList.iterator().next();
            filter2.execute(alarm,filterChain);
        }*/

        Filter filter = filterList.get(index);
        index ++ ;
        filter.execute(alarm,filterChain);
    }
}
