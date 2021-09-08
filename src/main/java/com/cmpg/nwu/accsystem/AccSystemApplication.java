package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccSystemApplication.class, args);
    }

    @Autowired
    public AccountRepository Repository;

    @GetMapping("/hello")
    public Long sayHello(@RequestParam(value = "length", defaultValue = "1") String StringLengthInt)  {
        return Repository.count();
    }
}
