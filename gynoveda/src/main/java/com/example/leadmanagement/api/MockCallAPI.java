package com.example.leadmanagement.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockCallAPI {

    @PostMapping("/api/call")
    public String mockCall() {
        return "Mock call triggered";
    }
}