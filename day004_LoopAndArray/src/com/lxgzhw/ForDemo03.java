package com.lxgzhw;

public class ForDemo03 {
    public static void main(String[] args) {
        //案例:求1到100之间,除了能被3整除的数之外的所有数之和
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("1到100之间,除了能被3整除的数之外的所有数之和为:" + sum);

        //验证
        int sum1 = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0) {
                sum1 += i;
            }
        }
        System.out.println("1到100之间,除了能被3整除的数之外的所有数之和为:" + (5050 - sum1));
    }
}
