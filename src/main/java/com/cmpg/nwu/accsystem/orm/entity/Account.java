package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;

import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    public String FirstName;

    public String LastName;

    @Column(unique = true, length = 13)
    public String IdNumber;

    @Column(nullable = true, length = 50)
    public String ContactNumber;

    @Column(nullable = true, length = 100)
    public String EmailAddress;

    @Column(nullable = true, length = 100)
    public String Username;

    @Column(nullable = true)
    public String Password;

    @Column(nullable = true, columnDefinition = "Boolean default 0")
    public Boolean IsActive;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FileDocument", referencedColumnName = "Id", nullable = true)
    public com.cmpg.nwu.accsystem.orm.entity.FileDocument FileDocument;

    public Account() {
        super();
    }
}




