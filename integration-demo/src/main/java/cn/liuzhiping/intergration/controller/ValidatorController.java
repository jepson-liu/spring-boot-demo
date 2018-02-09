package cn.liuzhiping.intergration.controller;

import cn.liuzhiping.intergration.model.ValidatorReqDemo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "ValidatorController", description = "Validator Test Api")
@Slf4j
@RestController
@RequestMapping("validator")
public class ValidatorController {

    @ApiOperation(value = "update", notes = "update test")
    @PostMapping
    public ResponseEntity<String> update(@RequestBody @Validated ValidatorReqDemo demo, BindingResult result) {
        if (result.hasErrors()) {
            StringBuffer errorSb = new StringBuffer();
            for (ObjectError error : result.getAllErrors()) {
                errorSb.append(error.getDefaultMessage());
                log.error(error.getDefaultMessage() + "<br/>");
            }
            //TODO return error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorSb.toString());
        }
        return ResponseEntity.ok("Success!");
    }
}
