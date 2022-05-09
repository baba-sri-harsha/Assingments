package com.payingguest.service;

import com.payingguest.model.PayingGuestUser;
import com.payingguest.repository.IPayingGuestRepository;
import com.payingguest.repository.IPayingGuestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PayingGuestUserServiceImpl implements IPayingGuestUserService, UserDetailsService {


    private IPayingGuestUserRepository payingGuestUserRepository;

    public PayingGuestUserServiceImpl(IPayingGuestUserRepository payingGuestUserRepository) {
        this.payingGuestUserRepository = payingGuestUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PayingGuestUser pgUser= payingGuestUserRepository.findByUsername(username);

        String nUsername= pgUser.getUsername();
        String password= pgUser.getPassword();

        GrantedAuthority authority= new SimpleGrantedAuthority("USER");
        GrantedAuthority authority1= new SimpleGrantedAuthority("ADMIN");

        UserDetails user= new User(nUsername,password, Arrays.asList(authority,authority1));

        return user;
    }

    @Override
    public void addUSer(PayingGuestUser pgUser) {
        payingGuestUserRepository.save(pgUser);

    }


    @Override
    public void updateUer(PayingGuestUser pgUser) {
        payingGuestUserRepository.save(pgUser);
    }

    @Override
    public void deleteUser(int PgUserId) {
        payingGuestUserRepository.deleteById(PgUserId);
    }


}
