package com.lxgzhw.FightTheLandLord;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        //斗地主,需要扑克集合和扑克索引集合
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        Demo demo = new Demo(poker, pokerIndex);
        //准备牌
        demo.prepare();
        //打印牌
        demo.printPoker();
    }
}
