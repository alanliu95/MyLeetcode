package com.alan.offer;
import java.util.*;
public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rlt = new ArrayList<>();
        if (pRoot == null) return rlt;
        Queue<TreeNode> queue = new LinkedList<>();  //bfs队列
        Deque<Integer> deque = new LinkedList<>();  //辅助队列

        queue.add(pRoot);
        int curr_level = 0; //当前层
        int curr_level_ele = 1; //当前层的元素个数
        int curr_cnt = 0;

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
            if (curr_level % 2 == 0) {
                deque.addLast(top.val);  //正向 插入队尾
            } else {
                deque.addFirst(top.val);  //反向 插入队头
            }
            if (++curr_cnt == curr_level_ele) {  ////如果个数达到本层最大值
                List<Integer> temp = new ArrayList<>();
                while (!deque.isEmpty()) {
                    temp.add(deque.pollFirst());
                }
                rlt.add(new ArrayList<>(temp));
                curr_cnt = 0;
                curr_level++;
                curr_level_ele = queue.size();
            }

        }
        return rlt;
    }
}
