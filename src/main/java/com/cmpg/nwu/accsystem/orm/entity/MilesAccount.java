package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "MilesAccount")
public class MilesAccount extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(columnDefinition = "FLOAT DEFAULT 0")
    public float TotalMilesEarned;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURDATE()")
    public Date DateActive;

    @Column(nullable = true, columnDefinition = "Boolean default 0")
    public Boolean IsActive;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Account", referencedColumnName = "Id", nullable = true)
    public Account Account;

    @OneToMany(mappedBy = "MilesAccount", orphanRemoval = true)
    public List<MilesGoal> MilesGoal;

    @OneToMany(mappedBy = "MilesAccount")
    public List<EarnedMiles> EarnedMiles;

    @OneToMany(mappedBy = "MilesAccount")
    public List<MilesSpent> MilesSpent;

    public float getTotalMilesEarned() {
        return TotalMilesEarned;
    }

    public void setTotalMilesEarned(float totalMilesEarned) {
        TotalMilesEarned = totalMilesEarned;
    }

    public Date getDateActive() {
        return DateActive;
    }

    public void setDateActive(Date dateActive) {
        DateActive = dateActive;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public com.cmpg.nwu.accsystem.orm.entity.Account getAccount() {
        return Account;
    }

    public void setAccount(com.cmpg.nwu.accsystem.orm.entity.Account account) {
        Account = account;
    }

    public List<com.cmpg.nwu.accsystem.orm.entity.MilesGoal> getMilesGoal() {
        return MilesGoal;
    }

    public void setMilesGoal(List<com.cmpg.nwu.accsystem.orm.entity.MilesGoal> milesGoal) {
        MilesGoal = milesGoal;
    }

    public List<com.cmpg.nwu.accsystem.orm.entity.EarnedMiles> getEarnedMiles() {
        return EarnedMiles;
    }

    public void setEarnedMiles(List<com.cmpg.nwu.accsystem.orm.entity.EarnedMiles> earnedMiles) {
        EarnedMiles = earnedMiles;
    }

    public List<com.cmpg.nwu.accsystem.orm.entity.MilesSpent> getMilesSpent() {
        return MilesSpent;
    }

    public void setMilesSpent(List<com.cmpg.nwu.accsystem.orm.entity.MilesSpent> milesSpent) {
        MilesSpent = milesSpent;
    }
}
