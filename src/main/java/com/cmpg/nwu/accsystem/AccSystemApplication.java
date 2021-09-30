package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.ORMBase;
import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.Company;
import com.cmpg.nwu.accsystem.orm.entity.Voucher;
import com.cmpg.nwu.accsystem.orm.repo.AccountRepository;
import com.cmpg.nwu.accsystem.orm.repo.MilesAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.List;

@SpringBootApplication
@RestController
public class AccSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccSystemApplication.class, args);
    }

    @Autowired
    public AccountRepository Repository;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "length", defaultValue = "1") String StringLengthInt)  {
        String Teest = "";
        List<Account> test = Repository.findAll();
        for (Account test2: test) {
            Teest += "<br> "+test2.ContactNumber;
        }
        return Teest;
    }
}
