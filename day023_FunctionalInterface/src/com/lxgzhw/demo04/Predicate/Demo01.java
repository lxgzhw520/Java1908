package com.lxgzhw.demo04.Predicate;

import java.util.function.Predicate;

/*
Predicate:断言
该接口包含一个test方法,用来判断
 */
public class Demo01 {
    //接口方法
    static boolean checkString(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }

    //主方法
    public static void main(String[] args) {
        //判断字符串的长度是否大于等于6:密码常用判断
        //1.定义一个字符串
        String password = "aaabbb";
        //2.调用方法检查
        //注意:接口参数不能与已有参数冲突
        boolean b = checkString(password, str -> str.length() >= 6);
        if (b) {
            System.out.println("该密码可用.");
        }
    }
}
