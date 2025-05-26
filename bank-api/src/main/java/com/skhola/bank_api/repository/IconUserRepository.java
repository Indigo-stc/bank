package com.skhola.bank_api.repository;

import com.skhola.bank_api.model.Icon;
import com.skhola.bank_api.model.IconUser;
import com.skhola.bank_api.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IconUserRepository extends BaseRepository<IconUser, Long> {

    Boolean existsByUserAndIcon(User user, Icon icon);

}
