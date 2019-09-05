package com.alan.leetcode.多线程;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
    }

    Semaphore sem1;
    Semaphore sem2;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            sem1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sem2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            sem2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sem1.release();
        }
    }
}
