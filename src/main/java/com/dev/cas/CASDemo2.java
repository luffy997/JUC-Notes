package com.dev.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS 解决ABA问题
 * 类似乐观锁！！
 * @author 路飞
 * @create 2021/1/22
 */
public class CASDemo2 {


    //Integer使用了对象缓存机制,默认范围是-128 ~ 127推荐使用静态工厂方法valueOf获取对象实例,
    // 而不是new ,因为valueOf使用缓存,而new -定会创建新的对象分配新的内存空间;
    //CAS compareAndSet：比较并交换
    public static void main(String[] args) {

        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(1,1);

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1=>"+atomicStampedReference.getStamp());

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(1,2,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("a2=>"+atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(2,1,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("a3=>"+atomicStampedReference.getStamp());
        },"a").start();


        //另外一个线程
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(1,6,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("b2=>"+atomicStampedReference.getStamp());


        },"b").start();
    }

}
