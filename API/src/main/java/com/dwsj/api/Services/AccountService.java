package com.dwsj.api.Services;

import com.dwsj.api.DTOs.AccountDto;
import com.dwsj.api.Entities.Account;

public interface AccountService {
    public boolean login(String email, String password);
    public boolean register(Account account);
    public boolean updateAccount(Account account);
}
