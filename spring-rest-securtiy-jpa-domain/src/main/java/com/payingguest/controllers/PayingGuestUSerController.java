package com.payingguest.controllers;

import com.payingguest.model.PayingGuestUser;
import com.payingguest.service.IPayingGuestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayingGuestUSerController {

    @Autowired
    private IPayingGuestUserService payingGuestUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void addUSer(@RequestBody PayingGuestUser pgUser){
        String username= pgUser.getUsername();
        String password=pgUser.getPassword();
        String passwordEncoded= passwordEncoder.encode(password);
        PayingGuestUser pgUser1 = new PayingGuestUser(username,passwordEncoded);
        payingGuestUserService.addUSer(pgUser1);
    }


}
