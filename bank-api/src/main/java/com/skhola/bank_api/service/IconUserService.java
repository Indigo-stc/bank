package com.skhola.bank_api.service;

import com.skhola.bank_api.model.Icon;
import com.skhola.bank_api.model.IconUser;
import com.skhola.bank_api.model.User;


public interface IconUserService extends BaseService<IconUser, Long> {

    Boolean existsByUserAndIcon(IconUser iconUser);

}