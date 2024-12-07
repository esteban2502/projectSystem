package com.projectSystem.projectSystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("hasRole('USER')")
public class TestAuthController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-secured")
    public String helloSecured(){
        return  "Hello world secured";
    }
}
