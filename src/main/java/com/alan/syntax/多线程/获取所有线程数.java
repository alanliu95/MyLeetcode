package com.alan.syntax.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 获取所有线程数 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable runnable = () -> {
            while (!Thread.interrupted()) {
            }
        };
        executor.submit(runnable);
        executor.submit(runnable);
        getAllThreads();
        //while (true){}
        executor.shutdown();
        //executor.shutdownNow();
    }

    public static void getAllThreads() {
        //获取所在线程的Thread对象
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread name : " + currentThread.getName());
        //获取所在的线程组
        ThreadGroup group = currentThread.getThreadGroup();
        ThreadGroup rootGroup = group;
        //获取根线程组
        while (group.getParent() != null) {
            rootGroup = group.getParent();
            group = rootGroup;
        }
        //多准备一倍空间，防止后续线程又增加
        int slackSize = rootGroup.activeCount() * 2;
        Thread[] slackThreads = new Thread[slackSize];
        //方法返回实际线程数量
        int actualSize = rootGroup.enumerate(slackThreads);
        Thread[] actualThreads = new Thread[actualSize];
        System.arraycopy(slackThreads, 0, actualThreads, 0, actualSize);
        System.out.println("Threads size is " + actualThreads.length);
        for (Thread thread : actualThreads) {
            System.out.println("Thread name : " + thread.getName());
        }
    }

    public static void getCurrThreadGroupInfo() {
        //获取所在线程的Thread对象
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread name : " + currentThread.getName());
        //获取所在的线程组
        ThreadGroup group = currentThread.getThreadGroup();
        ThreadGroup rootGroup = group;
        //获取根线程组
        while (group.getParent() != null) {
            rootGroup = group.getParent();
            group = rootGroup;
        }
        //多准备一倍空间，防止后续线程又增加
        int slackSize = rootGroup.activeCount() * 2;
        Thread[] slackThreads = new Thread[slackSize];
        //方法返回实际线程数量
        int actualSize = rootGroup.enumerate(slackThreads);
        Thread[] actualThreads = new Thread[actualSize];
        System.arraycopy(slackThreads, 0, actualThreads, 0, actualSize);
        System.out.println("Threads size is " + actualThreads.length);
        for (Thread thread : actualThreads) {
            System.out.println("Thread name : " + thread.getName());
        }
    }

}
