package com.alan.leetcode.多线程;

import java.util.concurrent.Semaphore;

public class 打印零与奇偶数 {
}

//
//class ZeroEvenOdd {
//    private int n;
//    private volatile int curr = 0;
//    private int evenCnt=0;
//    private int oddCnt=0;
//    private Semaphore sem1 = new Semaphore(1);
//    private Semaphore sem2 = new Semaphore(0);
//    private Semaphore sem3 = new Semaphore(0);
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//        if(n%2==0){
//            oddCnt=(evenCnt=n/2);
//        }else{
//            evenCnt=n/2;
//            oddCnt=n/2+1;
//        }
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 0; i <n; i++) {
//            sem1.acquire();
//            System.out.println(0);
//            printNumber.accept(0);
//            curr++;
//            if(curr%2==0)
//                sem2.release();
//            else
//                sem3.release();
//        }
//    }
//
//
//    public  void even(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 0; i < evenCnt; i++) {
//            sem2.acquire();
//            printNumber.accept(curr);
//            System.out.println(curr);
//            sem1.release();
//        }
//    }
//
//    public  void odd(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 0; i < oddCnt; i++) {
//            sem3.acquire();
//            printNumber.accept(curr);
//            System.out.println(curr);
//            sem1.release();
//        }
//    }
//}