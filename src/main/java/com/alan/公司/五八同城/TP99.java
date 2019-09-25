package com.alan.公司.五八同城;

import java.util.Arrays;
import java.util.Scanner;

public class TP99 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[200];
        for (int i = 0; i < 200; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(nums[197]);
    }
}
