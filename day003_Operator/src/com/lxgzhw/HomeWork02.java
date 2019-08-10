package com.lxgzhw;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        //录入三个数,按从小到大排序然后输出
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个数:");
        int max = sc.nextInt();
        System.out.println("请输入第二个数:");
        int mid = sc.nextInt();
        System.out.println("请输入第三个数:");
        int min = sc.nextInt();


        //打印测试
        System.out.println("您输入的三个数分别为:" + max + ", " + mid + ", " + min);
        System.out.println("从小到大依次为:");
        //现在有三个数,需要进行升序

        int temp;
        //第一次比较:交换 确保max> mid
        if (max < mid) {
            temp = mid;
            mid = max;
            max = temp;
        }
        //第二次比较: 确保max> min
        if (max < min) {
            temp = min;
            min = max;
            max = temp;
        }
        //第三次比较: 确保mid> min
        if (mid < min) {
            temp = mid;
            mid = min;
            min = temp;
        }
        System.out.print(min + ", ");
        System.out.print(mid + ", ");
        System.out.print(max + ", ");
    }

}
