package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.EarnedMiles;
import com.cmpg.nwu.accsystem.orm.entity.MilesAccount;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
public class EarnedMilesTest {
    EarnedMiles TestEarnedMilesObj;

    @Before
    public void setUp() throws Exception {
        TestEarnedMilesObj = new EarnedMiles();
    }


    @Test
    public void MilesEarned() {
        TestEarnedMilesObj.setMilesEarned(12.5f);
        assert TestEarnedMilesObj.getMilesEarned() == 12.5f;
    }

    @Test
    public void DateEarned() {
        Timestamp TestCurrentTimeStamp = new Timestamp(System.currentTimeMillis());
        TestEarnedMilesObj.setDateEarned(TestCurrentTimeStamp);
        assert TestEarnedMilesObj.getDateEarned().equals(TestCurrentTimeStamp);
    }

    @Test
    public void MilesAccount() {
        TestEarnedMilesObj.setMilesAccount(new MilesAccount());
        assert TestEarnedMilesObj.getMilesAccount().getClass().getSimpleName().equals("MilesAccount");
    }
}
