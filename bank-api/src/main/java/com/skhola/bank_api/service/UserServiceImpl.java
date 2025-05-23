package com.skhola.bank_api.service;

import com.skhola.bank_api.exception.ResourceNotFoundException;
import com.skhola.bank_api.model.User;
import com.skhola.bank_api.repository.BaseRepository;
import com.skhola.bank_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository repository;

    public UserServiceImpl(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> entity = repository.findByUsername(username);
        if (entity.isEmpty()) {
            throw new ResourceNotFoundException("Record not found with username: " + username);
        }
        return entity.get();
    }

}
