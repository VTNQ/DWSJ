package com.dwsj.api.DTOs;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.dwsj.api.Entities.TransactionDetail}
 */
public class TransactionDetailDto implements Serializable {
    private Integer id;
    private  Double transMoney;
    private  Integer transType;
    private  LocalDate dateOfTrans;

    public TransactionDetailDto() {
    }

    public TransactionDetailDto(Double transMoney, Integer transType, LocalDate dateOfTrans) {
        this.transMoney = transMoney;
        this.transType = transType;
        this.dateOfTrans = dateOfTrans;
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

    public LocalDate getDateOfTrans() {
        return dateOfTrans;
    }
}