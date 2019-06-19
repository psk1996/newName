package com.poortom.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.poortom.springboot.entity.TUser;

import com.poortom.springboot.tools.ResponseData;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 13620 on 2019/6/15.
 */
@Controller
@RequestMapping(value = "/api/user")
public class loginController {

// method = {RequestMethod.POST,RequestMethod.GET}
@ResponseBody
    @RequestMapping(value = "/logging",method = {RequestMethod.POST,RequestMethod.GET},produces = {"application/json;charset=UTF-8"} )
    public ResponseData logging(@RequestBody JSONObject params){
        System.out.println("我进入方法了");
        TUser tuser = JSON.toJavaObject(params,TUser.class);
        System.out.println(tuser.getUsername());
        System.out.println(tuser.getPassword());


        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(tuser.getUsername(),tuser.getPassword());
        System.out.println("木桩1");
        //执行认证登录
        try{
            System.out.println("木桩2");
            subject.login(token);
            System.out.println("木桩4");
            System.out.println(subject.getSession().getId().toString());
            return new ResponseData(200,"登录成功",subject.getSession().getId().toString());
        }catch (Exception ex){
            System.out.println("木桩3");
            if(ex.getMessage().equals("101")){
                return new ResponseData(101, "用户不存在！");
            }else if(ex.getMessage().equals("102")){
                return new ResponseData(102, "密码错误！");
            }else if(ex.getMessage().equals("110")){
                return new ResponseData(110, "账户已冻结！");
            }else{
                ex.printStackTrace();
                return new ResponseData(0, ex.getMessage());
            }
        }

    }

}
