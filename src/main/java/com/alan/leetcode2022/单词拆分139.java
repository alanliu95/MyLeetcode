package com.alan.leetcode2022;

import java.util.*;

public class 单词拆分139 {
    // BFS --Breadth First Search
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[s.length()];
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int end = start + 1; end <= s.length(); end++) {
                if (set.contains(s.substring(start, end)) && !visited[end-1]) {
                    if (end == s.length())
                        return true;
                    q.add(end);
                    visited[end-1] = true;
                }
            }
        }
        return false;
    }
}
