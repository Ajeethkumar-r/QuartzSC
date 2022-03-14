package com.example1.demo1.controller;

import com.example1.demo1.sender.Sch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Commander {

    @Autowired
    Sch sch;

    @GetMapping("/get")
    public String post(){
        sch.iamRunnig();
        return "working";
    }
    
}
