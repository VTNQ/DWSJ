package com.dwsj.mvc.services;

import com.dwsj.mvc.entities.*;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;

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
