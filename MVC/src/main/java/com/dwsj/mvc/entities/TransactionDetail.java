package com.dwsj.mvc.entities;

import java.time.LocalDate;


public class TransactionDetail {

    private Integer id;


    private Account account;


    private Double transMoney;


    private Integer transType;


    private LocalDate dateOfTrans;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(Double transMoney) {
        this.transMoney = transMoney;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public LocalDate getDateOfTrans() {
        return dateOfTrans;
    }

    public void setDateOfTrans(LocalDate dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

}