package com.poortom.springboot.service.Impl;

import com.poortom.springboot.dao.TUserMapper;
import com.poortom.springboot.entity.TUser;
import com.poortom.springboot.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 13620 on 2019/6/16.
 */
@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectByname(String username) {
        TUser tUser = tUserMapper.selectByusername(username);
        return tUser;
    }
}
