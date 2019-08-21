package com.alan.剑指offer;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 3, 5, 1, 2};
        //int[] popA=new int[]{4,5,3,2,1};
        System.out.println(new 栈的压入弹出序列().IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack();
        int pushIndex = 0, popIndex = 0;
        stack.push(pushA[pushIndex++]);
        while (pushIndex <= pushA.length) {
            if (popIndex == popA.length) return true;
            if (stack.peek() != popA[popIndex]) {
                if (pushIndex == pushA.length)
                    return false;
                stack.push(pushA[pushIndex++]);
            } else {
                stack.pop();
                popIndex++;
            }

        }
        return stack.isEmpty();

    }
}
