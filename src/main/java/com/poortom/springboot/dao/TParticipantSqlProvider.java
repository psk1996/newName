package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TParticipant;
import org.apache.ibatis.jdbc.SQL;

public class TParticipantSqlProvider {

    public String insertSelective(TParticipant record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_participant");
        
        if (record.getParrtid() != null) {
            sql.VALUES("parrtid", "#{parrtid,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}