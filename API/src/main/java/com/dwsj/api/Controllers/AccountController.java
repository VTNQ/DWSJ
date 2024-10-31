package com.dwsj.api.Controllers;

import com.dwsj.api.Entities.Account;
import com.dwsj.api.Entities.TransactionDetail;
import com.dwsj.api.Services.AccountService;
import com.dwsj.api.Services.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> login(@RequestBody Account account, HttpServletRequest httpServletRequest) {
        try {
            httpServletRequest.getSession().setAttribute("account", account);
            return new ResponseEntity<>(new Object(){
                public boolean result=accountService.login(account.getEmail(), account.getPassword());
            }, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Account account) {
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

    @PutMapping("/transaction/add")
    public ResponseEntity<Object> addTransaction(@RequestBody TransactionDetail transactionDetail, HttpServletRequest httpServletRequest) {
        if(transactionDetail.getTransType()==2){
            boolean result=transactionService.isCorrect(transactionDetail, (Account) httpServletRequest.getSession().getAttribute("account"));
            if(result){
                Account account=(Account)httpServletRequest.getSession().getAttribute("account");
                account.setBalance(account.getBalance()-transactionDetail.getTransMoney());
                accountService.updateAccount(account);
                return new ResponseEntity<>(new Object(){
                    public boolean result_min=transactionService.addTransaction(transactionDetail, account);
                },HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else {
            if(transactionDetail.getTransMoney()<0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                Account account=(Account)httpServletRequest.getSession().getAttribute("account");
                account.setBalance(transactionDetail.getTransMoney()+account.getBalance());
                accountService.updateAccount(account);
                return new ResponseEntity<>(new Object(){
                    public boolean result_add=transactionService.addTransaction(transactionDetail, account);
                },HttpStatus.OK);
            }
        }
    }

    @GetMapping("/findByTransType/{value}")
    public ResponseEntity<Object> findByTransType(@PathVariable("value") int transType, HttpServletRequest httpServletRequest) {

    }
}
