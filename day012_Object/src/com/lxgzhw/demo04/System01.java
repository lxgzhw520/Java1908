package com.lxgzhw.demo04;

public class System01 {
    public static void main(String[] args) {
        //获取当前时间的毫秒值
        System.out.println(System.currentTimeMillis());

        //数组复制方法
        int[] arr = {11, 22, 33};
        int[] dest = new int[3];
        System.arraycopy(arr, 0, dest, 0, 3);
        //遍历数组
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + "\t");
        }
    }
}
