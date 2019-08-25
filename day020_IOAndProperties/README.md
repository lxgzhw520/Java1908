##  `day020` 字节流和字符流

> 作者:张大鹏



## 001.字节输出流

```java
package com.lxgzhw.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字节输出流
        //常用方法: close flush write
        //1.创建FileOutputStream对象
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //2.调用write方法
        fileOutputStream.write(97);
        //3.释放资源
        fileOutputStream.close();
    }
}
```



## 002.一次写多个字节

```java
package com.lxgzhw.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //一次写多个字节的方法
        byte[] arr = {97, 98, 99, 100, 101};
        //write(字节数组)
        fileOutputStream.write(arr);

        //write(字节数组,开始索引,长度)
        fileOutputStream.write(arr, 1, 3);

        fileOutputStream.close();
    }
}
```



## 003.追加+换行

```java
package com.lxgzhw.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //追加写FileOutputStream(位置,是否追加)
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        for (int i = 0; i < 10; i++) {
            //将字符串转换为字节数组后写入
            fileOutputStream.write("你好".getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
    }
}
```



## 004.字节输入流

```java
package com.lxgzhw.demo02.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字节输入流
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        //一次性读取
        int len = 0;
        while ((len = fileInputStream.read()) != -1) {
            System.out.println(len);
        }
        fileInputStream.close();
    }
}
```



## 005.一次性读取多个字节

```java
package com.lxgzhw.demo02.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //一次性读取多个字节
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fileInputStream.close();
    }
}
```



## 006.文件复制

```java
package com.lxgzhw.demo03.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //文件复制
        //test.txt  --->>>  test01.txt
        //1.创建输入流,绑定要复制的数据
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        //2.创建输出流,绑定复制到哪里
        FileOutputStream fileOutputStream = new FileOutputStream("test01.txt");
        //3.一次性读取多个字节
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            //4.进行复制
            fileOutputStream.write(bytes, 0, len);
        }
        //5.资源释放
        fileInputStream.close();
        fileOutputStream.close();
    }
}
```



## 007.字符输入流

```java
package com.lxgzhw.demo04.Reader;

import java.io.FileReader;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字符输入流
        //FileReader 按字符读取数据,FileInputStream是按字节读取
        //1.创建字符输入流
        FileReader fileReader = new FileReader("test.txt");
        //2.一次性读取多个字符
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        //3.释放资源
        fileReader.close();
    }
}
```



## 008.字符输出流

- 1.支持直接输出字符串

```java
package com.lxgzhw.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字符输出流
        //支持直接输出字符串
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("直接输出字符串");
        fileWriter.close();
    }
}
```

- 2.支持输出字符数组

```java
package com.lxgzhw.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //支持输出字符数组
        char[] arr = {'我', '是', '中', '国', '人'};
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write(arr);
        fileWriter.close();
    }
}
```

> 总结:
>
> 字节输入输出流主要用来操作媒体文件
>
> 字符输入输出流主要用来操作文本文件



## 009.`try`方法复制图片

```java
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
```

- 代码不美观
- 一般情况下抛出异常就可以了



## 010.`Properties`集合

```java
package com.lxgzhw.demo07.Properties;

import java.io.*;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //Properties唯一和流结合的集合
        //load加载文件中的键值对
        //store保存键值对到文件
        /*
        1.支持#号注释
        2.键值对在内存中必须都是字符串
        3.在文件中无需引号
         */
        //1.创建集合
        Properties properties = new Properties();
        properties.setProperty("楚枫", "22");
        properties.setProperty("萃萃", "22");
        properties.setProperty("大黄", "322");
        //2.保存数据
        properties.store(new FileWriter("prop.txt"), "");
        System.out.println("数据保存成功.");
        //3.查看数据,读取数据
        Properties properties1 = new Properties();
        properties1.load(new FileReader("prop.txt"));
        System.out.println(properties1);
    }
}
```

