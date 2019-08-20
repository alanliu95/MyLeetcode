package com.alan.设计模式;

public class Singleton1 {
    private Singleton1(){}
    public static Singleton1 instance=null;
    //public static Object lock=new Object(); //可以直接使用已经存在的Class对象的锁 Singleton1.class
    public static Singleton1 getInstance(){
        if(instance==null){
            synchronized (Singleton1.class){
                if(instance==null){
                    instance= new Singleton1();
                    return instance;
                }
            }
        }
        //两种情况下，会运行到这里，1.变量instance早已完成初始化（第一个if 不成立），
        // 2.进入if语句，其他线程已经获取锁实现初始化，第二个if不成立
        return instance;
    }
}

class Singleton2 {
    private Singleton2(){}
    //该类在被加载JVM时，完成初始化
    public static Singleton2 instance=new Singleton2();
    public static Singleton2 getInstance(){
        return instance;
    }
}

class Singleton3 {
    private Singleton3(){}
    //内部类只有被调用时，才被jvm加载
    private static class Nested{
        private static Singleton3 instance=new Singleton3();
    }
    //被调用时，触发jvm 加载内部类
    public static Singleton3 getInstance(){
        return Nested.instance;
    }
}