package com.alan.syntax;


/**
 * 验证 catch子句 直接return，finally子句是否被执行
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(fun());
    }

    public static int fun() {
        int i = 10;
        try {
            i = i / 0;
            return --i;
        } catch (Exception e) {
            --i;
            return i++; //i++ 被执行后，没有进行return操作，转而执行finally子句
        } finally {
            System.out.println("finally子句");
            --i;
            return i--; //先return，后进行i-- 因为是局部变量已无意义
            //最后不要在 finally子句中使用return
        }
    }
}
