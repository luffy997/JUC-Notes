package com.dev.review;

/**
 *创建线程的方法1：继承Thread类，重写run()方法，调用start()
 * @author 路飞
 * @create 2021/1/23
 */
public class Demo01 extends Thread{
    @Override
    public void run() {
        //run方法 线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在写博客----->"+i);
        }
    }

    public static void main(String[] args) {
        //main 主线程
        //创建一个线程对象，调用start(),开启线程
        Demo01 demo01 = new Demo01();
        //demo01.run();  //只有主线程一条执行路径
        demo01.start(); //多线程，主线程和子线程交替执行

        try {
            Thread.sleep(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        


        for (int i = 0; i < 20; i++) {
            System.out.println("我在复习多线程--->"+i);
        }
    }
}
