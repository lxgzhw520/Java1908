package com.lxgzhw.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Throwable:
    1.Exception 程序员能处理的错误
    2.Error 程序员不能处理的错误
 */
public class Demo01 {
    public static void main(String[] args) {
        //捕获异常
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse("2019-9999");
        } catch (ParseException e) {
            System.out.println("不支持的日期格式,请检查.");
        }
    }
}
