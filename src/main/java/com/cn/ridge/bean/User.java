package com.cn.ridge.bean;

/**
 * Author: create by wang.gf
 * Date: create at 2018/11/21
 */
public class User {
    private String name;
    private Integer age;
    private String addr;

    public User() {
    }

    public User(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
