package com.skhola.bank_api.repository;

import com.skhola.bank_api.model.Icon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends BaseRepository<Icon, Long> {

    @Query(value = "( " +
            "SELECT i.* FROM icon i " +
            "JOIN answer_user a ON i.icn_id = a.anw_icn_id " +
            "WHERE a.anw_usr_id = :userId " +
            "ORDER BY RANDOM() " +
            "LIMIT 1 " +
            ") " +
            "UNION " +
            "( " +
            "SELECT i.* FROM icon i " +
            "WHERE i.icn_id NOT IN ( " +
            "SELECT anw_icn_id FROM answer_user WHERE anw_usr_id = :userId " +
            ") " +
            "ORDER BY RANDOM() " +
            "LIMIT 8 " +
            ")",
            nativeQuery = true)
    List<Icon> findIconsForUser(@Param("userId") Long userId);

}
