package com.skhola.bank_api.repository;

import com.skhola.bank_api.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
}
