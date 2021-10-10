package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.project_functions.ProjectFunction;
import org.junit.*;
import org.springframework.util.Assert;
import java.util.Map;
import java.util.Objects;

public class ProjectFunctionTest {
    @Test
    public void hashPassword() {
        String hashPassword = ProjectFunction.hashPassword("TestPassword");
        assert hashPassword instanceof String;
//        assertThat();
    }

    @Test
    public void validatePassword() {
        String hashPassword = ProjectFunction.hashPassword("TestPassword");
        assert ProjectFunction.verifyPassword("TestPassword", hashPassword);
    }

    @Test
    public void generateRandomString() {
        String randomString = ProjectFunction.generateRandomString(12);
        assert randomString.length() == 12;
    }

    @Test
    public void typeOf() {
        Account testAccountObj = new Account();
        assert ProjectFunction.typeOf(testAccountObj).equals("com.cmpg.nwu.accsystem.orm.entity.Account");
    }

    @Test
    public void initAPIMessage() {
        Map<String, String> TestHashMap = ProjectFunction.initAPIMessage();
        assert ProjectFunction.typeOf(TestHashMap).equals("java.util.HashMap");
    }

    @Test
    public void setAPIOutputTrue() {
        Map<String, String> TestHashMap = ProjectFunction.initAPIMessage();
        ProjectFunction.setAPIOutput(TestHashMap, true);
        assert Objects.equals(TestHashMap.get("Success"), "true");
    }

    @Test
    public void setAPIOutputFalse() {
        Map<String, String> TestHashMap = ProjectFunction.initAPIMessage();
        ProjectFunction.setAPIOutput(TestHashMap, false);
        assert Objects.equals(TestHashMap.get("Success"), "false");
    }

    @Test
    public void setAPIValue() {
        Map<String, String> TestHashMap = ProjectFunction.initAPIMessage();
        ProjectFunction.setAPIValue(TestHashMap, "Unit", "Test");
        assert Objects.equals(TestHashMap.get("Unit"), "Test");
    }

    @Test
    public void validEmailAddress() {
        String ValidEmailAddressStr = "BarbraGibble578@gmail.com";
        assert ProjectFunction.validateEmailAddress(ValidEmailAddressStr);
    }

    @Test
    public void invalidEmailAddress() {
        String ValidEmailAddressStr = "BarbraGibble578@gmail";
        assert !ProjectFunction.validateEmailAddress(ValidEmailAddressStr);
    }

    @Test
    public void validIdNumber() {
        String ValidIdNumberStr = "7010240128084";
        assert ProjectFunction.validateIdNumber(ValidIdNumberStr);
    }

    @Test
    public void invalidIdNumber() {
        String ValidIdNumberStr = "7010240128083";
        assert !ProjectFunction.validateIdNumber(ValidIdNumberStr);
    }
}
