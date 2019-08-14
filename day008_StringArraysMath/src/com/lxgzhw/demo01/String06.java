package com.lxgzhw.demo01;

public class String06 {
    public static void main(String[] args) {
        //转换为字符数组
        char[] chars = "Hello".toCharArray();
        //转换为字节数组
        byte[] bytes = "Hello".getBytes();
        //替换字符串
        String replace = "Hello World!".replace("World", "Java");

        //打印测试
        System.out.println(chars);
        System.out.println(bytes);
        System.out.println(replace);
    }
}
