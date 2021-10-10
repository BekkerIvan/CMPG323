package com.cmpg.nwu.accsystem.orm.repo;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.MilesAccount;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * FROM Account WHERE Username = ?1", nativeQuery = true)
    Account findByUsername(String UsernameStr);

    @Query(value = "SELECT * FROM Account WHERE IdNumber = ?1", nativeQuery = true)
    Account findByIdNumber(String IdNumberStr);
}
