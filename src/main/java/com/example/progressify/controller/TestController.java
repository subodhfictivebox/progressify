package com.example.progressify.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @PostMapping("/testing")
    public String testing() {
        return "The application is running successfully and ready to test it out asdsd";
    }
}
