package com.ibeidan.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_19H = "yyyy-MM-dd HH:mm:ss";
    public  static Date tranferDate(String timeStamp){
       // long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
         Long time = Long.valueOf(timeStamp);
        System.out.println(new Date(time));//打印出你要的时间
       return  new Date(time);
    }
    public static String getLocal(String value,int index){
        String [] _value = value.split("\\|");
        String  result = _value[index];
        System.out.println(result);
        return  result;
    }
    /**
     * 日期字符串转换为毫秒
     *
     * @param dateStr(日期字符串，例如：2015-12-30 22:15:30)
     * @param dateFormat                  (日期格式: yyyy-MM-dd HH:mm:ss)
     * @return
     */
    public static Long getDateStrToLong(String dateStr) {
        if (StringUtils.isBlank(dateStr) )
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_19H);
        Long time = null;
        try {
            Date date = sdf.parse(dateStr);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return time;
    }
    public static Integer getDateStrToSeconds(String dateStr) {
        if (StringUtils.isBlank(dateStr) )
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_19H);
        Integer time = null;
        try {
            Date date = sdf.parse(dateStr);
            time = date.getSeconds();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return time;
    }
   /* public  static  void  main(String args[]){
           tranferDate("1541416599066");
//getLocal("9.056782|117.132868",0);
    }*/
}
