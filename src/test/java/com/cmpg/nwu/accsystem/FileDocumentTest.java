package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.Company;
import com.cmpg.nwu.accsystem.orm.entity.EarnedMiles;
import com.cmpg.nwu.accsystem.orm.entity.FileDocument;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileDocumentTest {
    FileDocument TestFileDocumentObj;
    @Before
    public void setUp() throws Exception {
        TestFileDocumentObj = new FileDocument();
    }

    @Test
    public void FileName() {
        TestFileDocumentObj.setFileName("FileDocument.jpg");
        assert TestFileDocumentObj.getFileName().equals("FileDocument.jpg");
    }

    @Test
    public void FilePath() {
        TestFileDocumentObj.setFilePath("/var/www/html/AccSystem/assets/images/FileDocument.jpg");
        assert TestFileDocumentObj.getFilePath().equals("/var/www/html/AccSystem/assets/images/FileDocument.jpg");
    }

    @Test
    public void FileSize() {
        TestFileDocumentObj.setFileSize(15);
        assert TestFileDocumentObj.getFileSize() == 15;
    }

    @Test
    public void Company() {
        TestFileDocumentObj.setCompany(new Company());
        assert TestFileDocumentObj.getCompany().getClass().getSimpleName().equals("Company");
    }

    @Test
    public void Account() {
        TestFileDocumentObj.setAccount(new Account());
        assert TestFileDocumentObj.getAccount().getClass().getSimpleName().equals("Account");
    }
}
