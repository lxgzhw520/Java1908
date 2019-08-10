package com.lxgzhw;

        import java.util.Scanner;

public class Operator05 {
    public static void main(String[] args) {
        //比较年龄
        int myAge = 25;
        //判断我的年龄和用户年龄之间的关系
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄:");
        int userAge = sc.nextInt();
        if (myAge > userAge) {
            System.out.println("我的年龄大于您的年龄.");
        } else if (myAge < userAge) {
            System.out.println("我的年龄小于您的年龄.");
        } else {
            System.out.println("我的年龄等于您的年龄.");
        }
    }
}
