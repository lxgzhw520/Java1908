# `day015`Map

> 作者: 张大鹏



## 001.`Map`的增删改查

```java
package com.lxgzhw.Map;

import java.util.HashMap;

/*
Map集合:
    1.存储的是键值对
    2.键不允许重复
    3.HashMap是无序集合
    4.LinkedHashMap是有序集合
 */
public class Demo01 {
    public static void main(String[] args) {
        //集合的添加方法
        //put(键,值) 没有就添加,有就修改,和python字典一样
        mapAdd();

        //集合的删除方法
        //remove(键) 根据键删除值
        //存在返回删除的值,不存在返回null,不会报错
        mapRemove();

        //集合的查找方法
        //get(键) 根据键获取值
        //存在返回值,不存在返回null,不会报错
        mapGet();

        //集合的判断方法
        //containsKey(键) 根据键判断该键值对是否已存在
        //返回对应的布尔值
        mapContains();
    }

    private static void mapContains() {
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "楚枫");
        integerStringHashMap.put(2, "楚枫");
        integerStringHashMap.put(3, "楚枫");
        System.out.println("判断:");
        System.out.println(integerStringHashMap.containsKey(1));
        System.out.println(integerStringHashMap.containsKey(2));
        System.out.println(integerStringHashMap.containsKey(3));
        System.out.println(integerStringHashMap.containsKey(4));
    }

    private static void mapGet() {
        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();
        stringBooleanHashMap.put("楚枫", true);
        stringBooleanHashMap.put("萃萃", true);
        stringBooleanHashMap.put("大黄", false);
        System.out.println(stringBooleanHashMap);
        System.out.println("-------------------------------");
        stringBooleanHashMap.remove("大黄");
        System.out.println(stringBooleanHashMap);
        System.out.println("-------------------------------");
        System.out.println("获取楚枫的值:");
        System.out.println(stringBooleanHashMap.get("楚枫"));
        System.out.println("-------------------------------");
        System.out.println("获取已删除的大黄的值:");
        System.out.println(stringBooleanHashMap.get("大黄"));
        System.out.println("-------------------------------");
    }

    private static void mapRemove() {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("楚枫", 22);
        stringIntegerHashMap.put("萃萃", 22);
        stringIntegerHashMap.put("大黄", 322);
        System.out.println(stringIntegerHashMap);
        System.out.println("-------------------------------");
        System.out.println("删除大黄:");
        stringIntegerHashMap.remove("大黄");
        System.out.println("删除中....");
        System.out.println("删除成功.");
        System.out.println(stringIntegerHashMap);
        System.out.println("-------------------------------");
    }

    private static void mapAdd() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("楚枫", "萃萃");
        System.out.println(stringStringHashMap);
        System.out.println("-------------------------------");
    }
}
```



## 002.`Map`的遍历方法

```java
package com.lxgzhw.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("楚枫", 22);
        stringIntegerHashMap.put("萃萃", 22);
        stringIntegerHashMap.put("大黄", 322);
        //遍历集合的所有键
        System.out.println("集合所有的键:");
        Set<String> strings = stringIntegerHashMap.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("-------------------------------");
        //遍历集合所有的值
        System.out.println("集合所有的值:");
        Collection<Integer> values = stringIntegerHashMap.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        System.out.println("-------------------------------");
        //遍历集合的所有键值对
        System.out.println("集合所有的键值对:");
        Set<Map.Entry<String, Integer>> entries = stringIntegerHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
        System.out.println("-------------------------------");
    }
}
```



## 003.自定义类型作为键值

> 自定义类型

```java
package com.lxgzhw.HashMap;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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

> 入口类

```java
package com.lxgzhw.HashMap;

import java.util.HashMap;

/*
存储自定义类型:
    1.自定义类型必须重写hashCode和equals方法,保证键唯一
 */
public class Demo01 {
    public static void main(String[] args) {

        //自定义类型作为值
        mapPersonValue();

        //自定义类型作为键
        mapPersonKey();
    }

    private static void mapPersonKey() {
        HashMap<Person, String> personStringHashMap = new HashMap<>();
        personStringHashMap.put(new Person("楚枫", 22), "Java全栈班");
        personStringHashMap.put(new Person("萃萃", 22), "Java基础班");
        personStringHashMap.put(new Person("大黄", 22), "Java基础班");
        System.out.println(personStringHashMap);
        System.out.println("-------------------------------");
    }

    private static void mapPersonValue() {
        HashMap<String, Person> stringPersonHashMap = new HashMap<>();
        stringPersonHashMap.put("Java基础班", new Person("楚枫", 22));
        stringPersonHashMap.put("Java高级班", new Person("萃萃", 22));
        System.out.println(stringPersonHashMap);
        System.out.println("-------------------------------");
    }
}
```



## 004.练习1

> 判断字符串中每个字符出现的次数

> 参考答案

```java
package com.lxgzhw.Map;

