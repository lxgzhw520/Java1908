package com.lxgzhw.demo05.Function;

import java.util.function.Function;

/*
数据类型转换接口:Function
    1.方法为apply(T t)
    2.泛型接收两个参数
        2.1 第一个参数是转换前的类型
        2.2 第二个参数是转换后的类型

案例:将字符串转换为整数
 */
public class Demo01 {
    /*
    接口函数:
        1.接收字符串
        2.返回整数
     */
    static int stringToInteger(String s,
                               Function<String, Integer> fun) {
        return fun.apply(s);
    }

    //入口方法
    public static void main(String[] args) {
        //1.定义字符串
        String s = "1222";
        //2.调用方法
        int i = stringToInteger(s, (str) -> Integer.parseInt(str));
        //3.打印
        System.out.println(i);
    }
}
