package com.dev.function;

import java.util.function.Supplier;

/**
 * Supplier 供给型接口：没有参数，只有返回
 * @author 路飞
 * @create 2021/1/20
 */
public class Demo4 {
    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 1024;
//            }
//        };

       Supplier<Integer> supplier = ()->{return 1024;};

        System.out.println(supplier.get());
    }
}
