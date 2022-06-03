package com.engineeringwithramaa.fixeddepositmaturitymarker.config;

import com.engineeringwithramaa.fixeddepositmaturitymarker.batch.FixedDepositAccountDBWriter;
import com.engineeringwithramaa.fixeddepositmaturitymarker.batch.FixedDepositAccountReader;
import com.engineeringwithramaa.fixeddepositmaturitymarker.batch.FixedDepositAccountCSVWriter;
import com.engineeringwithramaa.fixeddepositmaturitymarker.batch.FixedDepositMaturityMarkerProcessor;
import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    FixedDepositAccountReader fixedDepositAccountReader;
    @Autowired
    FixedDepositMaturityMarkerProcessor fixedDepositMaturityMarkerProcessor;
    @Autowired
    FixedDepositAccountDBWriter fixedDepositAccountDBWriter;


    @Bean
    public Step fixedDepositAccountStep() {
        return stepBuilderFactory.get("Fixed Deposit Account Step")
                .<FixedDepositAccount, FixedDepositAccount> chunk(10)
                .reader(fixedDepositAccountReader)
                .processor(fixedDepositMaturityMarkerProcessor)
                .writer(fixedDepositAccountDBWriter)
                .build();
    }

    @Bean
    public Job fixedDepositAccountJob() {
        return jobBuilderFactory.get("Fixed Deposit Account Job")
                .start(fixedDepositAccountStep())
                .build();
    }
}
