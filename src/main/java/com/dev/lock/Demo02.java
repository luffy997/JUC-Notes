package com.dev.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用lock实现可重入锁
 * @author 路飞
 * @create 2021/1/22
 */
public class Demo02  {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(()->{
            phone.sms();
        },"a").start();

        new Thread(()->{
            phone.sms();
        },"b").start();
    }
    /**
     * a sms
     * a call
     * b sms
     * b call
     */

}

class Phone2{

    Lock lock = new ReentrantLock();
    public  void sms(){
        lock.lock();  //细节问题  两对锁 lock.lock() lock.unlock() 必须配对
        try {
            System.out.println(Thread.currentThread().getName()+" sms");
            call(); //call 也加了锁
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" call");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
