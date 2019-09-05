package com.lxgzhw.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxgzhw.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JacksonTest {
    @Test
    public void test01() throws JsonProcessingException {
        //Java对象转json字符串
        //1.创建Person对象
        Person person = new Person("张大鹏", 22, "男", new Date());
        //2.创建ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //3.转换为String字符串
        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);
    }

    @Test
    public void test02() throws IOException {
        //转换为json并保存
        new ObjectMapper().writeValue(new FileWriter("person.json"),
                new Person("张大鹏", 22, "男", new Date()));
    }

    @Test
    public void test03() throws JsonProcessingException {
        //列表转json
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("张大鹏", 22, "男", new Date()));
        people.add(new Person("张大鹏", 22, "男", new Date()));
        people.add(new Person("张大鹏", 22, "男", new Date()));
        people.add(new Person("张大鹏", 22, "男", new Date()));
        String s = new ObjectMapper().writeValueAsString(people);
        System.out.println(s);
    }

    @Test
    public void test04() throws IOException {
        //json转Person
        String person = "{\"name\":\"张大鹏\",\"age\":22,\"gender\":\"男\",\"birthday\":\"2019-09-03\"}";
        Person person1 = new ObjectMapper().readValue(person, Person.class);
        System.out.println(person1);
    }
}
