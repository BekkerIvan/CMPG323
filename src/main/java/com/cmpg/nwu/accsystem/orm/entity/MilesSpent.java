package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "MilesSpent")
public class MilesSpent extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    public Timestamp DateAccumulated;

    @Column()
    public float MilesSpent;

    @ManyToOne
    @JoinColumn(name = "MilesAccount", referencedColumnName = "Id")
    public MilesAccount MilesAccount;

    @ManyToOne
    @JoinColumn(name = "Voucher", referencedColumnName = "Id")
    public Voucher Voucher;
}
