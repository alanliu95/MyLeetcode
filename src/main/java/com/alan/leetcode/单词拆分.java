package com.alan.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class 单词拆分 {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> dict = new ArrayList<>();
        dict.add("aaaa");
        dict.add("aaa");
        System.out.println(new Solution().wordBreak(s, dict));
    }

    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak_bfs(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (set.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) return true;
                    }

                }
                visited[start] = true;
            }
        }
        return false;
    }

    /**
     * 枚举，会超时
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_dfs(String s, List<String> wordDict) {
        return wordBreak_dfs(s, wordDict, 0);
    }

    public boolean wordBreak_dfs(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak_dfs(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }


    static class Solution {
        String s;
        List<String> wordDict;
        Set<String> wordSet;
        Boolean[] mem;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.s = s;
            this.wordDict = wordDict;
            this.wordSet = new HashSet<>();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (String word : wordDict) {
                min = Math.min(word.length(), min);
                max = Math.max(word.length(), max);
                wordSet.add(word);
            }
            mem = new Boolean[s.length() + 1];
            mem[s.length()] = true;
            return wordBreak_bfs(0, min, max);
        }

        private boolean wordBreak_bfs(int index, int min, int max) {
            if (index == s.length())
                return true;
            boolean flag = false;
            for (int i = min; i <= max; i++) {
                if (index + i <= s.length() && wordSet.contains(s.substring(index, index + i))) {
                    if (mem[index + i] != null) {
                        return mem[index + i];
                    }
                    boolean result = wordBreak_bfs(index + i, min, max);
                    mem[index + i] = result;
                    if (result) {
                        flag = true;
                        break;
                    }
                }

            }
            mem[index] = flag;
            return flag;
        }

    }


}
