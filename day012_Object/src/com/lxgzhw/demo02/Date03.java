package com.lxgzhw.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//DateFormat类
public class Date03 {
    public static void main(String[] args) {
        //得到当前时间
        //年月日时分秒  yMdHms
        //对应的模式
        //yyyy年MM月dd日 HH:mm:ss
        //格式化的字符串传给的是构造方法
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        //格式化只需要传一个Date实例即可
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        System.out.println("-------------------------------");

        //解析的方法
        try {
            Date parse = simpleDateFormat.parse(format);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
