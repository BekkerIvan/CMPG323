package com.cmpg.nwu.accsystem.orm.repo;

import com.cmpg.nwu.accsystem.orm.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    @Query(value = "SELECT * FROM Voucher WHERE Id = ?1", nativeQuery = true)
    Voucher LoadById(Long Id);

    @Query(value = "SELECT * FROM Voucher WHERE Id = ?1", nativeQuery = true)
    Voucher LoadById(int Id);
}