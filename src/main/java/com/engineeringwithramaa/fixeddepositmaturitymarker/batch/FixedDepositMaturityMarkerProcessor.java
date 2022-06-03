package com.engineeringwithramaa.fixeddepositmaturitymarker.batch;

import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FixedDepositMaturityMarkerProcessor implements ItemProcessor<FixedDepositAccount, FixedDepositAccount> {

    @Override
    public FixedDepositAccount process(FixedDepositAccount fdAccount) throws Exception {
        fdAccount.setMatured(true);
        //System.out.println(fdAccount.toString());
        return fdAccount;
    }
}
