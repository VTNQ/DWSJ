package com.dwsj.mvc.APIs;

import com.dwsj.mvc.Entities.*;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AccountApi {
@POST("/register")
    Call<ResultApi>register(@Body AccountDto accountDto);
@POST("/login")
    Call<Account>login(@Body AccountDto accountDto);
@PUT("/transaction/add")
    Call<ResultApi>AddTransaction(@Body TransactionDetailDto transactionDetailDto) ;
    @GET("/FindByid/{id}")
    Call<Account>findByid(@Path("id") int id);
    @GET("/GetAllTransfer/{id}")
    Call<List<TransactionList>>findAll(@Path("id")int id);
    @GET("/filterTranfer/{id}")
    Call<List<TransactionList>> filterTranfer(
            @Path("id") int id,
            @Query("tranferType") int tranferType
    );
    @PUT("/UpdateProfile")
    Call<ResultApi>UpdateProfile(@Body Account accountDto);
}

