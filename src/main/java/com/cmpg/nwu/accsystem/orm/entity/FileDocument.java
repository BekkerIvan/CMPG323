package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;

@Entity
@Table(name="FileDocument")
public class FileDocument extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(nullable = true, length = 100)
    public String FileName;

    @Column
    public String FilePath;

    @Column
    public int FileSize;

    @OneToOne(mappedBy = "FileDocument", orphanRemoval = true)
    public Company company;

    @OneToOne(mappedBy = "FileDocument", orphanRemoval = true)
    public Account account;


    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public int getFileSize() {
        return FileSize;
    }

    public void setFileSize(int fileSize) {
        FileSize = fileSize;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
