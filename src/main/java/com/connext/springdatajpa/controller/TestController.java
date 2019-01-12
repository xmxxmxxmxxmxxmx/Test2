package com.connext.springdatajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiamingxing
 * @date 2019/1/12 19:29
 */
@Controller
@RequestMapping("/test")
public class TestController {
    public String test(){
        return "abc";
    }
}
