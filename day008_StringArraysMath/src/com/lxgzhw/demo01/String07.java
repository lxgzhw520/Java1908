package com.lxgzhw.demo01;

public class String07 {
    public static void main(String[] args) {
        String s = "aaa,bbb,ccc";
        //按照逗号进行切割
        String[] split = s.split(",");
        //打印
        System.out.println(split);
        //遍历
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        System.out.println("-------------------------------");
        //空格分割
        String s1 = "a bb   ccc  ddddd";
        //切割方法实际上接收的是一个正则表达式
        //\\s+表示1个以上空白字符
        String[] s2 = s1.split("\\s+");
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }
}
