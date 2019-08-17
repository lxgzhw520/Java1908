package com.lxgzhw.VarArgs;

/*
可变参数:
    1.接收任意长度的参数
    2.语法,在类型的后面加上...
    3.本质是一个数组
 */
public class Demo01 {
    public static void main(String[] args) {
        //测试
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
        System.out.println(add(1, 2, 3, 4));
        System.out.println(add(1, 2, 3, 4, 5));
    }

    //定义一个方法,实现任意个数的整数相加
    static int add(int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
}
