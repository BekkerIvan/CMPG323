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

}
