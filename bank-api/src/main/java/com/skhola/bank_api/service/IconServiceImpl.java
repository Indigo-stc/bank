package com.skhola.bank_api.service;

import com.skhola.bank_api.model.Icon;
import com.skhola.bank_api.repository.BaseRepository;
import com.skhola.bank_api.repository.IconRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl extends BaseServiceImpl<Icon, Long> implements IconService {

    @Autowired
    private IconRepository repository;

    public IconServiceImpl(BaseRepository<Icon, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Icon> findIconsForUser(@Param("userId") Long userId) {
        return repository.findIconsForUser(userId);
    }
}
