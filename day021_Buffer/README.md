# `day021`缓冲流

> 作者: 张大鹏



## 001.字节缓冲输出流

```java
package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输出流
        /*
        注意:
            1.字节缓冲输出流需要依赖于字节输出流
            2.缓冲类似于传了一个数组,即就是同时传多个字节
            3.关闭的时候会自动调用刷新缓冲的flush功能
         */
        //1.创建
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test.txt"));
        //2.输出
        bufferedOutputStream.write("字节缓冲输出流".getBytes());
        //3.释放资源
        bufferedOutputStream.close();
    }
}
```



## 002.字节缓冲输入流

```java
package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //字节缓冲输入流
        /*
        注意:
            1.依赖于字节输入流
            2.读取的时候需要自己创建读取的大小数组
         */
        //1.创建字节缓冲输入流对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test.txt"));
        //2.读取数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //3.释放资源
        bufferedInputStream.close();
    }
}
```



## 003.字符缓冲输出流

```java
package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输出流
        /*
        注意:
            1.带Stream的是字节流,writer和reader是字符流
            2.换行有newline方法
         */
        //1.创建流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        //2.写入
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("理想国真恵玩");
            bufferedWriter.newLine();
        }
        //3.释放
        bufferedWriter.close();
    }
}
```



## 004.字符缓冲输入流

```java
package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输入流
        /*
        注意:
            1.依赖于FileReader
            2.判断是否读取完毕为null,不再是-1
            3.读取一行的方法是readLine,返回字符串
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
```



## 005.练习1

- 特别注意:`HashMap`的`Key`是有序的

有以下文本

```
3.啊啊啊啊啊啊啊啊啊啊啊
1.哈哈哈哈或或或或或或或
2.哇哇哇哇无无无无无无无无无无无无无无无无无无无无无
```

请按照序号从小到大排序

> 参考代码

```java
package com.lxgzhw.demo01.BufferedStream;

import java.io.*;
import java.util.*;

public class Demo05 {
    public static void main(String[] args) throws IOException {
        //对文本内容进行排序
        //1.创建HashMap集合对象
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        //2.创建字符缓冲输入流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test01.txt"));
        //3.创建字符缓冲输出流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        //4.使用输入流读取数据,按 .进行切割,存到集合中
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //切割
            String[] split = line.split("\\.");
            //5.对集合进行排序,HashMap会自动对key进行排序
            stringStringHashMap.put(split[0], split[1]);
        }
        //6.遍历集合,进行拼接,利用输出流写入
        for (String key : stringStringHashMap.keySet()) {
            String value = stringStringHashMap.get(key);
            line = key + "." + value;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        //7.释放
        bufferedReader.close();
        bufferedWriter.close();
    }
}
```



## 006.复制文件方法1

```java
package com.lxgzhw.demo02.CopyFile;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //复制文件
        //方法1.使用字节输入输出流按字节复制
        //1.创建字节输入流
        InputStream inputStream = new FileInputStream("hzw.jpg");
        //2.创建字节输出流
        OutputStream outputStream = new FileOutputStream("hzw01.jpg");
        //3.输入流读取,输出流输出
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        //4.释放
        inputStream.close();
        outputStream.close();
    }
}
```



## 007.复制文件方法2

```java
package com.lxgzhw.demo02.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //复制文件方法2
        //使用输入输出流,每次读写一个字节数组
        //1.创建输入输出流
        FileInputStream fileInputStream = new FileInputStream("hzw.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("hzw02.jpg");
        //2.操作
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //3.关闭
        fileInputStream.close();
        fileOutputStream.close();
    }
}
```



## 008.复制文件方法3

```java
package com.lxgzhw.demo02.CopyFile;

import java.io.*;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //复制文件方法3:效率最高,推荐使用
        //使用字节缓冲输入输出流读写
        //1.创建读写缓冲字节流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("hzw.jpg"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("hzw03.jpg"));
        //2.读写
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        //3.关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
```



## 009.指定编码输出

```java
package com.lxgzhw.demo03.ReverseStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //输出指定编码格式的文本
        //gbk
        writeGBK();
        //utf-8
        writeUTF8();
    }

    private static void writeUTF8() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("utf8.txt"), "utf-8");
        outputStreamWriter.write("utf8格式的字符串");
        outputStreamWriter.close();
    }

    private static void writeGBK() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
        outputStreamWriter.write("GBK格式的字符串");
        outputStreamWriter.close();
    }
}
```



## 010.指定编码读取

```java
package com.lxgzhw.demo03.ReverseStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //读取指定编码格式的文本
        //gbk
        readGBK();
        //utf8
        System.out.println("\n-------------------------------");
        readUTF8();
    }

    private static void readUTF8() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf8.txt"), "utf8");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }

    private static void readGBK() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("gbk.txt"), "gbk");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }
}
```



## 011.存储自定义对象

- 1.需要用到`ObjectOutputSream类`
- 2.需要`FileOutputSream`作为构造方法的参数
- 3.写入对象用`writeObject()`方法

> 自定义类

```java
package com.lxgzhw.demo04.ObjectStream;

import java.io.Serializable;

public class Person implements Serializable {
    //想要被写入的自定义类型必须实现Serializable接口
    //防止修改代码带来的冲突报错的解决方法
    //写一个固定的序列化id,这个是固定写法
    private static final long serialVersionUID = 1L;
    //如果有什么内容不想被序列化,用transient关键字

    //常规存储 姓名,年龄
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

> 测试类

```java
package com.lxgzhw.demo04.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //写入自定义对象
        //需要用到的类 ObjectOutputStream
        //1.创建
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("obj.txt"));
        //2.写入
        objectOutputStream.writeObject(new Person("楚枫", 22));
        //3.关闭
        objectOutputStream.close();
    }
}
```



## 012.读取自定义对象

- 1.依赖`ObjectInputStream`类
- 2.使用`readObject`方法
- 3.必须存在该对象的字节码`.clas`文件
- 4.该类必须实现`Serializable`接口
- 5.如果没添加固定`id`,必须其源码未发生过修改

```java
package com.lxgzhw.demo04.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        依赖类:
            ObjectInputStream
        读取方法:
            readObject()
        注意:
            1.必须存在该对象的字节码文件.class
            2.该类必须实现Serializable接口
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("obj.txt"));
        Object o = objectInputStream.readObject();
        System.out.println(o);
        Person o1 = (Person) o;
        System.out.println(o1.getName() + ":" + o1.getAge());
    }
}
```

