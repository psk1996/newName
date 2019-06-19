package com.poortom.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 13620 on 2019/6/11.
 */
@Controller
public class helloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return  "hello";
    }
}
