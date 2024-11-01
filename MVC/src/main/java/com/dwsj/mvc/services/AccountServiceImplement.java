package com.dwsj.mvc.services;

import com.dwsj.mvc.APIs.AccountApi;
import com.dwsj.mvc.APIs.ApiClient;
import com.dwsj.mvc.entities.*;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.util.List;

@Service
public class AccountServiceImplement implements AccountService{
    @Override
    public boolean RegisterAccount(AccountDto accountDto) {
        try{
            AccountApi accountApi= ApiClient.getRetrofit().create(AccountApi.class);
            Response<ResultApi> response=accountApi.register(accountDto).execute();
            if(response.isSuccessful()) {
                return response.body().isResult();
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account LoginAccount(AccountDto accountDto) {
        try {
            AccountApi accountApi=ApiClient.getRetrofit().create(AccountApi.class);
            Response<Account> response=accountApi.login(accountDto).execute();
            if(response.isSuccessful()) {
                return response.body();
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean AddTransaction(TransactionDetailDto transactionDetailDto) {
        try {
            AccountApi accountApi=ApiClient.getRetrofit().create(AccountApi.class);
            Response<ResultApi>response=accountApi.AddTransaction(transactionDetailDto).execute();
            if(response.isSuccessful()) {
                return response.body().isResult();
            }else {
                return false;
            }
        }catch (Exception e){

            return false;
        }
    }

    @Override
    public Account FindById(int id) {
        try {
            AccountApi accountApi=ApiClient.getRetrofit().create(AccountApi.class);
            Response<Account> response=accountApi.findByid(id).execute();
            if(response.isSuccessful()) {
                return response.body();
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TransactionList> findAll(int id) {
        try{
            AccountApi courseApi=ApiClient.getRetrofit().create(AccountApi.class);
            Response<List<TransactionList>> response=courseApi.findAll(id).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TransactionList> FilterTranferType(int id, SearchTransferType searchTransferType) {
        try{
            AccountApi courseApi=ApiClient.getRetrofit().create(AccountApi.class);
            Response<List<TransactionList>> response=courseApi.filterTranfer(id,searchTransferType.getTransferType()).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean UpdateProfile(Account account) {
        try {
            AccountApi accountApi=ApiClient.getRetrofit().create(AccountApi.class);
            Response<ResultApi>response=accountApi.UpdateProfile(account).execute();
            if(response.isSuccessful()) {
                return response.body().isResult();
            }else {
                return false;
            }
        }catch (Exception e){

            return false;
        }
    }
}

