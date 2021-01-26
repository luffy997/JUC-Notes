package com.dev.function;

import java.util.function.Function;

/**
 * Function 函数型接口，有一个输入参数，一个输出
 * 只要是函数型接口 可以用lambda表达简化
 * @author 路飞
 * @create 2021/1/20
 */
public class Demo1 {
    public static void main(String[] args) {

//        Function function =  new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };



        //使用lambda简化
        Function function = (str)->{return str;};
        System.out.println(function.apply("1223"));

    }
}
