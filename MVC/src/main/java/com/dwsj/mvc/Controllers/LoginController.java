package com.dwsj.mvc.Controllers;

import com.dwsj.mvc.Entities.Account;
import com.dwsj.mvc.Entities.AccountDto;
import com.dwsj.mvc.Services.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping({"Login","","/"})
public class LoginController {
    @Autowired
    private AccountService accountService;
    @GetMapping({"","/","index"})
    public  String Login(ModelMap modelMap){
        modelMap.put("login",new AccountDto());
        return "Login/index";
    }
    @PostMapping("LoginPost")
    public String Login(@ModelAttribute("login")AccountDto accountDto, HttpServletRequest request){
        try {
            Account accountDto1=accountService.LoginAccount(accountDto);

            if(accountDto1!=null){
                request.getSession().setAttribute("currentAccount",accountDto1);
                return "redirect:/Home";
            }else{
                return "redirect:/Login";
            }
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
