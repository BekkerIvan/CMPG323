package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "EarnedMiles")
public class EarnedMiles extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column()
    public float MilesEarned;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    public Timestamp DateEarned;

    @ManyToOne()
    @JoinColumn(name = "MilesAccount", referencedColumnName = "Id")
    public MilesAccount MilesAccount;
}
