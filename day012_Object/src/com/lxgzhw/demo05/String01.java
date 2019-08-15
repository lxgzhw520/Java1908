package com.lxgzhw.demo05;

public class String01 {
    public static void main(String[] args) {
        //字符串缓冲区,可以提供字符串的操作效率
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append(',');
        stringBuffer.append(97);
        stringBuffer.append(33.33);
        stringBuffer.append("你哈哈,java~");

        //打印
        System.out.println(stringBuffer.toString());
        System.out.println("-------------------------------");
        //在hello的后面插入数据
        int index = stringBuffer.indexOf("o");
        index += 1;
        stringBuffer.insert(index, ",world!!!\t");
        System.out.println(stringBuffer.toString());
        System.out.println("-------------------------------");
    }
}
