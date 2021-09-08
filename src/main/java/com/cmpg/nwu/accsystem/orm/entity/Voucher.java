package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Voucher extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column
    public String VoucherName;

    @Column(columnDefinition = "TEXT")
    public String VoucherDescription;

    @Column
    public int MilesCost;

    @Column
    public Date ExpiryDate;

    @Column(columnDefinition = "FLOAT DEFAULT 0")
    public double DiscountedPercentage;

    @ManyToOne
    @JoinColumn(name = "VoucherType", referencedColumnName = "Id")
    public VoucherType VoucherType;

    @ManyToOne
    @JoinColumn(name = "Company", referencedColumnName = "Id")
    public Company Company;

    @OneToMany(mappedBy = "Voucher", orphanRemoval = true)
    private List<MilesSpent> MilesSpent;
}
