package com.github.form_based_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DefaultController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> defaultEndpoint() {
        return ResponseEntity.ok(Map.of("Message", "Welcome"));
    }

}
