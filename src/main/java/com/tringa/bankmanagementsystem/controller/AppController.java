package com.tringa.bankmanagementsystem.controller;

import com.tringa.bankmanagementsystem.model.Account;
import com.tringa.bankmanagementsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accountlist")
    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping("/newaccount")
    public Account addAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }
}
