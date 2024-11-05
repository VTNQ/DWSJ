package com.dwsj.mvc.Entities;

import java.time.LocalDate;


public class TransactionDetailDto {
    private Integer id;
    private  Double transMoney;
    private  Integer transType;




    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int idAccount;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTransMoney(Double transMoney) {
        this.transMoney = transMoney;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public TransactionDetailDto() {
    }



    public Integer getId() {
        return id;
    }

    public Double getTransMoney() {
        return transMoney;
    }

    public Integer getTransType() {
        return transType;
    }


}