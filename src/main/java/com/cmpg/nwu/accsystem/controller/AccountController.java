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
    public AccountRepository AccountRepository;

    @GetMapping("/login")
    public Object loginAccount(@RequestParam(name = "username") String UsernameStr, @RequestParam(name = "password") String PasswordStr) {
        Account EnquiredAccount = AccountRepository.findByUsername(UsernameStr);
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
        Map<String, String> ReturnArr = ProjectFunction.initAPIMessage();
        Account NewAccountObj = new Account();

        if (ProjectFunction.validateIdNumber(IDNumberStr)) {
            NewAccountObj.IdNumber = IDNumberStr;
        } else {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "Invalid Id Number format given.");
            return ReturnArr;
        }
        if (ProjectFunction.validateEmailAddress(EmailStr)) {
            NewAccountObj.EmailAddress = EmailStr;
        } else {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "Invalid Email address format given.");
            return ReturnArr;
        }


        NewAccountObj.FirstName = FirstNameStr;
        NewAccountObj.LastName = LastNameStr;
        NewAccountObj.Username = UsernameStr == null || UsernameStr.length() == 0 ? EmailStr : UsernameStr;
        NewAccountObj.ContactNumber = ContactNumberStr == null || ContactNumberStr.length() == 0 ? EmailStr : ContactNumberStr;
        PasswordStr = PasswordStr == null || PasswordStr.length() == 0 ? ProjectFunction.generateRandomString(5) + FirstNameStr + LastNameStr + ProjectFunction.generateRandomString(5) : PasswordStr;
        NewAccountObj.Password = ProjectFunction.hashPassword(PasswordStr);
        NewAccountObj.IsActive = true;

        try {
            Account ExistingIdNumberAccountObj = AccountRepository.findByIdNumber(NewAccountObj.IdNumber);
            Account ExistingUsernameAccountObj = AccountRepository.findByUsername(NewAccountObj.Username);
            if (ExistingIdNumberAccountObj != null || ExistingUsernameAccountObj != null) {
                ProjectFunction.setAPIOutput(ReturnArr, false);
                ProjectFunction.setAPIValue(ReturnArr, "Message", "User already exists with given information");
                return ReturnArr;
            }

            AccountRepository.save(NewAccountObj);
            ProjectFunction.setAPIOutput(ReturnArr, true);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "Username : " + NewAccountObj.Username + "   " + "Password: " + PasswordStr);
            return ReturnArr;
        } catch (Exception ExceptionObj) {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "Error saving new Account : " + ExceptionObj.getMessage());
            return ReturnArr;
        }
    }
}
