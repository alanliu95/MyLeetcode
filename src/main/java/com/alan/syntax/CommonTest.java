package com.alan.syntax;

public class CommonTest {
    public static void main(String[] args) {
        //取整测试();
        System.out.println(Integer.MAX_VALUE);
    }

    public static void 取整测试() {
        double i = 3.04;
        System.out.println("向正无穷取整" + Math.ceil(i));
        System.out.println("向负无穷取整" + Math.floor(i));
        System.out.println("四舍五入取整" + Math.round(i));

    }
}
