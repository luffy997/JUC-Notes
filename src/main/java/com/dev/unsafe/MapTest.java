package com.dev.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 测试HashMap
 *
 * @author 路飞
 * @create 2021/1/18
 */
//java.util.ConcurrentModificationException
public class MapTest {
    public static void main(String[] args) {
        //map 
        /**
         * 解决方案
         * 1. Collections.synchronizedMap(new HashMap<>());
         * 2. new ConcurrentHashMap<>();
         */
        //默认等价于什么？ new HashMap(16,0.75);
        // Map<String, Object> map = new HashMap<>();
        // Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
        Map<Object, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }).start();
        }
    }
}
