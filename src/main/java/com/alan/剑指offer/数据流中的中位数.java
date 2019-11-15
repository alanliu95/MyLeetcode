package com.alan.剑指offer;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    int cnt = 0;
    PriorityQueue<Integer> minPq = new PriorityQueue<>();
    PriorityQueue<Integer> maxPq = new PriorityQueue<>(10, (a, b) -> {
        return b.compareTo(a);
    });

    public void Insert(Integer num) {
        cnt++;
        if (cnt % 2 == 0) {
            //打算插入到最小堆
            if (!maxPq.isEmpty() && num < maxPq.peek()) {
                int tmp2 = maxPq.poll();
                minPq.add(tmp2);
                maxPq.add(num);
            } else
                minPq.add(num);
        } else {
            //打算插入到最大堆
            if (!minPq.isEmpty() && num > minPq.peek()) {
                int tmp2 = minPq.poll();
                maxPq.add(tmp2);
                minPq.add(num);
            } else
                maxPq.add(num);
        }
    }

    public Double GetMedian() {
        if (cnt % 2 == 0)
            return (maxPq.peek() + minPq.peek()) / 2.0;

        else return 1.0 * maxPq.peek();
    }
}
