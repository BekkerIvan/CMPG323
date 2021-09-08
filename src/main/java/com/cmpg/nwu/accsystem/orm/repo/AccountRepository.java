package com.cmpg.nwu.accsystem.orm.repo;

import com.cmpg.nwu.accsystem.orm.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
