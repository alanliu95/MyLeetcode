package com.alan.设计模式;

//双重检验锁模式
//可能会由于虚拟机的优化等导致赋值操作先执行,而构造函数还没完成,
// 导致其他线程访问得到singleton变量不为null,但初始化还未完成,导致程序崩溃。
public class Singleton1 {
    private Singleton1(){}

    //volatile 不可丢
    public static volatile Singleton1 instance = null;

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

//饿汉式 static final field
//这种方式比较常用，但容易产生垃圾对象。
//优点：没有加锁，执行效率会提高。
//缺点：类加载时就初始化，浪费内存。
//它基于 Classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
// 在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法,比如反射）导致类装载，
// 这时候初始化 instance显然没有达到 lazy loading 的效果。
class Singleton2 {
    private Singleton2(){}
    //该类在被加载JVM时，完成初始化
    public static final Singleton2 instance = new Singleton2();
    public static Singleton2 getInstance(){
        return instance;
    }
}


//静态内部类
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