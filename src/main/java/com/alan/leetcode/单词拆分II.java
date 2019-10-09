package com.alan.leetcode;

import java.util.*;

public class 单词拆分II {
    public static void main(String[] args) {
        String str = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(new 单词拆分II().wordBreak(str, list));
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set, 0);
    }


    public List<String> wordBreak(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end);
                for (String ele : list) {
                    res.add(s.substring(start, end) + (ele.equals("") ? "" : " ") + ele);
                }
            }
        }
        map.put(start, res);
        return res;
    }

//    private  List<String> res;
//    public List<String> wordBreak(String s, List<String> wordDict) {
//
//        return wordBreak(s,set,0);
//
//    }
//    public void wordBreak(String s, HashSet<String> wordDict, int start, String buffer){
//        if(start==s.length()){
//            res.add(buffer);
//            return;
//        }
//        for(int end=start;end<=s.length();end++){
//            if(wordDict.contains(s.substring(start,end))){
//                String space=" ";
//                if(buffer.equals("")) space="";
//                wordBreak(s,wordDict,end,buffer+space+s.substring(start,end));
//            }
//        }
//    }


/**
 * 未减枝
 */
//    private  List<String> res;
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        HashSet<String> set=new HashSet<>(wordDict);
//        res=new ArrayList<>();
//        wordBreak(s,set,0,"");
//        return res;
//    }
//    public void wordBreak(String s, HashSet<String> wordDict, int start, String buffer){
//        if(start==s.length()){
//            res.add(buffer);
//            return;
//        }
//        for(int end=start;end<=s.length();end++){
//            if(wordDict.contains(s.substring(start,end))){
//                String space=" ";
//                if(buffer.equals("")) space="";
//                wordBreak(s,wordDict,end,buffer+space+s.substring(start,end));
//            }
//        }
//    }
}
