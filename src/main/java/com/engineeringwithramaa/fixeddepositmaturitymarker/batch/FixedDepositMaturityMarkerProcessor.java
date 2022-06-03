package com.engineeringwithramaa.fixeddepositmaturitymarker.batch;

import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FixedDepositMaturityMarkerProcessor implements ItemProcessor<FixedDepositAccount, FixedDepositAccount> {

    @Override
    public FixedDepositAccount process(FixedDepositAccount fdAccount) throws Exception {

        // Calculate Fixed Deposit Matured Amount using standarized formula
        // Adding 10000 just for simplicity
        int fixedDepositMaturedAmount = fdAccount.getDepositAmount() + 10000;

        // Updating Matured Amount and setting the flag Matured to TRUE
        fdAccount.setMaturedAmount(fixedDepositMaturedAmount);
        fdAccount.setMatured(true);

        return fdAccount;
    }
}
