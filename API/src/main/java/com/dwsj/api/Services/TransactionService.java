package com.dwsj.api.Services;

import com.dwsj.api.Entities.Account;
import com.dwsj.api.Entities.TransactionDetail;

public interface TransactionService {
    public boolean isCorrect(TransactionDetail detail, Account account);
    public boolean addTransaction(TransactionDetail detail, Account account);
    public boolean findByTransType(int transType, Account account);
}
