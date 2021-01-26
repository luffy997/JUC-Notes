package com.dev.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式单例
 * 道高一尺魔高一丈
 * @author 路飞
 * @create 2021/1/22
 */
public class LazyMan {


    private static  boolean luffy = false;


    private LazyMan(){
        //第三重检测
        synchronized (LazyMan.class){
            if (luffy == false){
                luffy = true;
            }else {
                throw new RuntimeException("不要试图用反射破坏");
            }
        }
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式 DCL 懒汉式单例
    public  static LazyMan getInstance(){
        //加锁
        if (lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan = new LazyMan(); //不是原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把对象指向在这个空间
                     *
                     * 可能发生指令重排
                     *
                     * 123
                     * 132
                     */

                }

            }
        }
        return lazyMan;
    }

    //单线程下OK
    //并发下
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }
//    }

    //反射
    public static void main(String[] args) throws Exception {
      //  LazyMan instance1= LazyMan.getInstance();

        //破环密钥的私有权限
        Field luffy = LazyMan.class.getDeclaredField("luffy");
        luffy.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        //两个用反射创建实例
//        LazyMan  instance1 = declaredConstructor.newInstance();4
        //使用枚举  自带单例 即可解决！
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;

        luffy.set(instance1,false);

       // LazyMan  instance2 = declaredConstructor.newInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

}
