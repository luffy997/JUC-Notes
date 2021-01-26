package com.dev.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 测试HashSet
 *
 * @author 路飞
 * @create 2021/1/18
 */
//java.util.ConcurrentModificationException
public class SetTest {
    public static void main(String[] args) {
        //Set<String> set = new HashSet<>();
        //HashSet 底层就是HashMap
        /**
         * 解决方案：
         * 1.Collections.synchronizedSet(new HashSet<>());
         * 2.new CopyOnWriteArraySet<>();
         */
//         Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }).start();
        }
    }
}
