package com.ibeidan.web.dutychain4;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author lee
 * DATE 2019/12/16 15:36
 */
public class FilterFactory {


    public static List<Filter> getFilters(String packages,String type) throws Exception{
        List<Filter> filterList = new ArrayList<>();
        Reflections reflections = new Reflections(packages);
        Set<Class<?>> filters = reflections.getTypesAnnotatedWith(EnableFilter.class);
        for (Class filter : filters){
            EnableFilter enableFilter= (EnableFilter) filter.getAnnotation(EnableFilter.class);
            String v= enableFilter.value();
            if (v.equals(type)){
                filterList.add( (Filter)filter.newInstance());
            }

        }
        return filterList;
    }



}
