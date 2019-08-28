package com.lxgzhw.demo05.Function;

/*
依赖于Function默认方法andThen,拼接步骤
需求:
    有一个字符串"111",将其转换为整数类型,
    然后乘100,再将结果转换为字符串类型
 */

import java.util.function.Function;

/*
分析:
    1.转换用Function接口
    2.转换两次用andThen
    3.参数是字符串
    4.返回值是字符串
 */
public class Demo02 {
    /*
    接口方法:参数是字符串,返回值是字符串
     */
    static String getNewString(String s,
                               Function<String, Integer> fun1,
                               Function<Integer, String> fun2) {
        return fun1.andThen(fun2).apply(s);
    }

    //入口方法
    public static void main(String[] args) {
        //1.定义字符串
        String s = "111";
        //2.调用方法
        String newString = getNewString(s, str -> {
            int i = Integer.parseInt(str);
            i *= 100;
            return i;
        }, i -> String.valueOf(i));
        //3.打印测试
        System.out.println(newString);
    }
}
