package com.dwsj.api.DTOs;

import java.io.Serializable;

/**
 * DTO for {@link com.dwsj.api.Entities.Account}
 */
public class AccountDto implements Serializable {
    private Integer id;
    private  String name;
    private  String email;
    private  String phone;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  Double balance;
    private String password;

    public AccountDto(String name, String email, String phone, Double balance) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public AccountDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Double getBalance() {
        return balance;
    }
}