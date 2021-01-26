package com.dev.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 （递归锁）
 * synchronized版
 * @author 路飞
 * @create 2021/1/22
 */
public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sms();
        },"a").start();

        new Thread(()->{
            phone.sms();
        },"b").start();
    }
    /**
     * a sms
     * a call
     * b sms
     * b call
     */

}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+" sms");
        call(); //call 也加了锁
    }

    ReentrantLock lock= new ReentrantLock();

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+" call");
    }
}
