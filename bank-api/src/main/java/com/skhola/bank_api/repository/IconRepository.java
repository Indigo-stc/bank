package com.skhola.bank_api.repository;

import com.skhola.bank_api.model.Icon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends BaseRepository<Icon, Long> {

    @Query(value = """
        SELECT * FROM (
            SELECT * FROM icon i
            WHERE i.icn_id IN (
                SELECT iu.isr_icn_id FROM icon_user iu WHERE iu.isr_usr_id = :userId
            )
            UNION
            SELECT * FROM icon i
            WHERE i.icn_id NOT IN (
                SELECT iu.isr_icn_id FROM icon_user iu WHERE iu.isr_usr_id = :userId
            )
        ) AS combined_icons
        ORDER BY RANDOM()
        LIMIT 10
        """, nativeQuery = true)
    List<Icon> findIconsForUser(@Param("userId") Long userId);

}
