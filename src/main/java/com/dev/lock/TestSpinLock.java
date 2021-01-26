package com.dev.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author 路飞
 * @create 2021/1/22
 */
public class TestSpinLock {


    public static void main(String[] args) {

        //底层使用自旋锁 CAS
        SprinLockDemo lock = new SprinLockDemo();

        new Thread(()->{
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.myUnlock();
            }

        },"T1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T2").start();
    }
}
