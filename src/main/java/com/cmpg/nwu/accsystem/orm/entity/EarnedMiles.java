package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EarnedMiles")
public class EarnedMiles extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column()
    public int MilesEarned;

    @Column(columnDefinition = "DATE DEFAULT CURDATE()")
    public Date DateEarned;

    @ManyToOne()
    @JoinColumn(name = "MilesAccount", referencedColumnName = "Id")
    public MilesAccount MilesAccount;
}
