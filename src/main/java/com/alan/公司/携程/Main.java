package com.alan.公司.携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int BestMatch(int[] LimitArray, int[][] DegMatrix) {
        return 0;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _LimitArray_size = 0;
        int _DegMatrix_rows = 0;
        int _DegMatrix_cols = 0;
        _DegMatrix_rows = Integer.parseInt(in.nextLine().trim());
        _DegMatrix_cols = Integer.parseInt(in.nextLine().trim());
        _LimitArray_size = _DegMatrix_cols;

        int[] _LimitArray = new int[_LimitArray_size];
        int _LimitArray_item;
        for (int _LimitArray_i = 0; _LimitArray_i < _LimitArray_size; _LimitArray_i++) {
            _LimitArray_item = Integer.parseInt(in.nextLine().trim());
            _LimitArray[_LimitArray_i] = _LimitArray_item;
        }

        int[][] _DegMatrix = new int[_DegMatrix_rows][_DegMatrix_cols];
        for (int _DegMatrix_i = 0; _DegMatrix_i < _DegMatrix_rows; _DegMatrix_i++) {
            for (int _DegMatrix_j = 0; _DegMatrix_j < _DegMatrix_cols; _DegMatrix_j++) {
                _DegMatrix[_DegMatrix_i][_DegMatrix_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = BestMatch(_LimitArray, _DegMatrix);
        System.out.println(res);
    }
}
