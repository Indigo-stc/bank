package com.skhola.bank_api.controller;

import com.skhola.bank_api.model.AnswerUser;
import com.skhola.bank_api.model.IconUser;
import com.skhola.bank_api.repository.IconUserRepository;
import com.skhola.bank_api.service.BaseService;
import com.skhola.bank_api.service.IconUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/isr")
public class IconUserCtrl extends BaseCtrlImpl<IconUser, Long> {

    @Autowired
    private IconUserService service;

    protected IconUserCtrl(BaseService<IconUser, Long> baseService) {
        super(baseService);
    }

    @PostMapping("/exists")
    public ResponseEntity<?> checkIfAnswerUserExists(@RequestBody IconUser iconUser) {
        return ResponseEntity.ok(service.existsByUserAndIcon(iconUser));
    }

}
