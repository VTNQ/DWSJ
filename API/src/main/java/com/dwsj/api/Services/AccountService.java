package com.dwsj.api.Services;

import com.dwsj.api.DTOs.AccountDto;
import com.dwsj.api.Entities.Account;

public interface AccountService {
    public Account login(String email, String password);
    public boolean register(AccountDto account);
    public boolean updateAccount(Account account);
    public  boolean UpdateProfile(Account accountDto);
    public Account findById(int id);
    public  Account find(int id);
}
