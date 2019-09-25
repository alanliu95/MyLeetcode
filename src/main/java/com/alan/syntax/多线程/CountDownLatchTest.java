package com.alan.syntax.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 某个（或者多个）线程先被阻塞，等待其他线程都到达某处后，继续运行。
 * “其他进程”释放信号后，不会被阻塞继续运行
 * countDown() await()
 *不可重复使用
 * 第三个线程阻塞，直到第一个 第二个线程事件发生
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Runnable runnable1 = () -> {
            System.out.println("线程1启动");
            latch.countDown();
        };
        Runnable runnable2 = () -> {
            System.out.println("线程2启动");
            latch.countDown();
        };
        Runnable runnable3 = () -> {
            try {
                latch.await();
                System.out.println("线程3启动");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);

        System.out.println("最先启动线程3");
        t3.start();
        System.out.println("等待1秒");
        Thread.sleep(1000);
        System.out.println("启动线程1 线程2");
        t1.start();
        t2.start();
    }
}
