package com.dev.pool;

import java.util.concurrent.*;

/**
 * 手动创建线程池
 *
 * @author 路飞
 * @create 2021/1/19
 */
public class Demo02 {
    public static void main(String[] args) {
// 最大线程到底该如何定义
// 1、CPU 密集型，几核，就是几*2，可以保持CPu的效率最高！
// 2、IO 密集型 > 判断你程序中十分耗IO的线程，
// 程序 15个大型任务 io十分占用资源！

        System.out.println(Runtime.getRuntime().availableProcessors());
        //ThreadPoolExecutor的构造方法
/**
 *      七大参数
 *     public ThreadPoolExecutor(int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,
 *                               ThreadFactory threadFactory) {
 *         this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
 *              threadFactory, defaultHandler);
 *     }
 *
 *
 *     四种拒绝策略
 *       A handler for rejected tasks that throws a
 *       {@code RejectedExecutionException}. 不处理，抛异常
 *      AbortPolicy
 *
 *      A handler for rejected tasks that runs the rejected task
 *      directly in the calling thread of the {@code execute} method,
 *      unless the executor has been shut down, in which case the task
 *      is discarded.  哪来的去哪里！
 *      用于拒绝任务的处理程序，可以直接在方法的调用线程中运行被拒绝的任务*除非执行器已被关闭，否则这种情况下该任务将被丢弃。
 *      CallerRunsPolicy
 *
 *      A handler for rejected tasks that discards the oldest unhandled
 *      request and then retries {@code execute}, unless the executor
 *      is shut down, in which case the task is discarded.
 *      拒绝任务的处理程序，它丢弃<p>最旧</p>的未处理*请求，然后重试，除非执行程序*被关闭，在这种情况下，该任务将被丢弃。
 *      DiscardOldestPolicy
 *
 *      A handler for rejected tasks that silently discards the
 *      rejected task. 直接抛弃
 *      DiscardPolicy
 *
 *
 *
 *
 *
 */
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), //阻塞队列实现
                Executors.defaultThreadFactory(), //默认线程工厂
                new ThreadPoolExecutor.DiscardPolicy() //拒绝策略
        );

        /**
         * 最大承载：max+deque
         * 超过RejectedExecutionException
         */


        try {
            for (int i = 0; i < 100; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
