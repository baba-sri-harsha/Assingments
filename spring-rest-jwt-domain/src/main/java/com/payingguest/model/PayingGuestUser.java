package com.payingguest.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class PayingGuestUser {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(unique=true,length=30)
    private String username;
    private String password;

    public PayingGuestUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
