package com.dev.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3.增加一个普通方法 该方法不受同步锁限制 会先执行
 * 4.两个对象 两个同步方法
 *
 * @author 路飞
 * @create 2021/1/18
 */
public class Test2 {
    public static void main(String[] args) {
        //两个对象，两把锁，那就按时间先后执行
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(() -> {
            phone1.sendMes();
        }, "A").start();

        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//
//        new Thread(() -> {
//            phone2.call();
//        }, "B").start();


        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}

class Phone2 {
    public synchronized void sendMes() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"发短信");
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() +"打电话");
    }

    //一个不加锁的同步方法
    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + "=====>hello");
    }
}