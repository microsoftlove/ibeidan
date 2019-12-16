package com.ibeidan.web.dutychain3;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author lee
 * @DATE 2019/12/16 15:36
 */
public class FilterFactory {


    public static List<Filter> getFilters(String packages) throws Exception{
        List<Filter> filterList = new ArrayList<>();
        Reflections reflections = new Reflections(packages);
        Set<Class<?>> filters = reflections.getTypesAnnotatedWith(EnableFilter.class);
        for (Class filter : filters){
           filterList.add( (Filter)filter.newInstance());
        }
        return filterList;
    }
}
