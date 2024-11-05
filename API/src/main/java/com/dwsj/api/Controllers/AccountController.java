package com.dwsj.api.Controllers;

import com.dwsj.api.DTOs.AccountDto;
import com.dwsj.api.DTOs.TransactionDetailDto;
import com.dwsj.api.DTOs.TransactionList;
import com.dwsj.api.Entities.Account;
import com.dwsj.api.Entities.TransactionDetail;
import com.dwsj.api.Services.AccountService;
import com.dwsj.api.Services.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"","/"})
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/login",produces = MimeTypeUtils.APPLICATION_JSON_VALUE,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> login(@RequestBody AccountDto account) {
        try {

            return new ResponseEntity<Account>(accountService.login(account.getEmail(),account.getPassword()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "register",consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(@RequestBody AccountDto account) {
        try {
            account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
            return new ResponseEntity<>(new Object(){
                public boolean result=accountService.register(account);
            }, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("GetAllTransfer/{id}")
    public ResponseEntity<List<TransactionList>>GetAllTransfer(@PathVariable("id")int id){
        try {
            return new ResponseEntity<List<TransactionList>>(transactionService.findAll(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<TransactionList>>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "UpdateProfile",consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>Update(@RequestBody Account accountDto){
        try {
            return new ResponseEntity<Object>(new Object() {
                public boolean result =accountService.UpdateProfile(accountDto);
            }, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("filterTranfer/{id}")
    public  ResponseEntity<List<TransactionList>>filterTranfer(@PathVariable("id")int id,@RequestParam int tranferType){
        try {
            return new ResponseEntity<List<TransactionList>>(transactionService.filterTranferType(id,tranferType), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<TransactionList>>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/transaction/add")
    public ResponseEntity<Object> addTransaction(@RequestBody TransactionDetailDto transactionDetail) {
        if(transactionDetail.getTransType()==2){
            Account account=accountService.find(transactionDetail.getIdAccount());
            boolean result=transactionService.isCorrect(transactionDetail, account);
            if(result){
                account.setBalance(account.getBalance()-transactionDetail.getTransMoney());
                accountService.updateAccount(account);
                return new ResponseEntity<>(new Object(){
                    public boolean result=transactionService.addTransaction(transactionDetail, account);
                },HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else {
            if(transactionDetail.getTransMoney()<0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                Account account=accountService.find(transactionDetail.getIdAccount());
                account.setBalance(transactionDetail.getTransMoney()+account.getBalance());
                accountService.updateAccount(account);
                return new ResponseEntity<>(new Object() {
                    public boolean result = transactionService.addTransaction(transactionDetail, account);
                }, HttpStatus.OK);

            }
        }
    }
    @GetMapping("FindByid/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<Account>(accountService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findByTransType/{value}")
    public ResponseEntity<Object> findByTransType(@PathVariable("value") int transType, HttpServletRequest httpServletRequest) {
        try {
            return new ResponseEntity<>(new Object(){
                public boolean find = transactionService.findByTransType(transType, (Account) httpServletRequest.getSession().getAttribute("account"));
            }, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
