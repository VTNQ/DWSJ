package com.dwsj.api.Reponsitories;

import com.dwsj.api.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("from Account where email=:Email")
    public Account findByEmail(String Email);
}