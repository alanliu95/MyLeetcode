package com.alan.syntax;

public class CommonTest {
    public static void main(String[] args) {
        //取整测试();
        //System.out.println(Integer.MAX_VALUE);
        捕获非受查异常测试();
    }

    public static void 取整测试() {
        double i = 3.04;
        System.out.println("向正无穷取整" + Math.ceil(i));
        System.out.println("向负无穷取整" + Math.floor(i));
        System.out.println("四舍五入取整" + Math.round(i));

    }

    public static void 操作符优先级测试() {
        int i = 6;
        i *= i - 1;
        System.out.println(i);
    }

    /**
     * 捕获异常时，最好指定具体类，不要使用 Exception等父类，不然可能把非异常类也捕获到，导致无法
     * 检测到代码逻辑错误
     */
    public static void 捕获非受查异常测试() {
        try {
            int res = 10 / 0;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("捕获到异常");
        }
    }
}
