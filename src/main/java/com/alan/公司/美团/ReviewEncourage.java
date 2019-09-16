package com.alan.公司.美团;

import java.util.concurrent.Semaphore;

public class ReviewEncourage {
    public static void main(String[] args) throws InterruptedException {
        ReviewEncourage rev = new ReviewEncourage(5);
        PrizePool prizePool = new PrizePool();
        Thread A = new Thread(() -> {
            try {
                rev.bonus(prizePool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                rev.coupon(prizePool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread c = new Thread(() -> {
            try {
                rev.contribution(prizePool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A.start();
        B.start();
        c.start();
        System.out.println("over");
        while (true) ;
    }

    private volatile int n;
    private volatile int cnt = 1;
    private volatile boolean flag = true;
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

    public ReviewEncourage(int n) {
        this.n = n;
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }// 构造函数,n为中奖用户数

    /*
        PrizePool类仅有一个send方法，实现如下：
        public class PrizePool {
            public void send(String input) {
                System.out.print(input);
            }
        }
      */
    public void bonus(PrizePool prizePool) throws InterruptedException {
        while (cnt <= n) {
            if (cnt % 2 == 1) {
                sem1.acquire();
                if (cnt > n) break;
                prizePool.send("A");
                cnt++;
                if (flag) {
                    sem2.release();
                } else {
                    sem3.release();
                }

            }
        }

    }// 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) throws InterruptedException {
        while (cnt <= n) {
            sem2.acquire();
            if (cnt > n) break;
            prizePool.send("B");
            cnt++;
            flag = !flag;
            sem1.release();
        }
    }// 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) throws InterruptedException {
        while (cnt <= n) {
            sem3.acquire();
            if (cnt > n) break;
            prizePool.send("C");
            cnt++;
            flag = !flag;
            sem1.release();
        }
    }// 仅能打印C，表示发放贡献值
}

class PrizePool {
    public void send(String input) {
        System.out.print(input);
    }
}
