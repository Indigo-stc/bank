package com.skhola.bank_api.service;

import com.skhola.bank_api.model.Icon;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IconService extends BaseService<Icon, Long> {

    List<Icon> findIconsForUser(@Param("userId") Long userId);

}
