package com.dwsj.api.DTOs;

import java.time.LocalDate;

public class TransactionList {
    private Integer id;
    private Double transMoney;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTransMoney(Double transMoney) {
        this.transMoney = transMoney;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    private  Integer transType;
    private LocalDate dateOfTrans;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    private  int idAccount;

    public TransactionList() {
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

    public void setDateOfTrans(LocalDate dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

    public LocalDate getDateOfTrans() {
        return dateOfTrans;
    }
}
