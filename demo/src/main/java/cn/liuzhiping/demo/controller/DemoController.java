package cn.liuzhiping.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class DemoController {
    @GetMapping("{say}")
    public ResponseEntity<String> hello(@PathVariable("say") String say) {
        return ResponseEntity.ok("Hello " + say + " !");
    }
}
