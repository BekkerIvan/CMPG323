package com.cmpg.nwu.accsystem.controller;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.repo.AccountRepository;
import com.cmpg.nwu.accsystem.project_functions.ProjectFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {
    @Autowired
    public AccountRepository Repository;

    @GetMapping("/login")
    public Object loginAccount(@RequestParam(name = "username") String UsernameStr, @RequestParam(name = "password") String PasswordStr) {
        Account EnquiredAccount = Repository.findByUsername(UsernameStr);
        Map<String, String> ReturnArr = ProjectFunction.initAPIMessage();
        if (EnquiredAccount == null) {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "Could not log in, Either Password or Username was incorrect.");
            return ReturnArr;
        }

        if (ProjectFunction.verifyPassword(PasswordStr, EnquiredAccount.Password)) {
            ProjectFunction.setAPIOutput(ReturnArr, true);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "User successfully logged in.");
            return ReturnArr;
        }
        ProjectFunction.setAPIOutput(ReturnArr, false);
        ProjectFunction.setAPIValue(ReturnArr, "Message", "Could not log in, Either Password or Username was incorrect.");
        return ReturnArr;
    }

    @GetMapping("/createAccount")
    public Object createAccount(@RequestParam(name = "fname") String FirstNameStr,
                                @RequestParam(name = "lname") String LastNameStr,
                                @RequestParam(name = "password", required = false) String PasswordStr,
                                @RequestParam(name = "username", required = false) String UsernameStr,
                                @RequestParam(name = "email") String EmailStr,
                                @RequestParam(name = "contactnumber", required = false) String ContactNumberStr,
                                @RequestParam(name = "idnumber") String IDNumberStr) {

        Account NewAccountObj = new Account();
        NewAccountObj.FirstName = FirstNameStr;
        NewAccountObj.LastName = LastNameStr;
        NewAccountObj.Username = UsernameStr == null ? EmailStr : UsernameStr;
        NewAccountObj.EmailAddress = EmailStr;
        NewAccountObj.ContactNumber = ContactNumberStr == null ? EmailStr : ContactNumberStr;
        NewAccountObj.IdNumber = IDNumberStr;
        PasswordStr = PasswordStr == null ? FirstNameStr + LastNameStr : PasswordStr;
        NewAccountObj.Password = ProjectFunction.hashPassword(PasswordStr);
        NewAccountObj.IsActive = true;
        try {
            Repository.save(NewAccountObj);
            return "Username : " + NewAccountObj.Username + "\n" + "Password: " + PasswordStr;
        } catch (Exception ExceptionObj) {
            return "Error saving new Account : " + ExceptionObj.getMessage();
        }
    }
}
