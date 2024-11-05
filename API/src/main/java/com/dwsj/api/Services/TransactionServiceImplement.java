package com.dwsj.api.Services;

import com.dwsj.api.DTOs.TransactionDetailDto;
import com.dwsj.api.DTOs.TransactionList;
import com.dwsj.api.Entities.Account;
import com.dwsj.api.Entities.TransactionDetail;
import com.dwsj.api.Reponsitories.TransactionDetailRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImplement implements TransactionService {
    @Autowired
    private TransactionDetailRepository transactionDetailRepository;
    @Autowired
    private ModelMapper modelMap;

    @Override
    public boolean isCorrect(TransactionDetailDto detail, Account account) {
        try {
            if(account.getBalance()-detail.getTransMoney()<0){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addTransaction(TransactionDetailDto detail, Account account) {
        try {
            detail.setDateOfTrans(LocalDate.now());
            TransactionDetail transactionDetail = modelMap.map(detail, TransactionDetail.class);
            transactionDetailRepository.save(transactionDetail);
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

    @Override
    public List<TransactionList> findAll(int id) {
        return modelMap.map(transactionDetailRepository.findByTransfer(id),
                new TypeToken<List<TransactionList>>() {}.getType());
            }

    @Override
    public List<TransactionList> filterTranferType(int id, int tranferType) {
        return modelMap.map(transactionDetailRepository.filterTransferMoney(id,tranferType),
                new TypeToken<List<TransactionList>>() {}.getType());

    }
}
