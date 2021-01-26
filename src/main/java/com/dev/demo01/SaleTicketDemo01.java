package com.dev.demo01;

/**
 * 卖票
 *
 * @author 路飞
 * @create 2021/1/17
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //并发多个线程 操作同一个资源
        Ticket ticket = new Ticket();

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

class Ticket {
    private Integer tikcketNums = 50;

    //加入同步锁
    public synchronized void saleTicket() {
        if (tikcketNums > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (tikcketNums--) + "还剩" + tikcketNums);
        }
    }
}
