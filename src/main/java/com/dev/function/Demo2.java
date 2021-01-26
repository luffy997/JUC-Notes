package com.dev.function;

import java.util.function.Predicate;

/**
 * 断定型接口：有一个输入参数，返回值只能是一个 boolean
 * @author 路飞
 * @create 2021/1/20
 */
public class Demo2 {
    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };

         Predicate<String> predicate = (str)->{return str.isEmpty();};
        System.out.println(predicate.test("a"));

    }
}
