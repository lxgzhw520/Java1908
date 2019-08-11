package com.lxgzhw;

public class HomeWork01 {
    public static void main(String[] args) {
        //累加和:9+99+999+....+9999999999
        long sum = 0L;
        long[] arr = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L};

        //计算数组的和
        for (int i = 0; i < arr.length; i++) {
            sum +=  arr[i];
        }
        System.out.println("9+99+999+....+9999999999 = " + sum);
    }
}
