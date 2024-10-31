package com.dwsj.api.Services;

import com.dwsj.api.DTOs.AccountDto;
import com.dwsj.api.Entities.Account;
import com.dwsj.api.Reponsitories.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean login(String email, String password) {
        try{
            accountRepository.findByEmail(email);
            BCrypt.checkpw(password, accountRepository.findByEmail(email).getPassword());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean register(Account account) {
        try {
            accountRepository.save(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateAccount(Account account) {
        try {
            accountRepository.save(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
