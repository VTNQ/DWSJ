package com.dwsj.api.DTOs;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.dwsj.api.Entities.TransactionDetail}
 */
public class TransactionDetailDto {
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
    private  LocalDate dateOfTrans;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    private  int idAccount;

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

    public void setDateOfTrans(LocalDate dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

    public LocalDate getDateOfTrans() {
        return dateOfTrans;
    }
}