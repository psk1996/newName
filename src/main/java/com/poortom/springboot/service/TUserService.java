package com.poortom.springboot.service;

import com.poortom.springboot.entity.TUser;

/**
 * Created by 13620 on 2019/6/16.
 */
public interface TUserService {

    //根据登录名查询user对象
    TUser selectByname(String username);

}
