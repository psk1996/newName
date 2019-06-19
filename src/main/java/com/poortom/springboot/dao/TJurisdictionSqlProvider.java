package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TJurisdiction;
import org.apache.ibatis.jdbc.SQL;

public class TJurisdictionSqlProvider {

    public String insertSelective(TJurisdiction record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_jurisdiction");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getLimits() != null) {
            sql.VALUES("limits", "#{limits,jdbcType=VARCHAR}");
        }
        
        if (record.getHierarchy() != null) {
            sql.VALUES("hierarchy", "#{hierarchy,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}