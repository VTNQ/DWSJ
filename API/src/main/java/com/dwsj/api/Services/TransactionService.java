package com.dwsj.api.Services;

import com.dwsj.api.DTOs.TransactionDetailDto;
import com.dwsj.api.DTOs.TransactionList;
import com.dwsj.api.Entities.Account;
import com.dwsj.api.Entities.TransactionDetail;

import java.util.List;

public interface TransactionService {
    public boolean isCorrect(TransactionDetailDto detail, Account account);
    public boolean addTransaction(TransactionDetailDto detail, Account account);
    public boolean findByTransType(int transType, Account account);
    public List<TransactionList>findAll(int id);
    public  List<TransactionList>filterTranferType(int id,int tranferType);
}
