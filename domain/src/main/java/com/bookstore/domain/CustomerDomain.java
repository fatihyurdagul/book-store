package com.bookstore.domain;

import lombok.*;

@Data
public class CustomerDomain extends BaseDomain{
    private String name;
    private String surname;
    private String username;
    private String encryptedPassword;
}
