package com.skhola.bank_api.controller;

import com.skhola.bank_api.model.Icon;
import com.skhola.bank_api.service.BaseService;
import com.skhola.bank_api.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconCtrl extends BaseCtrlImpl<Icon, Long> {

    @Autowired
    private IconService service;

    protected IconCtrl(BaseService<Icon, Long> baseService) {
        super(baseService);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadIcon(@RequestParam("file") MultipartFile file) throws IOException {
        Icon icon = new Icon();
        icon.setData(file.getBytes());
        Icon saved = service.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Icon>> getIconsForUser(@PathVariable Long userId) {
        List<Icon> icons = service.findIconsForUser(userId);
        return ResponseEntity.ok(icons);
    }

}
