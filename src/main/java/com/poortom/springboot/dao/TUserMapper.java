package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
//
// MyBatis中使用@Results注解来映射查询结果集到实体类属性。
//
//        （1）@Results的基本用法。当数据库字段名与实体类对应的属性名不一致时，
//        可以使用@Results映射来将其对应起来。column为数据库字段名，porperty为实体类属性名，
//        jdbcType为数据库字段数据类型，id为是否为主键

public interface TUserMapper {

    @Select({
            "select",
            "userid,username,password,iphone,usernumber,weixin,hierarchy",
            "from t_user",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "userid",property ="userid", jdbcType= JdbcType.INTEGER,id=true),
            @Result(column = "username",property ="username", jdbcType= JdbcType.VARCHAR),
            @Result(column = "password",property ="password", jdbcType= JdbcType.VARCHAR),
            @Result(column = "iphone",property ="iphone", jdbcType= JdbcType.VARCHAR),
            @Result(column = "usernumber",property ="usernumber", jdbcType= JdbcType.VARCHAR),
            @Result(column = "weixin",property ="weixin", jdbcType= JdbcType.VARCHAR),
            @Result(column = "hierarchy",property ="hierarchy", jdbcType= JdbcType.VARCHAR)
    })
    TUser selectByusername(String username);

    @Insert({
        "insert into t_user (userid, username, ",
        "password, iphone, ",
        "usernumber, weixin, ",
        "hierarchy)",
        "values (#{userid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{iphone,jdbcType=VARCHAR}, ",
        "#{usernumber,jdbcType=VARCHAR}, #{weixin,jdbcType=VARCHAR}, ",
        "#{hierarchy,jdbcType=VARCHAR})"
    })
    int insert(TUser record);

    @InsertProvider(type=TUserSqlProvider.class, method="insertSelective")
    int insertSelective(TUser record);
}