package com.ib.flowsync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ib.flowsync.component.JwtTokenProvider;
import com.ib.flowsync.dto.LoginDto;
import com.ib.flowsync.dto.RegisterDto;
import com.ib.flowsync.entity.User;
import com.ib.flowsync.repository.UserRepository;
import com.ib.flowsync.entity.Role;
import com.ib.flowsync.repository.RoleRepository;
import com.ib.flowsync.entity.RoleEnum;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Encode password using BCrypt
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(LoginDto loginDto) {

        // 01 - AuthenticationManager is used to authenticate the user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        /* 02 - SecurityContextHolder is used to allows the rest of the application to know
        that the user is authenticated and can use user data from Authentication object */
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 03 - Generate the token based on username and secret key

        // 04 - Return the token to controller
        return jwtTokenProvider.generateToken(authentication);
    }

    public User register(RegisterDto registerDto) {
        // Create new user from register DTO
        User user = new User();
        user.setFirstname(registerDto.getFirstname());
        user.setLastname(registerDto.getLastname());
        user.setEmail(registerDto.getEmail());

        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        user.setPassword(encodedPassword);

        // Save user to database
        User savedUser = userRepository.save(user);

        // Set user role by default
        Role userRole = roleRepository.findByName(RoleEnum.USER.toString()).orElse(null);
        savedUser.getRoles().add(userRole);
        savedUser = userRepository.save(savedUser);

        return savedUser;
    }
}