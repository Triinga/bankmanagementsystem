package com.tringa.bankmanagementsystem.controller;

import com.tringa.bankmanagementsystem.model.Account;
import com.tringa.bankmanagementsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    public String showAccounts(Model model) {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "accounts"; // This will resolve to accounts.html
    }

}
