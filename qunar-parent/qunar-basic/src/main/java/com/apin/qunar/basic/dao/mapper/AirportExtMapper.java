package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Airport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 11:34
 */
public interface AirportExtMapper {
    @Select("SELECT * FROM airport WHERE airport_name like CONCAT('%',#{name},'%')" +
            "or airport_code like CONCAT('%',#{name},'%') or complete_spell like CONCAT('%',#{name},'%')" +
            "or short_spell like CONCAT('%',#{name},'%') or city_name like CONCAT('%',#{name},'%') limit 9")
    @Results({
            @Result(property = "airportName", column = "airport_name"),
            @Result(property = "airportCode", column = "airport_code"),
            @Result(property = "completeSpell",column = "complete_spell"),
            @Result(property = "shortSpell",column = "short_spell"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "countryName", column = "country_name")
    })
    List<Airport> queryByName(@Param("name") String name);
}