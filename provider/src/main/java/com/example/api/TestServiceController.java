package com.example.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController {
    @RequestMapping("/test/list")
    public String get() {
        return "testService";
    }
}
