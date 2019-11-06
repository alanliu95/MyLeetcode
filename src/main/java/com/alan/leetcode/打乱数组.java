package com.alan.leetcode;

import java.util.Random;

public class 打乱数组 {
    static class Solution {
        private int[] array;
        private int[] original;

        Random rand = new Random();

        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        public int[] reset() {
            array = original;
            original = original.clone();
            return original;
        }

        // Fisher-Yates 洗牌算法
        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swapAt(i, randRange(i, array.length));
            }
            return array;
        }
    }
}
