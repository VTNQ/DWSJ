package com.dwsj.mvc.Controller;

import com.dwsj.mvc.entities.AccountDto;
import com.dwsj.mvc.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping({"","/"})
public class RegisterController {
    @Autowired
    private AccountService accountService;
@GetMapping("Register")
    public String Register(ModelMap modelMap){
    modelMap.put("AccountDTO",new AccountDto());
    return "Register/index";
}
@PostMapping("Register")
    public String Register(@ModelAttribute("AccountDTO") AccountDto accountDto){
    if(accountService.RegisterAccount(accountDto)){
        return "redirect:/Register";
    }else{
        return "redirect:/Register";

    }
}
}
