package com.dwsj.api.Reponsitories;

import com.dwsj.api.Entities.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Integer> {
    @Query("from TransactionDetail t join Account a where a.balance>:TransMoney and a.email=:Email")
    public List<TransactionDetail> findByTransMoney(@Param("TransMoney") double TransMoney, @Param("Email") String Email);

    @Query("from TransactionDetail where transType=:Type")
    public List<TransactionDetail> findByTransType(@Param("Type") int Type);
}