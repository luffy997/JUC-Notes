package com.dev.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用：CompletableFuture
 * 类似Ajax  Success  error
 * 异步执行
 * 成功回调
 * 失败回调
 * @author 路飞
 * @create 2021/1/20
 */
public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

       //无返回值的runAsync 异步回调
//        CompletableFuture<Void> completableFuture =  CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
//        });
//        System.out.println("111");
//        completableFuture.get(); //获取回调结果

        //有返回值的回调

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            int i = 10 / 0;
            return 1024;
        });

        completableFuture.whenComplete((t,u)->{
            System.out.println("t====>"+t);  //正确的返回结果
            System.out.println("u====>"+u);  //错误的返回结果
        }).exceptionally((e)->{  //错误的返回函数
            System.out.println(e.getMessage());  //CompletionException
            return 233;
        }).get();
    }
}
