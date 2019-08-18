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

