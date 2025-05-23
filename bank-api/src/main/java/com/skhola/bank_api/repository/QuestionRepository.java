package com.skhola.bank_api.repository;

import com.skhola.bank_api.model.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends BaseRepository<Question, Long> {
}
