package com.dev.review;

/**
 * 创建线程的方法2：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
 * @author 路飞
 * @create 2021/1/23
 */
public class Demo02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我还是在写代码---->"+i);
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口实现类的对象
        Demo02 demo02 = new Demo02();
        //创建线程对象，通过线程对象来开启我们的线程，---->代理
        Thread thread = new Thread(demo02);
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我还是在写博客--->"+i);
        }


    }
}
