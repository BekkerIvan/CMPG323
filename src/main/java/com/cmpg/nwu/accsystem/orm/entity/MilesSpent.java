package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MilesSpent")
public class MilesSpent extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column()
    public Date DateAccumulated;

    @ManyToOne
    @JoinColumn(name = "MilesAccount", referencedColumnName = "Id")
    public MilesAccount MilesAccount;

    @ManyToOne
    @JoinColumn(name = "Voucher", referencedColumnName = "Id")
    public Voucher Voucher;
}
