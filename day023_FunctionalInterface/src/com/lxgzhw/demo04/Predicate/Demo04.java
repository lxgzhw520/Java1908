package com.lxgzhw.demo04.Predicate;
/*
现在有个项目,急需要有人开发.
经过团队商量,只要不找"皮包公司"就可以,
现在有个叫"理想国真恵玩"的人毛遂自荐,
请写一个java程序,用Predicate断言方法,判断
他是否满足要求.
 */

import java.util.function.Predicate;

/*
分析:
    1.Predicate断言
    2.只要不,即就是非,使用negate否定
 */
public class Demo04 {
    static boolean whether(String name, Predicate<String> isSkin) {
        return isSkin.negate().test(name);
    }

    public static void main(String[] args) {
        String name = "理想国真恵玩";
        boolean whether = whether(name, skin -> skin.equals("皮包公司"));
        if (whether) {
            System.out.println("满足要求.");
        }
    }
}
