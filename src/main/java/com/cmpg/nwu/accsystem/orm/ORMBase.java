package com.cmpg.nwu.accsystem.orm;

import com.cmpg.nwu.accsystem.orm.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;

public class ORMBase {
    public static String EntityNameStr;
    public static EntityManager EntityManager;
    public static EntityManagerFactory EntityManagerFactoryObj;

    public ORMBase() {
        EntityNameStr = this.getClass().getName();
        setEntityName(EntityNameStr);
    }

    public static String getEntityName() {
        String[] EntityNameArr = EntityNameStr.split("\\.");
        int ArrayLengthInt = EntityNameArr.length;
        return EntityNameArr[ArrayLengthInt - 1];
    }

    public static void setEntityName(String entityNameStr) {
        EntityNameStr = entityNameStr;
    }

    public static String getRawEntityName() {
        return EntityNameStr;
    }

    public static <T> List<T> Load(Long Id) {

        return new ArrayList<T>();
    }
}
