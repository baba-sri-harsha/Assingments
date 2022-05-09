package com.payingguest.service;

import com.payingguest.model.PayingGuestUser;
import com.payingguest.model.PayingGuestUser;


public interface IPayingGuestUserService {

    void addUser(PayingGuestUser pgUser);
    void updateUser(PayingGuestUser pgUser);
    void deleteUser(int PgUserId);

}
