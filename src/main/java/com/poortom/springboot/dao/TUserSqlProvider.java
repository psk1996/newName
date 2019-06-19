package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TUser;
import org.apache.ibatis.jdbc.SQL;

public class TUserSqlProvider {

    public String insertSelective(TUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user");
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getIphone() != null) {
            sql.VALUES("iphone", "#{iphone,jdbcType=VARCHAR}");
        }
        
        if (record.getUsernumber() != null) {
            sql.VALUES("usernumber", "#{usernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getWeixin() != null) {
            sql.VALUES("weixin", "#{weixin,jdbcType=VARCHAR}");
        }
        
        if (record.getHierarchy() != null) {
            sql.VALUES("hierarchy", "#{hierarchy,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}