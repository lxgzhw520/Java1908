package com.lxgzhw.demo03.Reference;

/*
静态方法引用
 */
public class Demo02 {
    //定义方法,实现Calc函数式接口
    static int abs(int num, Calc c) {
        return c.abs(num);
    }

    public static void main(String[] args) {
        //使用静态方法引用求绝对值
        int abs = abs(-333, Math::abs);
        System.out.println("-333的绝对值是:" + abs);
    }
}
