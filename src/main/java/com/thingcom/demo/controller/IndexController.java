package com.thingcom.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @RequestMapping(value = "/")
    public String home(){
        return "Hello World!";
    }

}
