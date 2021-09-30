package com.cmpg.nwu.accsystem.orm.entity;

import com.cmpg.nwu.accsystem.orm.ORMBase;
import com.cmpg.nwu.accsystem.orm.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Table(name = "Account")
public class Account extends ORMBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    public String FirstName = null;

    public String LastName = null;

    @Column(unique = true, length = 13)
    public String IdNumber = null;

    @Column(nullable = true, length = 50)
    public String ContactNumber;

    @Column(nullable = true, length = 100)
    public String EmailAddress;

    @Column(nullable = true, length = 100, unique = true)
    public String Username;

    @Column(nullable = true)
    public String Password;

    @Column(nullable = true, columnDefinition = "Boolean default 0")
    public Boolean IsActive;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FileDocument", referencedColumnName = "Id", nullable = true)
    public FileDocument FileDocument;


    public Account() {
        super();
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public com.cmpg.nwu.accsystem.orm.entity.FileDocument getFileDocument() {
        return FileDocument;
    }

    public void setFileDocument(com.cmpg.nwu.accsystem.orm.entity.FileDocument fileDocument) {
        FileDocument = fileDocument;
    }
}




