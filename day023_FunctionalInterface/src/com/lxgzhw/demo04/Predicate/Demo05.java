package com.lxgzhw.demo04.Predicate;

/*
现在有数组
String[] roles={
    "公孙离,女",
    "上官婉儿,女",
    "貂蝉,女",
    "阿珂,女",
    "大乔,女",
    "小乔,女",
    "诸葛亮,男",
    "司马懿,男"
}
筛选出所有复姓的女性角色
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

/*
分析:
    1.复姓有"公孙"和"上官","诸葛","司马"
    2.遍历roles数组,以split(",")进行切割,得到姓名和性别
    3.只要姓名包含复姓中任何一个就继续判断性别是否为女
        1.可以把复姓抽出来形成新的ArrayList集合
        2.如果满足复姓且为女,放到新集合中
    4.遍历新集合,打印出所有的满足要求的角色
 */
public class Demo05 {
    /*
    1.有判断就用断言Predicate
    2.都满足是且的关系,用and
    3.数组需要遍历,遍历后的字符串作为参数
     */
    static boolean isCompoundFemale(
            String info,
            Predicate<String> name,
            Predicate<String> gender
    ) {

        return name.and(gender).test(info);
    }

    ;

    //入口主方法
    public static void main(String[] args) {
        //1.定义数组
        String[] roles = {
                "公孙离,女",
                "上官婉儿,女",
                "貂蝉,女",
                "阿珂,女",
                "大乔,女",
                "小乔,女",
                "诸葛亮,男",
                "司马懿,男"
        };
        //1.1 定义复姓集合(便于扩展)
        ArrayList<String> compounds = new ArrayList<>();
        compounds.add("公孙");
        compounds.add("上官");
        compounds.add("诸葛");
        compounds.add("司马");
        //2.定义新集合,存储符合的角色
        ArrayList<String> compoundFemale = new ArrayList<>();
        //3.遍历数组
        for (String role : roles) {
            //4.调用方法
            boolean isCompoundFemale = isCompoundFemale(role,
                    //4.1判断是否为复姓
                    compound -> {
                        boolean flag = false;
                        for (String s : compounds) {
                            //4.1.1 如果compound包含s,则是复姓
                            if (compound.contains(s)) {
                                flag = true;
                            }
                        }
                        return flag;
                    },
                    //4.2判断是否为女性
                    female -> {
                        //4.2.1先拆分字符串
                        String gender = female.split(",")[1];
                        //4.2.2判断是否为女
                        return gender.equals("女");
                    }
            );
            //5.将满足条件的角色加到新集合
            if (isCompoundFemale) {
                compoundFemale.add(role);
            }
        }
        //6.打印满足条件的角色
        System.out.println(compoundFemale);
    }
}
