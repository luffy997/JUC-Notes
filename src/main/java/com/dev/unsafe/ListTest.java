package com.dev.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 路飞
 * @create 2021/1/18
 */
//java.util.ConcurrentModificationException
public class ListTest {
    public static void main(String[] args) {
        //测试并发下的ArraysList 不安全 java.util.ConcurrentModificationException
        /**
         * 解决方案：
         * 1.new Vector() 线程安全
         * 2.Collections.synchronizedList(new ArrayList<>());
         * 3.new CopyOnWriteArrayList<>();
         */
        //CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略
        //多线程调用时，list，读取的时候，固定的，写入覆盖
        //再写入的时候避免覆盖，造成数据问题
        //读写分离
        //CopyOnWriteArray 底层是数组复制 Voctor的add底层是sync 效率较低
        List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        // List<Object> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                list.forEach(System.out::println);
            }, String.valueOf(i)).start();
        }
    }
}
