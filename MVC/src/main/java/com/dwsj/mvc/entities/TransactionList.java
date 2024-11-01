package com.dwsj.mvc.entities;

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
    private String dateOfTrans;

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

    public void setDateOfTrans(String dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

    public String getDateOfTrans() {
        return dateOfTrans;
    }
}
