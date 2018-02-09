package cn.liuzhiping.intergration.controller;

import cn.liuzhiping.intergration.exception.BizException;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping(value = "/aoptest")
    public String aopTest() {
        String x=null;
        boolean e=x.equals("1");
        return " AOP test success! "+e;
    }

    @GetMapping(value = "/exception_test")
    public String exceptionTest() {
        if (true) {
            throw new BizException("exception_test");
        }
        return " AOP test success!";
    }

}