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
}
