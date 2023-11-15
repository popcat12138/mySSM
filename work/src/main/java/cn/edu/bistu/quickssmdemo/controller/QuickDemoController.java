package cn.edu.bistu.quickssmdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickDemoController {

    @RequestMapping("hello")
    public String hello(){
        String hello = "hello Bistu,this is my first page";
        return hello;
    }

}
