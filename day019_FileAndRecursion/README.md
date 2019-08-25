# `day019` 文件和递归

> 作者:张大鹏



## 001.分隔符

```java
package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo01 {
    public static void main(String[] args) {
        //路径分隔符
        System.out.println(File.pathSeparator);
        //文件分隔符
        System.out.println(File.separator);
    }
}
```



## 002.文件对象

```java
package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo02 {
    public static void main(String[] args) {
        //创建文件对象
        
        //方法1:直接传路径
        File file = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion\\test.txt");

        //方法2:两个路径拼接
        File file02 = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion","test.txt");
        
    }
}
```



## 003.常用方法

```java
package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo03 {
    public static void main(String[] args) {
        //常用方法

        //得到定义根路径
        File root = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion");

        //拼接test.txt
        File test = new File(root, "test.txt");

        //打印文件长度
        System.out.println("文件长度:" + test.length());
        //打印文件路径
        System.out.println("文件路径:" + test.getAbsolutePath());
        System.out.println("文件路径:" + test.getPath());
        //打印上级文件夹
        System.out.println("上级文件夹:" + test.getParent());
        //打印文件名称
        System.out.println("文件名称:" + test.getName());

    }
}
```



## 004.判断方法

```java
package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo04 {
    public static void main(String[] args) {
        //判断方法
        File test = new File("test.txt");
        System.out.println("绝对路径:" + test.getAbsolutePath());

        //是否存在
        System.out.println("是否存在:" + test.exists());

        //是否为目录
        System.out.println("是否为目录:" + test.isDirectory());

        //是否为文件
        System.out.println("是否为文件:" + test.isFile());

        //是否为隐藏
        System.out.println("是否隐藏:" + test.isHidden());
    }
}
```



## 005.创建文件和文件夹

```java
package com.lxgzhw.demo01.File;

import java.io.File;
import java.io.IOException;

public class Demo05 {
    public static void main(String[] args) {
        //创建文件夹
        File root = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion");
        File test = new File(root, "test");
        boolean mkdir = test.mkdir();
        if (mkdir) {
            System.out.println("创建文件夹成功");
        } else {
            System.out.println("创建文件夹失败");
        }
        System.out.println("-------------------------------");
        //创建文件
        File file = new File(root, "test\\test.txt");
        try {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("创建文件成功.");
            } else {
                System.out.println("创建文件失败.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------");
        //创建多级文件夹
        File file1 = new File(root, "test01\\test02\\test03");
        boolean mkdirs = file1.mkdirs();
        if (mkdirs) {
            System.out.println("创建多级目录成功.");
        } else {
            System.out.println("创建多级目录失败.");
        }

    }
}
```



## 006.删除文件和文件夹

```java
package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo06 {
    public static void main(String[] args) {
        //删除文件
        File file = new File("test.txt");
        boolean delete = file.delete();
        if (delete) {
            System.out.println("删除文件成功.");
        } else {
            System.out.println("删除文件失败.");
        }
        System.out.println("-------------------------------");
        //删除文件夹
        //注意:只有空文件夹才能被删除
        File test = new File("test");
        boolean delete1 = test.delete();
        if (delete1) {
            System.out.println("删除文件夹成功.");
        } else {
            System.out.println("删除文件夹失败.");
        }
    }
}
```



## 007.遍历文件夹

```java
package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo07 {
    public static void main(String[] args) {
        //遍历文件夹 得到字符串
        File D = new File("D:\\");
        String[] dList = D.list();
        for (String s : dList) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        //遍历文件夹 得到file对象
        File[] dFiles = D.listFiles();
        for (File dFile : dFiles) {
            System.out.println(dFile);
        }
    }
}
```



## 008.查看目录下的所有文件

```java
package com.lxgzhw.demo02.Filter;

import java.io.File;

public class Demo01 {
    public static void main(String[] args) {
        //递归方法展示目录下所有文件
        File test01 = new File("test01");
        getFile(test01);
    }

    private static void getFile(File test01) {
        //1.调用listFiles
        File[] files = test01.listFiles();
        //2.遍历
        for (File file : files) {
            //3.判断是否为文件夹,是则递归调用
            if (file.isDirectory()) {
                System.out.println(file);
                System.out.print("\t--  ");
                getFile(file);
            } else {
                //否则打印
                System.out.println(file);
            }
        }
    }
}
```



## 009.查找目录

```java
package com.lxgzhw.demo02.Filter;

import java.io.File;

public class Demo02 {
    public static void main(String[] args) {
        //查看以.java结尾的文件并打印
        File test01 = new File("test01");
        getJavaFile(test01);
    }

    private static void getJavaFile(File test01) {
        //1.调用listFiles
        File[] files = test01.listFiles();
        //2.遍历
        for (File file : files) {
            //3.判断是否为文件夹,不为空继续遍历
            if (file.isDirectory()) {
                getJavaFile(file);
            } else {
                //否则判断是否为.java结尾
                if (file.toString().toLowerCase().endsWith(".java")) {
                    System.out.println(file);
                }
            }
        }
    }
}
```

