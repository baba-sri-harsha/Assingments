package com.payingguest.controllers;

import com.payingguest.model.PayingGuestUser;

import com.payingguest.service.PayingGuestUserServiceImpl;
import com.payingguest.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayingGuestUSerController {

    @Autowired
    private PayingGuestUserServiceImpl payingGuestUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/register")
    public void addUSer(@RequestBody PayingGuestUser pgUser){
        String username= pgUser.getUsername();
        String password=pgUser.getPassword();
        String passwordEncoded= passwordEncoder.encode(password);
        PayingGuestUser pgUser1 = new PayingGuestUser(username,passwordEncoded);
        payingGuestUserService.addUser(pgUser1);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody PayingGuestUser payingGuestUser) {

        authenticate(payingGuestUser.getUsername(), payingGuestUser.getPassword());
        UserDetails details = payingGuestUserService.loadUserByUsername(payingGuestUser.getUsername());
        String jwtToken = jwtTokenUtil.generateToken(details);
        return ResponseEntity.ok(jwtToken);
    }


    private void authenticate(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("invalid credentials");
        } catch (DisabledException e) {
            System.out.println("disabled");
        }
    }


}
