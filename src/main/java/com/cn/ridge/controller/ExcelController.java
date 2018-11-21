package com.cn.ridge.controller;

import com.cn.ridge.bean.User;
import com.cn.ridge.service.ExcelService;
import com.cn.ridge.view.ExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * Author: create by wang.gf
 * Date: create at 2018/11/21
 */
@RestController
public class ExcelController {
    private ExcelService excelService;

    @GetMapping(value = "/excel")
    public ModelAndView toExcel() {
        List<List<User>> allUsers = excelService.initUser();
        ExcelView excelView = new ExcelView();
        return new ModelAndView(excelView, Collections.singletonMap("allUsers", allUsers));
    }

    @Autowired
    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }
}
