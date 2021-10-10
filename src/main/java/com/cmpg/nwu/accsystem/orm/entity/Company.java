package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column
    public String CompanyName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FileDocument", referencedColumnName = "Id", nullable = true)
    public FileDocument FileDocument;

    @OneToMany(mappedBy = "Company", orphanRemoval = true)
    public List<Voucher> Voucher;

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public FileDocument getFileDocument() {
        return FileDocument;
    }

    public void setFileDocument(FileDocument fileDocument) {
        FileDocument = fileDocument;
    }

    public List<Voucher> getVoucher() {
        return Voucher;
    }

    public void setVoucher(List<Voucher> voucher) {
        Voucher = voucher;
    }
}
