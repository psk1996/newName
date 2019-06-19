package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TParticipant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface TParticipantMapper {
    @Insert({
        "insert into t_participant (parrtid, userid)",
        "values (#{parrtid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER})"
    })
    int insert(TParticipant record);

    @InsertProvider(type=TParticipantSqlProvider.class, method="insertSelective")
    int insertSelective(TParticipant record);
}