package com.skhola.bank_api.service;

import com.skhola.bank_api.exception.ResourceNotFoundException;
import com.skhola.bank_api.model.AnswerUser;
import com.skhola.bank_api.model.Icon;
import com.skhola.bank_api.model.Question;
import com.skhola.bank_api.model.User;
import com.skhola.bank_api.repository.AnswerUserRepository;
import com.skhola.bank_api.repository.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerUserServiceImpl extends BaseServiceImpl<AnswerUser, Long> implements AnswerUserService {

    @Autowired
    private AnswerUserRepository repository;

    public AnswerUserServiceImpl(BaseRepository<AnswerUser, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public Question getRandomQuestionForUser(Long id) {
        Optional<AnswerUser> answerUser = repository.findRandomByUserId(id);
        if (answerUser.isEmpty()) {
            throw new ResourceNotFoundException("Record not found with ID: " + id);
        }
        return answerUser.get().getQuestion();
    }

    @Transactional
    public Boolean existsByUserAndQuestionAndAnswer(AnswerUser answerUser) {
        return repository.existsByUserAndQuestionAndAnswer(
                answerUser.getUser(),
                answerUser.getQuestion(),
                answerUser.getAnswer()
        );
    }
}
