package com.dev.function;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口：只要输入，无返回值
 * @author 路飞
 * @create 2021/1/20
 */
public class Demo3 {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("aaaa");

    Consumer<String> consumer =(s)->{
            System.out.println(s);
        };
    consumer.accept("aaa");
    }
}
