package com.tringa.bankmanagementsystem.repository;

import com.tringa.bankmanagementsystem.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
