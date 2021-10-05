package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import org.junit.*;
import org.springframework.util.Assert;

public class ORMBaseTest {
    @Test
    public void getRawEntityName() {
        Account.setEntityName("Test");
        System.out.println();
        assert Account.getRawEntityName().equals("Test");
    }

    @Test
    public void setEntityName() {
        Account.setEntityName("Test");
        System.out.println();
        assert Account.getRawEntityName().equals("Test");
    }

    @Test
    public void getEntityName() {
        Account.setEntityName("Test");
        System.out.println();
        assert Account.getEntityName().equals("Test");
    }

}