import java.util.HashMap;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        //计算字符串中每个字符出现的次数
        //1.录入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String next = sc.next();
        //2.转换为字符数组
        char[] chars = next.toCharArray();
        //3.创建一个键为字符,值为次数的集合
        //4.1遍历字符数组,进行计算
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //4.1.1集合有自动去重功能
            //4.1.2先判断集合中有没有该字符的键
            //4.1.3没有就存储,有就让值++
            char key = chars[i];
            boolean b = characterIntegerHashMap.containsKey(key);
            if (b) {
                Integer value = characterIntegerHashMap.get(key);
                characterIntegerHashMap.put(key, ++value);
            } else {
                characterIntegerHashMap.put(key, 1);
            }
        }

        //6.打印集合
        System.out.println(characterIntegerHashMap);
    }
}
```



## 005.斗地主实战案例

> 地主类

```java
package com.lxgzhw.FightTheLandLord;

import java.util.*;

/*
斗地主案例:
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
    5.看牌
 */
class Demo {
    //牌的索引和组装好的牌
    private HashMap<Integer, String> poker;
    //牌的索引
    private  ArrayList<Integer> pokerIndex;

    //花色
    private static ArrayList<String> getColors() {
        //"♠", "♥", "♣", "♦"
        ArrayList<String> colors = new ArrayList<>();
        colors.add("♠");
        colors.add("♥");
        colors.add("♣");
        colors.add("♦");
        return colors;
    }

    //序号
    private static ArrayList<String> getNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("2");
        numbers.add("A");
        numbers.add("K");
        numbers.add("Q");
        numbers.add("J");
        numbers.add("10");
        numbers.add("9");
        numbers.add("8");
        numbers.add("7");
        numbers.add("6");
        numbers.add("5");
        numbers.add("4");
        numbers.add("3");
        return numbers;
    }

    //准备牌
    void prepare() {
        //1.添加大王和小王
        int index = 0;
        this.poker.put(0, "大王");
        this.pokerIndex.add(index);
        index++;
        this.poker.put(1, "小王");
        this.pokerIndex.add(index);
        index++;
        //2.组装52张牌,存储到扑克集合和扑克索引集合
        for (String number : getNumbers()) {
            for (String color : getColors()) {
                //组装序号(外)和花色(内)
                //存储到集合
                this.poker.put(index, color + number);
                this.pokerIndex.add(index);
                ++index;
            }
        }
    }
    //洗牌
    void shufflePoker(){
        Collections.shuffle(pokerIndex);
    }

    //发牌
    HashMap<String, ArrayList<Integer>> sendPoker(){
        //1.创建三个玩家和底牌
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> leftCard = new ArrayList<>();
        //2.遍历扑克索引
        //3.除了最后三张,前面的分别发给三个玩家
        for (int i = 0; i < this.pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //底牌
            if (i>50){
                leftCard.add(in);
            }else if (i%3==0){
                player01.add(in);
            }else if (i%3==1){
                player02.add(in);
            }else if (i%3==2){
                player03.add(in);
            }
        }
        //4.排序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(leftCard);

        //5.装在集合中,返回集合
        HashMap<String, ArrayList<Integer>> stringArrayListHashMap = new HashMap<>();
        stringArrayListHashMap.put("玩家1",player01);
        stringArrayListHashMap.put("玩家2",player02);
        stringArrayListHashMap.put("玩家3",player03);
        stringArrayListHashMap.put("底牌",leftCard);

        return stringArrayListHashMap;
    }

    //打印扑克和索引
    void printPoker() {
        //1.得到发牌后的集合
        HashMap<String, ArrayList<Integer>> playerPokers = sendPoker();
        //2.遍历集合打印
        for (String key : playerPokers.keySet()) {
            //根据键得到值
            ArrayList<Integer> playerPoker = playerPokers.get(key);
            //将值由扑克索引转换为扑克牌
            ArrayList<String> newPlayerPoker = replacePokerIndex(playerPoker);
            //打印键值对
            System.out.println(key+" : "+ newPlayerPoker);
        }

    }
    //将扑克索引换成扑克牌
    ArrayList<String> replacePokerIndex(ArrayList<Integer> index){
        ArrayList<String> replacePoker = new ArrayList<>();
        for (int i = 0; i < index.size(); i++) {
            Integer in = index.get(i);
            //得到对应的牌
            String indexPoker = poker.get(in);
            replacePoker.add(indexPoker);
        }
        return replacePoker;
    }

    public Demo() {
    }

    public Demo(HashMap<Integer, String> poker, ArrayList<Integer> pokerIndex) {
        this.poker = poker;
        this.pokerIndex = pokerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return Objects.equals(poker, demo.poker) &&
                Objects.equals(pokerIndex, demo.pokerIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poker, pokerIndex);
    }

    @Override
    public String toString() {
        return "Demo{" +
                "poker=" + poker +
                ", pokerIndex=" + pokerIndex +
                '}';
    }

    public HashMap<Integer, String> getPoker() {
        return poker;
    }

    public void setPoker(HashMap<Integer, String> poker) {
        this.poker = poker;
    }

    public ArrayList<Integer> getPokerIndex() {
        return pokerIndex;
    }

    public void setPokerIndex(ArrayList<Integer> pokerIndex) {
        this.pokerIndex = pokerIndex;
    }
}
```

> 测试类

```java
package com.lxgzhw.FightTheLandLord;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        //斗地主,需要扑克集合和扑克索引集合
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        Demo demo = new Demo(poker, pokerIndex);
        //准备牌
        demo.prepare();
        //打印牌
        demo.printPoker();
    }
}
```

