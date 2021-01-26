package com.dev.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 5.增加两个静态方法 一个对象  发短信 打电话
 * 6.两个对象 两个静态的同步方法 发短信 打电话
 *
 * @author 路飞
 * @create 2021/1/18
 */
public class Test3 {
    public static void main(String[] args) {

        //两个对象的class类模板只有一个，statis锁的是class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();


        new Thread(() -> {
            phone2.call();
        }, "C").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.sendMes();
        }, "B").start();

//        new Thread(() -> {
//            phone1.sendMes();
//        }, "A").start();



        // 捕获
        //无休眠 ABC
        //休眠时间小于4 ABC
        //休眠时间大于4 ACB


    }
}

//唯一的一个class 对象
class Phone3 {

    //静态的同步方法 锁的是 class类模板
    public static synchronized void sendMes() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"发短信");
    }

    public static synchronized void call() {
        System.out.println(Thread.currentThread().getName()+"打电话");
    }
}