package com.thepunecoder.accounts.service.impl;

import com.thepunecoder.accounts.repository.AccountsRepository;
import com.thepunecoder.accounts.repository.CustomerRepository;
import com.thepunecoder.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     *                  
     * @param customerDto
     *
     * */
    @Override
    public void createAccount(com.thepunecoder.accounts.dto.CustomerDto customerDto) {

    }
}
