package com.lxgzhw.demo02.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) {
        //线程池的使用
        //1.创建固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //2.添加线程
        executorService.submit(new RunnableImpl());
        executorService.submit(new RunnableImpl());
    }
}
