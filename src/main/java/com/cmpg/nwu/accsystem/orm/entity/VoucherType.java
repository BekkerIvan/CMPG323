package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class VoucherType extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column
    public String VoucherType;

    @OneToMany(mappedBy = "VoucherType", orphanRemoval = true)
    private List<Voucher> Voucher;
}
