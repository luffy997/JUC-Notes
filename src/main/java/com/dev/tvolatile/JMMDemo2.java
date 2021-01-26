package com.dev.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile不保证原子性
 * @author 路飞
 * @create 2021/1/20
 */
public class JMMDemo2 {

    //加于不加 volatile  均不能保证原子性
    //解决方法
    /**
     * 1.加sync保证add的同步性
     * 2.加lock 原理和sync一样 不演示
     * 3.AtomicInteger num = new AtomicInteger();
     */
    private volatile static AtomicInteger num = new AtomicInteger();

    public synchronized static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        //理论是num 应该是2万
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){  //只有 main gc
            Thread.yield();
        }

        System.out.println("num:"+num);
    }
}
