package com.dwsj.mvc.Entities;

public class ResultApi {
    private boolean result;
    private AccountDto account;  // New field to store AccountDto

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }
}
