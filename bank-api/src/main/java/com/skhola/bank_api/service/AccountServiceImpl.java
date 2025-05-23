package com.skhola.bank_api.service;

import com.skhola.bank_api.model.Account;
import com.skhola.bank_api.repository.AccountRepository;
import com.skhola.bank_api.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Long> implements AccountService {

    @Autowired
    private AccountRepository repository;

    public AccountServiceImpl(BaseRepository<Account, Long> baseRepository) {
        super(baseRepository);
    }

}
