package com.skhola.bank_api.service;

import com.skhola.bank_api.model.IconUser;
import com.skhola.bank_api.repository.BaseRepository;
import com.skhola.bank_api.repository.IconUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconUserServiceImpl extends BaseServiceImpl<IconUser, Long> implements IconUserService {

    @Autowired
    private IconUserRepository repository;

    public IconUserServiceImpl(BaseRepository<IconUser, Long> baseRepository) {
        super(baseRepository);
    }

    public Boolean existsByUserAndIcon(IconUser iconUser) {
        return repository.existsByUserAndIcon(iconUser.getUser(), iconUser.getIcon());
    }

}
