package com.dwsj.mvc.Controller;

import com.dwsj.mvc.entities.Account;
import com.dwsj.mvc.entities.SearchTransferType;
import com.dwsj.mvc.entities.TransactionDetailDto;
import com.dwsj.mvc.services.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller()
@RequestMapping({"","/"})
public class HomeController {
    @Autowired
    private AccountService accountService;
    @GetMapping("Home")
    public String Home(HttpServletRequest request, ModelMap modelMap){
        Account currentAccount=(Account)request.getSession().getAttribute("currentAccount");

        if(currentAccount!=null) {
            modelMap.addAttribute("account", currentAccount);
        }
        return "Home/index";
    }
    @GetMapping("EditAccount/{id}")
    public String EditAccount(@PathVariable("id")int id,ModelMap modelMap,HttpServletRequest request){
        Account currentAccount=(Account)request.getSession().getAttribute("currentAccount");
        if(currentAccount!=null) {
            modelMap.addAttribute("account", currentAccount);
        }
        modelMap.put("EditAccount",accountService.FindById(id));
        return "Home/EditAccount";
    }
    @PostMapping("UpdateAccount")
    public String UpdateAccount(@ModelAttribute("EditAccount")Account account){
        if(accountService.UpdateProfile(account)){
            return "redirect:/EditAccount/"+account.getId();
        }else{
            return "redirect:/EditAccount/"+account.getId();
        }
    }
    @GetMapping("FilterTranferType/{id}")
    public  String FilterTranferType(HttpServletRequest request, @PathVariable("id") int id, @ModelAttribute("TranferType")SearchTransferType searchTransferType,ModelMap modelMap){
        Account currentAccount=(Account)request.getSession().getAttribute("currentAccount");
        if(currentAccount!=null) {
            modelMap.addAttribute("account", currentAccount);
        }
        TransactionDetailDto transactionDetailDto=new TransactionDetailDto();
        transactionDetailDto.setIdAccount(currentAccount.getId());


        modelMap.put("Transaction",transactionDetailDto);
        modelMap.put("tranfer",accountService.FilterTranferType(currentAccount.getId(),searchTransferType));
        return "Home/Transaction";
    }
    @GetMapping("Home/Transaction")
    public  String getTransaction(HttpServletRequest request, ModelMap modelMap){
        Account currentAccount=(Account)request.getSession().getAttribute("currentAccount");
        modelMap.put("tranfer",accountService.findAll(currentAccount.getId()));
        if(currentAccount!=null) {
            modelMap.addAttribute("account", currentAccount);
        }
        TransactionDetailDto transactionDetailDto=new TransactionDetailDto();
        transactionDetailDto.setIdAccount(currentAccount.getId());
        modelMap.put("TranferType",new SearchTransferType());
        modelMap.put("Transaction",transactionDetailDto);
        return "Home/Transaction";
    }
    @PostMapping("AddTransaction")
    public String AddTransaction(@ModelAttribute("Transaction") TransactionDetailDto transactionDetailDto, HttpServletRequest request, ModelMap modelMap) {
        // Attempt to add the transaction
        boolean transactionSuccessful = accountService.AddTransaction(transactionDetailDto);

        // Retrieve the current account from the session
        HttpSession session = request.getSession();
        Account currentAccount = (Account) session.getAttribute("currentAccount");

        if (transactionSuccessful) {
            // Fetch the updated account details from the service
            currentAccount = accountService.FindById(transactionDetailDto.getIdAccount());
            // Update the session with the current account
            session.setAttribute("currentAccount", currentAccount);
        }

        // Redirect to the Transaction page
        return "redirect:/Home/Transaction";
    }
}
