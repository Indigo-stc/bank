package com.skhola.bank_api.controller;

import com.skhola.bank_api.model.User;
import com.skhola.bank_api.service.BaseService;
import com.skhola.bank_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserCtrl extends BaseCtrlImpl<User, Long> {

    @Autowired
    private UserService service;

    protected UserCtrl(BaseService<User, Long> baseService) {
        super(baseService);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        User user = service.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
    }

}
