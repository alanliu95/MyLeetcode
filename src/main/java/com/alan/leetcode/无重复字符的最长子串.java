package com.alan.leetcode;
import java.util.*;

public class 无重复字符的最长子串 {
    public static void main(String[] args){
        String s="abcabcbb";
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int head,tail,cnt,max;
        head=tail=cnt=max=0;
        while(tail<s.length()){
            char c=s.charAt(tail);
            if(!map.containsKey(c)){
                map.put(c,tail);
                cnt++;
            }
            else{
                max=Math.max(cnt,max);
                //int sameIndex=map.get(c);
                cnt=tail-map.get(c);
                for(;head<map.get(c);head++)
                    map.remove(s.charAt(head));
                map.put(c,tail);
                head++;
            }
            tail++;
        }
        max=Math.max(cnt,max);
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int head = 0;
        int tail = 0;
        int rlt = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        while (tail < arr.length) {
            if (map.containsKey(arr[tail])) {
                int index = map.get(arr[tail]);
                for (int k = head; k <= index; k++) {
                    map.remove(arr[k]);
                }
                head = index + 1;
            }
            map.put(arr[tail], tail);
            rlt = Math.max(rlt, tail - head + 1);
            tail++;
        }
        return rlt;
    }
}
