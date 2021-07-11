package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.CustomerDto;
import com.bookstore.restapi.domain.request.CustomerRegisterDto;

import java.util.List;

public interface CustomerService {

    Boolean registerCustomer(CustomerRegisterDto request);

    List<CustomerDto> getAllCustomers();
}
