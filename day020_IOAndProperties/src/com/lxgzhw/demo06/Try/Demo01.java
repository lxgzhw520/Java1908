package com.lxgzhw.demo06.Try;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) {
        //捕获文件操作异常的方法
        //将文件操作对象定义在try()括号中,
        //可能异常的代码放在{}中
        //try执行完毕,会把流对象自动释放

        //案例:图片的复制
        try (
                //1.输入流
                FileInputStream src = new FileInputStream("test.jpg");
                //2.输出流
                FileOutputStream dest = new FileOutputStream("test01.jpg");
        ) {
            //3.开始复制
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = src.read(bytes)) != -1) {
                dest.write(bytes, 0, len);
            }
            System.out.println("复制成功,请查看.");

        } catch (IOException e) {
            System.out.println("异常错误.");
            e.printStackTrace();
        }
    }
}
