package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.FileDocument;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class AccountEntityTest {
    Account TestAccount;

    @Before
    public void setUp() throws Exception {
        TestAccount = new Account();
    }

    @Test
    public void FirsName() {
        TestAccount.setFirstName("Test");
        String TestFirstNameStr = TestAccount.getFirstName();
        assert Objects.equals(TestFirstNameStr, "Test");
    }

    @Test
    public void LastName() {
        TestAccount.setLastName("Test");
        String TestlastNameStr = TestAccount.getLastName();
        assert Objects.equals(TestlastNameStr, "Test");
    }

    @Test
    public void IdNumber() {
        TestAccount.setIdNumber("7010240128084");
        String TestIdeNumberStr = TestAccount.getIdNumber();
        assert Objects.equals(TestIdeNumberStr, "7010240128084");
    }

    @Test
    public void ContactNumber() {
        TestAccount.setContactNumber("0123456798");
        String TestContactNumberStr = TestAccount.getContactNumber();
        assert Objects.equals(TestContactNumberStr, "0123456798");
    }

    @Test
    public void EmailAddress() {
        TestAccount.setEmailAddress("Unit.Test@test.com");
        String TestEmailAddressStr = TestAccount.getEmailAddress();
        assert Objects.equals(TestEmailAddressStr, "Unit.Test@test.com");
    }

    @Test
    public void Username() {
        TestAccount.setUsername("Unit.Test@test.com");
        String TestUsernameStr = TestAccount.getUsername();
        assert Objects.equals(TestUsernameStr, "Unit.Test@test.com");
    }

    @Test
    public void Password() {
        TestAccount.setPassword("Unit.Test@test.com");
        String TestPasswordStr = TestAccount.getPassword();
        assert Objects.equals(TestPasswordStr, "Unit.Test@test.com");
    }

    @Test
    public void isActive() {
        TestAccount.setActive(true);
        Boolean TestIsActiveBool = TestAccount.getActive();
        assert TestIsActiveBool;
    }

    @Test
    public void FileDocument() {
        TestAccount.setFileDocument(new FileDocument());
        FileDocument TestFileDocumentObj = TestAccount.getFileDocument();
        assert TestFileDocumentObj.getClass().getSimpleName().equals("FileDocument");
    }
}
