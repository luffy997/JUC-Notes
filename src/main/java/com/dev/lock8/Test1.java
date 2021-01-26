package com.dev.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，关于锁的8个问题
 * 1.两个sync  锁的对象是方法的调用者，按顺序调用 发短信 打电话
 * 2.发短信休眠4S 依旧一样 按顺序调用
 * 核心： 对象！！！
 *
 * @author 路飞
 * @create 2021/1/18
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(() -> {
            phone.sendMes();
        }, "A").start();
        new Thread(() -> {
            phone.call();
        }, "B").start();

        new Thread(() -> {
            phone1.call();
        }, "C").start();
    }
}

class Phone {
    public synchronized void sendMes() {
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
