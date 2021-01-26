package com.dev.rw;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁） 一次只能被一个线程占用
 * 共享锁（读锁） 多个线程可以同时占用
 * ReadWriteLock
 *
 * @author 路飞
 * @create 2021/1/19x
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {


//          MyCache myCache = new MyCache();
        MyCacheLock myCache = new MyCacheLock();

        //测试写
        for (int i = 1; i <= 10; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.write(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        //测试读取
        for (int i = 1; i < 10; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.read(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}


/**
 * 自定义缓存---不加锁
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void write(String key, Object o) {
        System.out.println(Thread.currentThread().getName() + "写入Key" + key);
        map.put(key, o);
        System.out.println(Thread.currentThread().getName() + "写入完成" + key);
    }

    public void read(String key) {
        System.out.println(Thread.currentThread().getName() + "读取key" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取成功" + key);
    }
}

/**
 * 自定义缓存-->加入读写锁 ReadWriteLock 比lock 粒度更细
 */
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String key, Object o) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入Key" + key);
            map.put(key, o);
            System.out.println(Thread.currentThread().getName() + "写入完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void read(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取key" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取成功" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

