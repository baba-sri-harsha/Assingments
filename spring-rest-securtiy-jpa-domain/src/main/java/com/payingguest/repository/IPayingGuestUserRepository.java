package com.payingguest.repository;

import com.payingguest.model.PayingGuest;
import com.payingguest.model.PayingGuestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayingGuestUserRepository extends JpaRepository<PayingGuestUser,Integer> {

    PayingGuestUser findByUsername(String username);
}
