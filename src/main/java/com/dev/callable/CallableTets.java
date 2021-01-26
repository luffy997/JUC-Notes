package com.dev.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方法3：创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
 * @author 路飞
 * @create 2021/1/18
 */
public class CallableTets {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread().start(); //怎么启动Callable

        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);

        for (int i = 0; i < 20; i++) {
            new Thread(futureTask,String.valueOf(i)).start();
            System.out.println(Thread.currentThread().getName()+"---->进来了");
        }
        Integer o = (Integer) futureTask.get(); //get 可能会产生阻塞 放到最后
        // 或者使用异步

        System.out.println(o);
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}
