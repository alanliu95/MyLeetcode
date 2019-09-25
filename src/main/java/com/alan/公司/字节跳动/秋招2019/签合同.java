package com.alan.公司.字节跳动.秋招2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 签合同 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> cntList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            ArrayList<Integer> line = new ArrayList<>();
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            if (strs.length > 1) {
                cntList.add(strs.length - 1);
                for (int i = 1; i < strs.length; i++) {
                    line.add(Integer.parseInt(strs[i]));
                }
            } else {
                cntList.add(0);
            }
            list.add(line);


        }
        System.out.println(cntList);
        System.out.println(list);
        int head = 0;
        for (int i = 0; i < cntList.size(); i++) {
            if (cntList.get(i) == 0) {
                head = i + 1;
                break;
            }

        }
        List<Integer> queue = new ArrayList<>();
        queue.add(head);
        boolean[] isUsed = new boolean[cntList.size()];
        while (queue.size() < cntList.size()) {
            for (int i = 0; i < cntList.size(); i++) {

                if (i + 1 == head || isUsed[i])
                    continue;
                List<Integer> curr = list.get(i);
                if (queue.containsAll(curr)) {
                    queue.add(i + 1);
                    isUsed[i] = true;
                }
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i) + " ");
        }
    }
}
