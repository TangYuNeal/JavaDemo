package com.example.mapper;

import com.example.pojo.Accout;
import org.apache.ibatis.annotations.Select;

public interface AccoutMapper {
    @Select("select * from user where `userName` = #{name}")
    Accout GetUserByName(String name);
}
