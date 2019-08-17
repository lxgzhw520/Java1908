package com.lxgzhw.Set;

import java.util.HashSet;

public class Demo02 {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("abd");
        strings.add("abd");
        strings.add("重地");
        strings.add("通话");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
