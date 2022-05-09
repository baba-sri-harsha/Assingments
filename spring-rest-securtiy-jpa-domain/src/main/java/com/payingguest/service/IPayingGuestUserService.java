package com.payingguest.service;

import com.payingguest.exceptions.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;
import com.payingguest.model.PayingGuestUser;
import com.payingguest.service.IPayingGuestService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPayingGuestUserService {

    void addUSer(PayingGuestUser pgUser);
    void updateUer(PayingGuestUser pgUser);
    void deleteUser(int PgUserId);

}
