package cn.liuzhiping.datasource.controller;

import cn.liuzhiping.datasource.dto.ExampleRequestDto;
import cn.liuzhiping.datasource.model.Example;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("api")
public class RestApiController {

    @Autowired
    private DataSource dataSource;
    //get
    @GetMapping("{id}")
    public ResponseEntity<Example> getExample(@PathVariable("id") Integer id) throws Exception{
        System.out.println( dataSource.getConnection().isReadOnly());
        return ResponseEntity.ok(mock(id));
    }

    //post
    @PostMapping("{id}")
    public ResponseEntity<String> updateExample(@PathVariable("id") Integer id, @RequestBody ExampleRequestDto exampleRequestDto) {
        Example example = new Example();
        BeanUtils.copyProperties(exampleRequestDto, example);
        example.setId(id);
        return ResponseEntity.ok("Success!");
    }

    //put
    @PutMapping
    public ResponseEntity<String> addExample(@RequestBody Example example) {
        example.setId(2);
        return ResponseEntity.ok("Success!");
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> delExample(@PathVariable("id") Integer id) {
        return ResponseEntity.ok("Success!");
    }

    private Example mock(Integer id) {
        Example example = new Example();
        example.setId(id);
        example.setName("Example");
        example.setValue(100f);
        example.setMemo("Test");
        return example;
    }
}
