package com.ibeidan.test;

import org.junit.Test;

/**
 * @author lee
 * DATE 2021/2/28 21:27
 */
public class DiTuiTest {

    public int digui(int n){
        System.out.println("digui n = "+n);
        int t1,t2;

        if (n == 1 || n== 2) {
            return 1;
        }else {
            t1 = digui(n-1);
            t2 = digui(n -2);
            System.out.println("digui t1 = "+ t1 +" t2=="+t2);
            return t1 + t2;
        }
    }

    @Test
    public void test(){
       int r = digui(5);
        System.out.println(r);
    }


    public long jiecheng(int n ){
        System.out.println(n);
        if (n < 1){
            return 1;
        }else {
            long t = jiecheng(n-1);
            System.out.println("n="+n+",t=" +t);
            return  n * t;
        }
    }

    @Test
    public void testJie(){
       long r = jiecheng(6);
        System.out.println(r);
    }

}
