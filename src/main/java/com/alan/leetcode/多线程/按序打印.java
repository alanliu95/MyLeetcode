package com.alan.leetcode.多线程;

import java.util.concurrent.Semaphore;

public class 按序打印 {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable runnable = () -> {
            return;
        };
        Thread a = new Thread(() -> {
            while (true) {
                try {
                    foo.first(runnable);
                } catch (Exception e) {

                }
            }
        }
        );
        Thread b = new Thread(() -> {
            try {
                foo.second(runnable);
            } catch (Exception e) {

            }
        }
        );
        Thread c = new Thread(() -> {
            try {
                foo.third(runnable);
            } catch (Exception e) {

            }
        }
        );
        c.start();
        a.start();
        b.start();
        Thread.sleep(5000);
    }
}

class Foo {
    Semaphore semAB;
    Semaphore semBC;

    public Foo() {
        semAB = new Semaphore(0);
        semBC = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        System.out.println('a');
        printFirst.run();
        semAB.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        semAB.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        System.out.println('b');
        semBC.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semBC.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        System.out.println('c');

    }
}

class Foo1 {
    private volatile int flag = 0;

    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;
            notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (this) {
            // printSecond.run() outputs "second". Do not change or remove this line.
            while (flag != 1)
                wait();
            flag++;
            printSecond.run();
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            // printThird.run() outputs "third". Do not change or remove this line.
            while (flag != 2)
                wait();
            printThird.run();
        }
    }
}