package com.skhola.bank_api.service;

import com.skhola.bank_api.model.AnswerUser;
import com.skhola.bank_api.model.Question;

public interface AnswerUserService extends BaseService<AnswerUser, Long> {

    Question getRandomQuestionForUser(Long id);

    AnswerUser findByUserAndQuestionAndAnswerAndIcon(AnswerUser answerUser);

}
