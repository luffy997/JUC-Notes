package com.dev.demo01;

import java.util.concurrent.TimeUnit;

/**
 * @author 路飞
 * @create 2021/1/17
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        //获取CPU核数
        //CPU密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("等待两秒");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("等待两秒");

    }
}
