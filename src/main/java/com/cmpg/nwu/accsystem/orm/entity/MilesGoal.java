package com.cmpg.nwu.accsystem.orm.entity;
import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MilesGoal")
public class MilesGoal extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(columnDefinition = "BOOLEAN DEFAULT 0")
    public Boolean IsCompleted;

    @Column(columnDefinition = "TEXT")
    public String GoalDescription;

    @Column()
    public Date StartDate;

    @Column()
    public Date EndDate;

    @ManyToOne
    @JoinColumn(name = "MilesAccount", referencedColumnName = "Id")
    public MilesAccount MilesAccount;
}
