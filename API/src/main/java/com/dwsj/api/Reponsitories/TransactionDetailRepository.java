package com.dwsj.api.Reponsitories;

import com.dwsj.api.DTOs.TransactionDetailDto;
import com.dwsj.api.Entities.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Integer> {
    @Query("select t from TransactionDetail t join t.account a where a.balance > :transMoney and a.email = :email")
    public List<TransactionDetail> findByTransMoney(@Param("transMoney") double transMoney, @Param("email") String email);
    @Query("from TransactionDetail t where t.account.id = :id")
    public List<TransactionDetail> findByTransfer(@Param("id") int id);
    @Query("from TransactionDetail  t where t.account.id = :id and t.transType = :transfertype")
    public  List<TransactionDetail> filterTransferMoney(@Param("id") int id, @Param("transfertype") int transfertype);

    @Query("from TransactionDetail where transType=:Type")
    public List<TransactionDetail> findByTransType(@Param("Type") int Type);
}