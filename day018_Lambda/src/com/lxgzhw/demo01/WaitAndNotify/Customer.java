package com.lxgzhw.demo01.WaitAndNotify;
/*
顾客
 */
public class Customer extends Thread {
    private SteamedStuffedBun steamedStuffedBun;
    public Customer(SteamedStuffedBun steamedStuffedBun){
        this.steamedStuffedBun=steamedStuffedBun;
    }

    @Override
    public void run() {
        while (true){
            synchronized (steamedStuffedBun){
                if (!steamedStuffedBun.isStatus()){
                    //没有包子就等待
                    try {
                        steamedStuffedBun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //有包子就开始吃
                System.out.println("顾客正在吃"+
                        steamedStuffedBun.getSkin()+
                        steamedStuffedBun.getFilling()+
                        "包子");
                //包子吃完,修改状态
                steamedStuffedBun.setStatus(false);
                System.out.println("顾客吃完了"+
                        steamedStuffedBun.getSkin()+
                        steamedStuffedBun.getFilling()+
                        "包子");
                System.out.println("-------------------------------");
            }
        }
    }
}
