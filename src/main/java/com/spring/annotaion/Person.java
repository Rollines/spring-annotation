package com.spring.annotaion;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
public class Person {

    //1、基本数值
    //2、SpEl:#{}
    //3、${}取出文件配置[propers]中的值（在运行环境变量里面的值）
    @Value("王五")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person(){
        super();
    }



}
