package com.poortom.springboot.dao;

import com.poortom.springboot.entity.TJurisdiction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface TJurisdictionMapper {
    @Insert({
        "insert into t_jurisdiction (id, limits, ",
        "hierarchy)",
        "values (#{id,jdbcType=INTEGER}, #{limits,jdbcType=VARCHAR}, ",
        "#{hierarchy,jdbcType=VARCHAR})"
    })
    int insert(TJurisdiction record);

    @InsertProvider(type=TJurisdictionSqlProvider.class, method="insertSelective")
    int insertSelective(TJurisdiction record);
}