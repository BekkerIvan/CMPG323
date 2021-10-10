package com.cmpg.nwu.accsystem.orm.repo;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import com.cmpg.nwu.accsystem.orm.entity.MilesAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface MilesAccountRepository extends JpaRepository<MilesAccount, Long> {
    @Query (value = "SELECT * FROM MilesAccount WHERE Id = ?1 AND IsActive = 1", nativeQuery = true)
    MilesAccount loadActiveMilesAccountById(Long Id);

    @Query (value = "SELECT * FROM MilesAccount WHERE Id = ?1 AND IsActive = 1", nativeQuery = true)
    MilesAccount loadActiveMilesAccountById(Integer Id);

}