package com.dev.single;

import java.lang.reflect.Constructor;

/**
 * enum？ 本身也是一个类
 * @author 路飞
 * @create 2021/1/22
 */
public enum  EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
class Test{
    public static void main(String[] args) throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        //Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        //	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
        //有参构造 并非无参!!!!!!!!!!!
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();
        //正常 throw new IllegalArgumentException("Cannot reflectively create enum objects");
        //java.lang.NoSuchMethodException: com.dev.single.EnumSingle.<init>()
        System.out.println(instance1);
        System.out.println(instance2);
    }
}