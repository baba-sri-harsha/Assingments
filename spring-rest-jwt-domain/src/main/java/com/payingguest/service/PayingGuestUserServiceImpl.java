package com.payingguest.service;

import com.payingguest.model.PayingGuestUser;
import com.payingguest.repository.IPayingGuestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Arrays;

@Service
public class PayingGuestUserServiceImpl implements IPayingGuestUserService, UserDetailsService {

    @Autowired
    private IPayingGuestUserRepository payingGuestUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PayingGuestUser user = payingGuestUserRepository.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("Invalid Username");

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));

        UserDetails userDetails = new User(user.getUsername(),user.getPassword(),authorities);
        return userDetails;
    }

    @Override
    public void addUser(PayingGuestUser pgUser) {
        payingGuestUserRepository.save(pgUser);
    }

    @Override
    public void updateUser(PayingGuestUser pgUser) {
        payingGuestUserRepository.save(pgUser);
    }

    @Override
    public void deleteUser(int PgUserId) {
        payingGuestUserRepository.deleteById(PgUserId);
    }


}
