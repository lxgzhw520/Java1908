package com.lxgzhw.demo04;

public class Math02 {
    public static void main(String[] args) {
        //计算在`-10.8`到`5.9`之间,绝对值小于6且大于2的整数有多少个
        int count = 0;
        //1.循环取值
        for (double i = -10; i < 6; i++) {
            //2.统计个数
            if (Math.abs(i) > 2 && (Math.abs(i) < 6)) {
                count++;
            }
        }
        //3.打印结果
        System.out.println("总共有" + count + "个数.");
    }
}
