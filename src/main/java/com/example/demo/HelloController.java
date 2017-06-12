package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhao on 6/12/2017.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String say(){
        return "Hello SpringBoot";
    }
}
