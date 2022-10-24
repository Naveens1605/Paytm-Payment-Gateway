package com.tiffytaste.paytmpaymentgateway.controller;

import com.tiffytaste.paytmpaymentgateway.model.AuthenticationResponse;
import com.tiffytaste.paytmpaymentgateway.model.User;
import com.tiffytaste.paytmpaymentgateway.service.UserService;
import com.tiffytaste.paytmpaymentgateway.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "/authenticate")
    private ResponseEntity<?> authentication(@RequestBody User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getCustId(),user.getName()));
        } catch (IllegalArgumentException e) {
            e.getLocalizedMessage();
        } catch (Exception e) {
            return ResponseEntity.ok(e.getLocalizedMessage());
        }
        final UserDetails userDetails = userService.loadUserByUsername(user.getCustId());
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAuth_token(jwt);
        authenticationResponse.setUserName(userDetails.getPassword());
        authenticationResponse.setUserId(userDetails.getUsername());
        return ResponseEntity.ok(authenticationResponse);
    }
}
