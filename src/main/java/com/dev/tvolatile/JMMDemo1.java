package com.dev.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * Volatile的可见性
 * @author 路飞
 * @create 2021/1/20
 */
public class JMMDemo1 {
    private volatile static int num  = 0;

    //主存中num已经置为10 但线程中未得到信息 陷入死循环
    //加入Volatile 保证可见性
    public static void main(String[] args) {

        new Thread(()->{
            while (num == 0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 10;
        System.out.println("num:"+num);

    }
}
