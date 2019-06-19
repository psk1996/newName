package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TParttimejob;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface TParttimejobMapper {
    @Insert({
        "insert into t_parttimejob (ptjobid, issueid, ",
        "ptname, starttime, ",
        "overtime, money_day, ",
        "address, activetext)",
        "values (#{ptjobid,jdbcType=INTEGER}, #{issueid,jdbcType=INTEGER}, ",
        "#{ptname,jdbcType=VARCHAR}, #{starttime,jdbcType=VARCHAR}, ",
        "#{overtime,jdbcType=VARCHAR}, #{moneyDay,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{activetext,jdbcType=VARCHAR})"
    })
    int insert(TParttimejob record);

    @InsertProvider(type=TParttimejobSqlProvider.class, method="insertSelective")
    int insertSelective(TParttimejob record);
}