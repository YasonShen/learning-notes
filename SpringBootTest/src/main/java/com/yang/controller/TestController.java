package com.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenqiuyang3
 * @date 2020/11/3 10:59
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "hello spring security";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user!";
    }

    @GetMapping("/db/hello")
    public String dba(){
        return "hello dba";
    }

    @GetMapping("admin/hello")
    public String admin(){
        return "hello admin!";
    }
}
