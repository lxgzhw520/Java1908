package com.lxgzhw.demo01.WaitAndNotify;

/*
包子铺
 */
public class Costs extends Thread {
    //1.创建包子
    private SteamedStuffedBun steamedStuffedBun;
    //2.给包子赋值
    public Costs(SteamedStuffedBun steamedStuffedBun){
        this.steamedStuffedBun=steamedStuffedBun;
    }
    //3.线程任务生产包子


    @Override
    public void run() {
        //统计变量
        int count=0;
        //包子铺一直生产包子
        while (true){
            //同步技术保证只有一个线程在同时执行
            synchronized (steamedStuffedBun){
                //如果有包子,就等待
                if (steamedStuffedBun.isStatus()){
                    try {
                        steamedStuffedBun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //交替生产三种包子
                if (count%3==0){
                    //猪肉大葱
                    steamedStuffedBun.setSkin("猪肉");
                    steamedStuffedBun.setFilling("大葱");
                }else if (count%3==1){
                    //韭菜鸡蛋
                    steamedStuffedBun.setSkin("韭菜");
                    steamedStuffedBun.setFilling("鸡蛋");
                }else if (count%3==2){
                    //灌汤包
                    steamedStuffedBun.setSkin("灌汤");
                    steamedStuffedBun.setFilling("包");
                }
                //让统计变量自增
                count++;
                //生产包子
                System.out.println("包子铺正在生产"+
                        steamedStuffedBun.getSkin()+
                        steamedStuffedBun.getFilling()+
                        "包子");
                //等待时间
                try {
                    //线程休眠五秒钟
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //有包子了,修改包子的状态
                steamedStuffedBun.setStatus(true);
                //随机唤醒消费者线程
                steamedStuffedBun.notify();
                System.out.println("您要的包子做好了.");
            }
        }
    }
}
