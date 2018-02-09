package cn.liuzhiping.datasource.dao.mapper;

import cn.liuzhiping.datasource.model.City;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CityExtMapper {
    @Select("SELECT * FROM city WHERE id = #{id}")
    City getOne(Integer id);
}