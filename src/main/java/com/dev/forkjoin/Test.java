package com.dev.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 测试3种求和方式的性能
 * @author 路飞
 * @create 2021/1/20
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1(); //sum=500000000500000000 花费时间：8366
        //test2(); // sum=500000000500000000 花费时间：8599
        test3(); //sum=500000000500000000 花费时间：238
    }

    //1.直接for循环求
    public static void test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum +=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 花费时间："+(end-start));
    }

    //2.forJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 花费时间："+(end-start));
    }

    //3.Stream并行流操作
    public static void test3(){
        long start = System.currentTimeMillis();
        //Stream 并行流
        Long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0,Long::sum);
        System.out.println(LongStream.range(0L, 10_0000_0000L).count());
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 花费时间："+(end-start));
    }
}
