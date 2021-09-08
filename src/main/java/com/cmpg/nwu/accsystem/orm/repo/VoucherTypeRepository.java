package com.cmpg.nwu.accsystem.orm.repo;

import com.cmpg.nwu.accsystem.orm.entity.VoucherType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeRepository extends CrudRepository<VoucherType, Long> {
}