package com.lxgzhw.demo02;

//身体
public class Body {
    private String name;
    private int age;

    //内部类 心脏
    class Heart{
        private String name;

        //内部类的方法
        void beat(){
            System.out.println("心脏跳动.");
            //调用外部类的变量
            System.out.println("我叫"+name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //外部类的方法使用内部类的方法
    void useHeart(){
        System.out.println("间接调用:");
        new Heart().beat();
    }

    public Body() {
    }

    public Body(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Body{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
