package cn.liuzhiping.datasource.controller;

import cn.liuzhiping.datasource.dao.mapper.CityExtMapper;
import cn.liuzhiping.datasource.dao.mapper.CityMapper;
import cn.liuzhiping.datasource.model.City;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    @Setter
    private CityMapper cityMapper;


    @Autowired
    @Setter
    private CityExtMapper cityExtMapper;

    @GetMapping("{id}")
    public City get(@PathVariable("id") Integer id){
        City city=cityExtMapper.getOne(id);
       return cityMapper.selectByPrimaryKey(id);

    }
}
