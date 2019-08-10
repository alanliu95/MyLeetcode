package com.alan.syntax.多线程;

import java.io.IOException;

/**
 * 通过ThreadLocal每个线程都有一个“线程隔离”变量副本，
 * 这个副本作用范围比局部变量大，属于线程级别的全局变量
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws IOException {
        ThreadLocal<Integer> localInt=new ThreadLocal<>();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (localInt.get()==null) localInt.set(0);
                    System.out.println(Thread.currentThread().getName()+" : "+localInt.get());
                    localInt.set(localInt.get()+1);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        Thread t3=new Thread(task);
        t1.start();t2.start();t3.start();
        System.in.read();
    }
}
