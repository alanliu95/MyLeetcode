package com.alan.leetcode;

import java.util.Iterator;
import java.util.Stack;

public class 基本计算器II {
    public static void main(String[] args) {
        String s = "3+2*2-3";
        System.out.println(new 基本计算器II().calculate(s));
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int val = 0;
        s += "+";
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') continue;
            if (ch >= '0' && ch <= '9') {
                val = val * 10 + (ch - '0');
                continue;
            }


            if (!nums.isEmpty() && !ops.isEmpty()) {
                if ((ops.peek() == '*' || ops.peek() == '/')) {
                    val = (ops.pop() == '*') ? nums.pop() * val : nums.pop() / val;
                }
            }

            if (nums.isEmpty() || ops.isEmpty() || ch == '*' || ch == '/') {
                nums.push(val);
                ops.push(ch);
            } else {
                //nums.pop();
                val = (ops.pop() == '+') ? nums.pop() + val : nums.pop() - val;
                nums.push(val);
                ops.push(ch);
            }
            val = 0;
        }
        return nums.peek();
    }
}


//        for(char ch:chars){
//                if(ch==' ') continue;
//                if(ch>='0'&&ch<='9'){
//                val=val*10+(ch-'0');
//                continue;
//                }
//                if(!nums.isEmpty()&&!ops.isEmpty()&&(ops.peek()=='*'||ops.peek()=='/')){
//                val=(ops.pop()=='*')?nums.pop()*val:nums.pop()/val;
//                }
//
//                if(nums.isEmpty()||ops.isEmpty()||ch=='*'||ch=='/'){
//                nums.push(val);
//                ops.push(ch);
//                }else{
//                val=(ops.pop()=='+')?nums.pop()+val:nums.pop()-val;
//                nums.push(val);
//                }
//                val=0;
//                }

