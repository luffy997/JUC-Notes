package com.dev.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 路飞
 * @create 2021/1/17
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        //并发多个线程 操作同一个资源
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "C").start();
    }
}

//lock三部曲
//1 new ReentrantLock();
//2 Lock.lock(); 加锁
//3 finally=> lock.unlock(); 解锁
class Ticket2 {
    private Integer tikcketNums = 50;

    Lock lock = new ReentrantLock();


    public void saleTicket() {
        lock.lock(); //加锁
        try {
            if (tikcketNums > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (tikcketNums--) + "还剩" + tikcketNums);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //解锁
        }
    }
}

