package com.projectSystem.projectSystem.controller;

import com.projectSystem.projectSystem.controller.DTO.AuthCreateUserRequest;
import com.projectSystem.projectSystem.controller.DTO.AuthLoginRequest;
import com.projectSystem.projectSystem.controller.DTO.AuthResponse;
import com.projectSystem.projectSystem.persistence.Implementation.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/singup")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUser){
        return new ResponseEntity<>(this.userDetailService.createUser(authCreateUser),HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){

        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }
}
