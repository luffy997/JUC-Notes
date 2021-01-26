package com.dev.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 7.一个静态的同步方法 一个普通的同步方法 一个对象 打电话 发短信
 * 8.一个静态的同步方法 一个普通的同步方法 两个对象  打电话 发短信
 *
 * @author 路飞
 * @create 2021/1/18
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();



        new Thread(() -> {
            phone2.call();
        }, "B").start();



        new Thread(() -> {
            phone1.sendMes();
        }, "A").start();


    }
}

class Phone4 {
    public static synchronized void sendMes() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}