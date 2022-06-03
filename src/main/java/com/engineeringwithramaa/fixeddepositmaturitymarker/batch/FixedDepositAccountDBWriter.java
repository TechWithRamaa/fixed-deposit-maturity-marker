package com.engineeringwithramaa.fixeddepositmaturitymarker.batch;

import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import com.engineeringwithramaa.fixeddepositmaturitymarker.repository.FixedDepositAccountRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FixedDepositAccountDBWriter implements ItemWriter<FixedDepositAccount> {

    @Autowired
    FixedDepositAccountRepository fixedDepositAccountRepository;

    @Override
    public void write(List<? extends FixedDepositAccount> fdAccountList) throws Exception {
        System.out.println(fdAccountList);
        fixedDepositAccountRepository.saveAll(fdAccountList);
    }
}