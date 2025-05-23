package com.skhola.bank_api.repository;

import com.skhola.bank_api.model.AnswerUser;
import com.skhola.bank_api.model.Icon;
import com.skhola.bank_api.model.Question;
import com.skhola.bank_api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerUserRepository extends BaseRepository<AnswerUser, Long> {

    @Query(value = "SELECT * FROM answer_user WHERE anw_usr_id = :id ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<AnswerUser> findRandomByUserId(@Param("id") Long id);

    Optional<AnswerUser> findByUserAndQuestionAndAnswerAndIcon(
            User user, Question question, String answer, Icon icon);

}
