package com.alan.公司.京东;

import java.util.*;

public class 集合 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int aN = scanner.nextInt();
            int bN = scanner.nextInt();
//            int[] a=new int[aN];
//            int[] b=new int[bN];
            List<Integer> result = new ArrayList();
            Set set = new HashSet();
            for (int i = 0; i < aN; i++) {
                int temp = scanner.nextInt();
                result.add(temp);
                set.add(temp);
            }
            for (int i = 0; i < bN; i++) {
                int temp = scanner.nextInt();
                if (!set.contains(temp))
                    result.add(temp);

            }
            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();

        }
    }
}
