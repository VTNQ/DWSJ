package com.dwsj.mvc.Services;

import com.dwsj.mvc.Entities.*;


import java.util.List;

public interface AccountService {
    public boolean RegisterAccount(AccountDto accountDto);
    public Account LoginAccount(AccountDto accountDto);
    public  boolean AddTransaction(TransactionDetailDto transactionDetailDto);
    public Account FindById(int id);
    public List<TransactionList>findAll(int id);
    public  List<TransactionList>FilterTranferType(int id, SearchTransferType searchTransferType);
    public boolean UpdateProfile(Account account);
}
