package com.dev.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 *手动实现自旋锁
 * 底层使用CAS
 * @author 路飞
 * @create 2021/1/22
 */
public class SprinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> mylock");

        //自旋锁
        while (!atomicReference.compareAndSet(null, thread)) {

        }

    }

    //解锁
    //加锁
    public void myUnlock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }
}