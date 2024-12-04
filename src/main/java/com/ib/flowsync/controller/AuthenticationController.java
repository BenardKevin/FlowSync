package com.ib.flowsync.controller;

import com.ib.flowsync.dto.AuthenticationResponseDto;
import com.ib.flowsync.dto.LoginDto;
import com.ib.flowsync.dto.RegisterDto;
import com.ib.flowsync.entity.User;
import com.ib.flowsync.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody LoginDto loginDto){

        //01 - Receive the token from AuthService
        String token = authenticationService.login(loginDto);

        //02 - Set the token as a response using JwtAuthResponse Dto class
        AuthenticationResponseDto authResponseDto = new AuthenticationResponseDto();
        authResponseDto.setAccessToken(token);

        //03 - Return the response to the user
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }

    // Build Register REST API
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto){
        User user = authenticationService.register(registerDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
