package com.alan.offer;

import java.util.ArrayList;
import java.util.List;

public class 把数组排成最小的数 {
    public class Solution {
        public String PrintMinNumber(int [] numbers) {
            List<Integer> list=new ArrayList<>();
            for(int e:numbers) list.add(e);
            list.sort((i,j)->(i+""+j).compareTo(j+""+i));
            String result="";
            for(int e:list)
                result+=e;
            return result;
        }
    }
}
