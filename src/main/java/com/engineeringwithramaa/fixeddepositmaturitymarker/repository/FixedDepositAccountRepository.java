package com.engineeringwithramaa.fixeddepositmaturitymarker.repository;

import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedDepositAccountRepository extends JpaRepository<FixedDepositAccount, Integer> {
}
