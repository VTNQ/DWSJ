package com.dwsj.api.Services;

import com.dwsj.api.DTOs.AccountDto;
import com.dwsj.api.Entities.Account;
import com.dwsj.api.Reponsitories.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Account login(String email, String password) {
        try{
         Account account=   accountRepository.findByEmail(email);
          if(account!=null &&     BCrypt.checkpw(password,account.getPassword())){
             return  account;
          }
          return  null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean register(AccountDto account) {
        try {
            Account account1=modelMapper.map(account,Account.class);
            accountRepository.save(account1);
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

    @Override
    public boolean UpdateProfile(Account accountDto) {
        try {
            Account account1=modelMapper.map(accountDto,Account.class);
            accountRepository.save(account1);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Account findById(int id) {
        return modelMapper.map(accountRepository.findById(id).get(), Account.class);
    }

    @Override
    public Account find(int id) {
        return modelMapper.map(accountRepository.findById(id).get(), Account.class);
    }
}
