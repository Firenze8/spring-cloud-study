package com.csii.hystrix.controller;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/26 - 21:16 -- 星期日
 */
public class TestSync {
    public volatile static int a=1;
    public synchronized static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(a++);
            }).start();
        }
    }
}
