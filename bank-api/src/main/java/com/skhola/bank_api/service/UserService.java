package com.skhola.bank_api.service;

import com.skhola.bank_api.model.User;

public interface UserService extends BaseService<User, Long> {

    User findByUsername(String username);

}
