package com.alan.leetcode;

import java.util.*;

public class 单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(new 单词拆分().wordBreak_bfs(s, dict));
    }

    public boolean wordBreak_bfs(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == false) {
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


}
