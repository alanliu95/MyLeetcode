package com.alan.syntax.多线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.alan.syntax.多线程.获取所有线程数.getAllThreads;

public class FutureTask测试 {
    public static void main(String[] args) {
        int i = 1;
        FutureTask<Integer> task = new FutureTask<>(() -> {
            while (i >= 1) {
            }
            return 1 + 3;
        });
        //new Thread(task).start();
        try {
            System.out.println(task.get());
            //Thread.sleep(21);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllThreads();
    }
}
