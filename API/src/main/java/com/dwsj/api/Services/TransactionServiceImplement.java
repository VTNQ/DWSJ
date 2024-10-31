package com.dwsj.api.Services;

import com.dwsj.api.Entities.Account;
import com.dwsj.api.Entities.TransactionDetail;
import com.dwsj.api.Reponsitories.TransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImplement implements TransactionService {
    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    public boolean isCorrect(TransactionDetail detail, Account account) {
        try {
            transactionDetailRepository.findByTransMoney(detail.getTransMoney(),account.getEmail());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addTransaction(TransactionDetail detail, Account account) {
        try {
            transactionDetailRepository.save(detail);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean findByTransType(int transType, Account account) {
        try {
            transactionDetailRepository.findByTransType(transType);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
