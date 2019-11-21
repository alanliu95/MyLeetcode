package com.alan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 单词搜索II {
//    public List<String> findWords(char[][] board, String[] words) {
//
//    }
//    public boolean find(char[][] board, String word){
//        char[] wordSeq=word.toCharArray();
//        List<Position> startIndexes=new ArrayList<>();
//        int rows=board.length;
//        int cols=board[0].length;
//        for (int i = 0; i <rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if(board[i][j]==wordSeq[0])
//                    startIndexes.add(new Position(i,j));
//            }
//        }
//        if(startIndexes.isEmpty()) return false;
//        for (Position start : startIndexes) {
//            Queue<Position> queue=new LinkedList<>();
//            boolean[][] isUsed=new boolean[rows][cols];
//            isUsed[start.row][start.col]=true;
//            queue.add(start);
//            int curr=0;
//            int level_size=1;
//            while (!queue.isEmpty()){
//                Position position =queue.remove();
//                if(position)
//            }
//
//        }
//    }
//
//    private boolean isLegal(int rows, int cols,int row, int col) {
//        return (row>=0&&row<rows)&&(col>=0&&col<cols);
//    }
}

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
