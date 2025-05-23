package com.skhola.bank_api.controller;

import com.skhola.bank_api.model.Question;
import com.skhola.bank_api.service.BaseService;
import com.skhola.bank_api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionCtrl extends BaseCtrlImpl<Question, Long> {

    @Autowired
    private QuestionService service;

    public QuestionCtrl(BaseService<Question, Long> baseService) {
        super(baseService);
    }
    
}
