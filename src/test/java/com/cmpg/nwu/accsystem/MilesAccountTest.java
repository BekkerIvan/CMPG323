package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.MilesAccount;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MilesAccountTest {

    MilesAccount TestMilesAccountObj;

    @Before
    public void setUp() throws Exception {
        TestMilesAccountObj = new MilesAccount();
    }

    @Test
    public void TotalMilesEarned() {
        TestMilesAccountObj.setTotalMilesEarned(1500);
        assert TestMilesAccountObj.getTotalMilesEarned() == 1500;
    }
}
