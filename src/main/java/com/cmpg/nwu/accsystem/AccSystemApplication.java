package com.cmpg.nwu.accsystem;


import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.repo.AccountRepository;
import com.cmpg.nwu.accsystem.project_functions.ProjectFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class AccSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccSystemApplication.class, args);
    }

    @Autowired
    public AccountRepository Repository;

    @GetMapping("/password/{username}/{password}")
    public String setPassword(@PathVariable(value = "username") String UsernameStr, @PathVariable(value = "password") String PasswordStr)  {
        Account accObj = Repository.findByUsername(UsernameStr);
        accObj.Password = ProjectFunction.hashPassword(PasswordStr);
        Repository.save(accObj);
        return accObj.Password;
    }
}
