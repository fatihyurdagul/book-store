package com.bookstore.domain;

import lombok.*;

@Getter
@Setter
public class CustomerDomain extends BaseDomain{
    private String name;
    private String surname;
    private String username;
    private String encryptedPassword;
}
