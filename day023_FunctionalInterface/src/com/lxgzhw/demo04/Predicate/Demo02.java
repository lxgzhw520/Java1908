package com.lxgzhw.demo04.Predicate;

import java.util.function.Predicate;

/*
Predicate断言接口能够判断:
    1.支持使用and进行与的判断
    2.可用同时判断两个以上的条件

 */
public class Demo02 {
    //接口方法
    static boolean checkPassword(String password,
                                 Predicate<String> length,
                                 Predicate<String> upper,
                                 Predicate<String> lower,
                                 Predicate<String> number
    ) {
        /*
        密码要求:
            1.长度大于5
            2.必须包含大写
            3.必须包含小写
            4.必须包含数字
         */
        return length.and(upper)
                .and(lower)
                .and(number)
                .test(password);

    }

    //主方法
    public static void main(String[] args) {
        //1.设置密码
        String password = "Abc111";
        //2.调用方法
        boolean isPassword = checkPassword(password,
                //判断长度
                (length) -> {
                    return password.length() > 5;
                },
                //判断大写
                (upper) -> {
                    boolean flag = false;
                    char[] chars = password.toCharArray();
                    for (char aChar : chars) {
                        boolean upperCase = Character.isUpperCase(aChar);
                        if (upperCase) {
                            flag = true;
                        }
                    }
                    return flag;
                },
                //判断小写
                (lower) -> {
                    boolean flag = false;
                    char[] chars = password.toCharArray();
                    for (char aChar : chars) {
                        boolean lowerCase = Character.isLowerCase(aChar);
                        if (lowerCase) {
                            flag = true;
                        }
                    }
                    return flag;
                },
                //判断数字
                (number) -> {
                    boolean flag = false;
                    char[] chars = password.toCharArray();
                    for (char aChar : chars) {
                        boolean isNum = Character.isDigit(aChar);
                        if (isNum) {
                            flag = true;
                        }
                    }
                    return flag;
                }
        );
        if (isPassword) {
            System.out.println("该密码可用.");
        }
    }
}
