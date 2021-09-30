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

    @Column (nullable = false)
    public float MilesCost;

    @Column
    public Date ExpiryDate;

    @Column(columnDefinition = "FLOAT DEFAULT 0")
    public double DiscountedPercentage;

    @Column(columnDefinition = "BOOLEAN DEFAULT 0")
    public boolean Redeemed;

    @ManyToOne
    @JoinColumn(name = "VoucherType", referencedColumnName = "Id")
    public VoucherType VoucherType;

    @ManyToOne
    @JoinColumn(name = "Company", referencedColumnName = "Id")
    public Company Company;

    @OneToMany(mappedBy = "Voucher", orphanRemoval = true)
    private List<MilesSpent> MilesSpent;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getVoucherName() {
        return VoucherName;
    }

    public void setVoucherName(String voucherName) {
        VoucherName = voucherName;
    }

    public String getVoucherDescription() {
        return VoucherDescription;
    }

    public void setVoucherDescription(String voucherDescription) {
        VoucherDescription = voucherDescription;
    }

    public float getMilesCost() {
        return MilesCost;
    }

    public void setMilesCost(float milesCost) {
        MilesCost = milesCost;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public double getDiscountedPercentage() {
        return DiscountedPercentage;
    }

    public void setDiscountedPercentage(double discountedPercentage) {
        DiscountedPercentage = discountedPercentage;
    }

    public com.cmpg.nwu.accsystem.orm.entity.VoucherType getVoucherType() {
        return VoucherType;
    }

    public void setVoucherType(com.cmpg.nwu.accsystem.orm.entity.VoucherType voucherType) {
        VoucherType = voucherType;
    }

    public com.cmpg.nwu.accsystem.orm.entity.Company getCompany() {
        return Company;
    }

    public void setCompany(com.cmpg.nwu.accsystem.orm.entity.Company company) {
        Company = company;
    }

    public List<com.cmpg.nwu.accsystem.orm.entity.MilesSpent> getMilesSpent() {
        return MilesSpent;
    }

    public void setMilesSpent(List<com.cmpg.nwu.accsystem.orm.entity.MilesSpent> milesSpent) {
        MilesSpent = milesSpent;
    }
}
