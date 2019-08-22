package com.lxgzhw.demo01.WaitAndNotify;

/*
包子
 */
public class SteamedStuffedBun {
    //皮
    private String skin;
    //馅儿
    private String filling;
    //包子的状态 有还是没有
    private boolean status;

    public SteamedStuffedBun() {
    }

    public SteamedStuffedBun(String skin, String filling, boolean status) {
        this.skin = skin;
        this.filling = filling;
        this.status = status;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SteamedStuffedBun{" +
                "skin='" + skin + '\'' +
                ", filling='" + filling + '\'' +
                ", status=" + status +
                '}';
    }
}
