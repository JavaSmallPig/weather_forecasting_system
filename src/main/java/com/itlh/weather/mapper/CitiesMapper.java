package com.itlh.weather.mapper;

import com.itlh.weather.pojo.City;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Java小猪
 * @Date 2024/12/5 15:00
 */
public interface CitiesMapper {
    @Select("select *from cities where id = #{id}")
    City findById(int id);
}
