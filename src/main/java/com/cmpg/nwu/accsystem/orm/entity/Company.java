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
    private List<Voucher> Voucher;
}
