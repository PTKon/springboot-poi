package com.cn.ridge.service;

import com.cn.ridge.bean.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Author: create by wang.gf
 * Date: create at 2018/11/21
 */
@Service("excelService")
public class ExcelService {

    /**
     * 模拟数据
     *
     * @return excel数据
     */
    public List<List<User>> initUser() {
        String name = "user";
        int age = 12;
        String addr = "火星路 12号";
        List<User> users1 = new ArrayList<>(4);
        IntStream.range(0, 4).forEach(i -> {
            users1.add(new User(name + i, age + i, addr + i + "楼"));
        });
        List<User> users2 = new ArrayList<>(4);
        IntStream.range(4, 8).forEach(i -> {
            users2.add(new User(name + i, age + i, addr + i + "楼"));
        });
        List<User> users3 = new ArrayList<>(4);
        IntStream.range(8, 12).forEach(i -> {
            users3.add(new User(name + i, age + i, addr + i + "楼"));
        });
        List<User> users4 = new ArrayList<>(4);
        IntStream.range(12, 16).forEach(i -> {
            users4.add(new User(name + i, age + i, addr + i + "楼"));
        });
        return Arrays.asList(users1, users2, users3, users4);
    }
}
