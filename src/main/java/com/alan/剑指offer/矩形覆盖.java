package com.alan.剑指offer;

public class 矩形覆盖 {

    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int pre = 1, curr = 1;
        for (int i = 2; i <= target; i++) {
            int tmp = curr;
            curr = pre + curr;
            pre = tmp;
        }
        return curr;
    }
}
