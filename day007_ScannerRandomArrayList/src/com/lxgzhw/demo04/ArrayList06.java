package com.lxgzhw.demo04;

import java.util.ArrayList;
import java.util.Random;

public class ArrayList06 {
    public static void main(String[] args) {
        //生成20个随机整数,装到集合中,并遍历集合
        Random r = new Random();
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            intList.add(r.nextInt(100));
        }

        //遍历集合
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + "\t");
        }
    }
}
