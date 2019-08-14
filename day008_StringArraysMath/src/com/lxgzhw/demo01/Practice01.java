package com.lxgzhw.demo01;

public class Practice01 {
    public static void main(String[] args) {
        //按照 `[word1#word2#word3]`的格式拼接字符串
        //要拼接的元素为: 1,2,3
        int num1 = 1, num2 = 2, num3 = 3;
        String concat = "[word".concat(String.valueOf(num1))
                .concat("#word")
                .concat(String.valueOf(num2))
                .concat("#word")
                .concat(String.valueOf(num3))
                .concat("]");
        System.out.println(concat);
    }
}
