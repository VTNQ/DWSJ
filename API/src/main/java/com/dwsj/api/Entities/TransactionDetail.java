package com.dwsj.api.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TransactionDetails")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "trans_money", nullable = false)
    private Double transMoney;

    @Column(name = "trans_type", nullable = false)
    private Integer transType;

    @Column(name = "date_of_trans", nullable = false)
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