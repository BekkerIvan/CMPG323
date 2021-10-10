package com.cmpg.nwu.accsystem;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.Company;
import com.cmpg.nwu.accsystem.orm.entity.FileDocument;
import com.cmpg.nwu.accsystem.orm.entity.Voucher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CompanyTest {
    Company TestCompanyObj;

    @Before
    public void setUp() throws Exception {
        TestCompanyObj = new Company();
    }

    @Test
    public void FileDocument() {
        TestCompanyObj.setFileDocument(new FileDocument());
        FileDocument TestFileDocumentObj = TestCompanyObj.getFileDocument();
        assert TestFileDocumentObj.getClass().getSimpleName().equals("FileDocument");
    }

    @Test
    public void Voucher() {
        List<Voucher> TestVoucherList = new ArrayList<Voucher>();
        TestVoucherList.add(new Voucher());
        TestCompanyObj.setVoucher(TestVoucherList);
        List<Voucher> Voucher = TestCompanyObj.getVoucher();
        assert Voucher.size() == 1;
    }

    @Test
    public void CompanyName() {
        TestCompanyObj.setCompanyName("TestCo");
        String CompanyNameStr = TestCompanyObj.getCompanyName();
        assert CompanyNameStr.equals("TestCo");
    }


}
