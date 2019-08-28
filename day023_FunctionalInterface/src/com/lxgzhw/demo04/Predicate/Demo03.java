package com.lxgzhw.demo04.Predicate;

/*
已知公司数据库中存在某人,
该人信息中包含"张大鹏:项目负责人..."

目前项目需求需要发生修改,需要找到该公司的项目负责人或者CEO,
判断该人是否满足需求,如果满足,提取出他的名字
 */

import java.util.function.Predicate;

/*
分析:
    1.或者的关系,用or
    2.判断用Predicate断言
    3.提取用split(":")
 */
public class Demo03 {
    //1.定义接口方法
    static boolean isHim(String info,
                         Predicate<String> isPrincipal,
                         Predicate<String> isCEO) {
        return isCEO.or(isPrincipal).test(info);
    }

    //2.定义测试方法
    public static void main(String[] args) {
        //3.定义信息
        String info = "张大鹏:项目负责人...";
        //4.调用断言方法
        boolean isHim = isHim(info,
                //5.判断是否是负责人
                principal -> {
                    //5.1 判断是否包含"项目负责人"
                    return principal.contains("项目负责人");
                },
                //6.判断是否是CEO
                ceo -> ceo.contains("CEO")
        );
        //7.提取信息,打印结果
        if (isHim) {
            String name = info.split(":")[0];
            System.out.println("我们要找的人就是他.名字叫:" + name);
        }
    }
}
