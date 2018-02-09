package cn.liuzhiping.intergration.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handler(Exception e) {
        if (e instanceof BizException) {
            return e.getMessage();
        } else {
            log.info("[系统异常] {}", e);
            return "未知错误";
        }
    }
}
