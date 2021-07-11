package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.CustomerDto;
import com.bookstore.restapi.domain.request.CustomerRegisterDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService extends UserDetailsService {

    Boolean registerCustomer(CustomerRegisterDto request);

    List<CustomerDto> getAllCustomers();
}
