package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.dao.HelloWorld;
import com.oocl.packagebooking.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    public static String getAllHelloWorld() {
    }

    @GetMapping()
    public ResponseEntity getALLmessage(){
        List<HelloWorld> helloWorld = HelloWorldService.getAllHelloWorld();
        return  ResponseEntity.ok().body(helloWorld);
    }
}