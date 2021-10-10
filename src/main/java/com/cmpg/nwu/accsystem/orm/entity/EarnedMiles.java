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

    public float getMilesEarned() {
        return MilesEarned;
    }

    public void setMilesEarned(float milesEarned) {
        MilesEarned = milesEarned;
    }

    public Timestamp getDateEarned() {
        return DateEarned;
    }

    public void setDateEarned(Timestamp dateEarned) {
        DateEarned = dateEarned;
    }

    public com.cmpg.nwu.accsystem.orm.entity.MilesAccount getMilesAccount() {
        return MilesAccount;
    }

    public void setMilesAccount(com.cmpg.nwu.accsystem.orm.entity.MilesAccount milesAccount) {
        MilesAccount = milesAccount;
    }
}
