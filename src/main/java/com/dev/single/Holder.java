package com.dev.single;

/**
 * 静态内部类实现
 * @author 路飞
 * @create 2021/1/22
 */
public class Holder {

    private Holder(){

    }

    private static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }


}
