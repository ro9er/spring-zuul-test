package com.roger.zuul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yuanqing Luo
 * @date: 2018/8/30
 **/
@RestController
@RequestMapping("test")
@RefreshScope
public class TestController {

    @Value("${roger.test.name}")
    String name;

    @GetMapping("/")
    public String test(){
        return "";
    }
}
