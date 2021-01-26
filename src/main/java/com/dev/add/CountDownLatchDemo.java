package com.dev.add;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 计数器
 *
 * @author 路飞
 * @create 2021/1/18
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //有线程任务的时候，可以使用！
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " Go out"+"当前计数器==>"+countDownLatch.getCount());
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("Close Door");
    }
}
