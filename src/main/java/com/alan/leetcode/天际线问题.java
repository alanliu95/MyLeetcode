package com.alan.leetcode;

import java.util.*;

public class 天际线问题 {
    // 扫描线法 java实现
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] build : buildings) {
            if (!map.containsKey(build[0]))
                map.put(build[0], new ArrayList<Integer>());
            map.get(build[0]).add(-build[2]);

            if (!map.containsKey(build[1]))
                map.put(build[1], new ArrayList<Integer>());
            map.get(build[1]).add(build[2]);
        }
        Map<Integer, Integer> heights = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] last = {0, 0};
        for (int key : map.keySet()) {
            List<Integer> yArrays = map.get(key);
            Collections.sort(yArrays);
            for (int y : yArrays) {
                if (y < 0) {
                    int val = heights.getOrDefault(-y, 0);
                    heights.put(-y, val + 1);
                } else {
                    int val = heights.getOrDefault(y, 0);
                    if (val == 1) {
                        heights.remove(y);
                    } else {
                        heights.put(y, val - 1);
                    }
                }
            }
            Integer maxHeight = 0;
            if (!heights.isEmpty())
                maxHeight = heights.keySet().iterator().next();
            if (last[1] != maxHeight) {
                last[0] = key;
                last[1] = maxHeight;
                res.add(Arrays.asList(key, maxHeight));
            }
        }
        return res;
    }
}

