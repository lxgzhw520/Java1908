package com.lxgzhw.demo06;

//笔记本类,包含开机功能,关机功能,使用`usb`的功能
public class LapTop {
    String brand;//品牌
    String color;//颜色
    double price;//价格

    //开机
    void start(){
        System.out.println("开机");
    }
    //关机
    void powerOff(){
        System.out.println("关机");
    }
    //使用USB的功能
    USB useUsb(USB usb){
        System.out.println("使用USB");
        return usb;
    }

    public LapTop() {
    }

    public LapTop(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LapTop{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
