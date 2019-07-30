package com.alan.offer;

public class 矩阵中的路径 {

    public static void main(String[] args) {
        char[] matrix="ABCESFCSADEE".toCharArray();
        System.out.println(new 矩阵中的路径.Solution().hasPath(matrix,3,4,"ABCCED".toCharArray()));
    }
    static class Solution {
        private char[] matrix;
        private boolean[] used;

        private  int rows;
        private  int cols;

        private char[] str;
        private int len;
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
        {
            this.matrix=matrix;
            this.used=new boolean[rows*cols];
            this.rows=rows;
            this.cols=cols;
            this.str=str;
            this.len=str.length;
            int row,col,curr=0;
            for(row=0;row<rows;row++){
                for(col=0;col<cols;col++)
                    if(find(row,col,curr)) return true;
            }
            return false;
        }
        //矩阵  布尔矩阵  当前字符索引 需要字符长度
        public boolean find(int row, int col, int curr){
            //递归终止条件
            //已经完全找出所有字符
            if(curr==len) return true;
            //判断是否数组越界
            if(row<0||row>=rows||col<0||col>=cols) return false;
            int index=row*cols+col;
            //判断是否已被使用
            if(used[index]) return false;
            char ch=matrix[index];
            if(ch==str[curr]){
                curr++;
                used[index]=true;
                if(find(row-1,col,curr)||find(row+1,col,curr)||find(row,col-1,curr)||find(row,col+1,curr))
                    return true;
                curr--;
                used[index]=false;
                return false;
            }
            else
                return false;
        }

    }
}
