package com.dev.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 比较并操作
 * @author 路飞
 * @create 2021/1/22
 */
public class CASDemo1 {

    //CAS compareAndSet：比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //期望、更新
        //期望达到，就更新
        //CAS CPU的
        System.out.println(atomicInteger.compareAndSet(2020, 2022));
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();

        System.out.println(atomicInteger.compareAndSet(2023, 2022));
        System.out.println(atomicInteger.get());

    }
}
