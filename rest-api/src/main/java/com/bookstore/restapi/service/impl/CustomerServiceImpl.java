package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.CustomerAdapter;
import com.bookstore.domain.CustomerDomain;
import com.bookstore.restapi.config.security.CustomerPrincipal;
import com.bookstore.restapi.domain.CustomerDto;
import com.bookstore.restapi.domain.request.CustomerRegisterDto;
import com.bookstore.restapi.enums.ErrorCodeEnum;
import com.bookstore.restapi.exception.CustomRuntimeException;
import com.bookstore.restapi.mapper.CustomerDtoMapper;
import com.bookstore.restapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDtoMapper mapper;
    private final CustomerAdapter adapter;

    @Override
    public Boolean registerCustomer(CustomerRegisterDto request) {
        CustomerDomain customerDomain = mapper.toDomainObjectFromLogin(request);
        return adapter.saveCustomer(customerDomain);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return adapter.getAllCustomers().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomerDomain> customerDomain = adapter.loadUserByUsername(username);
        if (!customerDomain.isPresent())
            throw new CustomRuntimeException(ErrorCodeEnum.CONTENT_NOT_FOUND);

        return new CustomerPrincipal(username, customerDomain.get().getEncryptedPassword(), customerDomain.get().getId());
    }
}
