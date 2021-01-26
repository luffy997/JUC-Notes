package com.dev.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 三大方法、7大参数、4种拒绝策略
 *
 * @author 路飞
 * @create 2021/1/19
 */
public class Demo01 {
    public static void main(String[] args) {
        //阿里开发手册规定：不允许使用Executors创建线程池，而是通过ThreadPoolExcutor的方式常见，
        //明确写出创建的线程测的规则，避免资源耗尽的风险
        //工具类Executors创建的三种线程池底层均是ThreadPoolExecutor
        //故手写线程池，只需要通过ThreadPoolExecutor 创建即可
        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一个线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5); //固定线程池大小
        //ExecutorService threadPool = Executors.newCachedThreadPool(); //可伸缩线程池 遇强则强，遇弱则弱

        //使用线程池操作线程
        try {
            for (int i = 0; i < 30; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程池
            threadPool.shutdown();
        }
    }
}
