package com.lxgzhw;

public class Operator02 {
    public static void main(String[] args) {
        //单独用的时候,++在前在后都一样
        int num = 4;
        num++;//相当于num+=1
        System.out.println(num);

        int num1 = 5;
        ++num;//先执行后加
        System.out.println(num1);
    }
}
