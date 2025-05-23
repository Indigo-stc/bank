package com.skhola.bank_api.service;

import com.skhola.bank_api.model.Question;
import com.skhola.bank_api.repository.BaseRepository;
import com.skhola.bank_api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl extends BaseServiceImpl<Question, Long> implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    public QuestionServiceImpl(BaseRepository<Question, Long> baseRepository) {
        super(baseRepository);
    }

}
