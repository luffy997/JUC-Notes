package com.dev.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue四组API的使用
 *
 * @author 路飞
 * @create 2021/1/19
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));
        System.out.println("----------------------");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //java.util.NoSuchElementException
        // System.out.println(blockingQueue.remove());
    }

    /**
     * 有返回值，不抛出异常
     */
    public static void test2() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //超出队列容量 返回false
        //System.out.println(blockingQueue.offer("c"));
        System.out.println("--------------------------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //队列为空 继续poll 返回null
        System.out.println(blockingQueue.poll());
    }

    /**
     * 阻塞等待
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //超出队列容量 阻塞ing
        //blockingQueue.put("a");
        System.out.println("---------------");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //队列已空，继续出队，阻塞ing
        //System.out.println(blockingQueue.take());
    }

    /**
     * 等待，阻塞（超时等待）
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //队列已满，若继续入队，则触发超时等待，2秒后结束程序
        // blockingQueue.offer("d",2, TimeUnit.SECONDS);
        System.out.println("----------------------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //队列已空，若继续出队，则触发超时等待，3秒后结束程序
        //System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));

    }
}
