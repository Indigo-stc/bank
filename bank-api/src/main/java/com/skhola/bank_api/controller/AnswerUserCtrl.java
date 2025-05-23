package com.skhola.bank_api.controller;

import com.skhola.bank_api.model.AnswerUser;
import com.skhola.bank_api.model.Question;
import com.skhola.bank_api.service.AnswerUserService;
import com.skhola.bank_api.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerUserCtrl extends BaseCtrlImpl<AnswerUser, Long> {

    @Autowired
    private AnswerUserService service;

    public AnswerUserCtrl(BaseService<AnswerUser, Long> baseService, AnswerUserService service) {
        super(baseService);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> getRandomQuestionForUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRandomQuestionForUser(id));
    }

    @PostMapping("/exists")
    public ResponseEntity<?> checkIfAnswerUserExists(@RequestBody AnswerUser answerUser) {
        AnswerUser exists = service.findByUserAndQuestionAndAnswerAndIcon(answerUser);
        return ResponseEntity.ok(exists);
    }

}
