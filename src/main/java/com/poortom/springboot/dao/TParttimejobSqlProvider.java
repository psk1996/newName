package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TParttimejob;
import org.apache.ibatis.jdbc.SQL;

public class TParttimejobSqlProvider {

    public String insertSelective(TParttimejob record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_parttimejob");
        
        if (record.getPtjobid() != null) {
            sql.VALUES("ptjobid", "#{ptjobid,jdbcType=INTEGER}");
        }
        
        if (record.getIssueid() != null) {
            sql.VALUES("issueid", "#{issueid,jdbcType=INTEGER}");
        }
        
        if (record.getPtname() != null) {
            sql.VALUES("ptname", "#{ptname,jdbcType=VARCHAR}");
        }
        
        if (record.getStarttime() != null) {
            sql.VALUES("starttime", "#{starttime,jdbcType=VARCHAR}");
        }
        
        if (record.getOvertime() != null) {
            sql.VALUES("overtime", "#{overtime,jdbcType=VARCHAR}");
        }
        
        if (record.getMoneyDay() != null) {
            sql.VALUES("money_day", "#{moneyDay,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getActivetext() != null) {
            sql.VALUES("activetext", "#{activetext,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}