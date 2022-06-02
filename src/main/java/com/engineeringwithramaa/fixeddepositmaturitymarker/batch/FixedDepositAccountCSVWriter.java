package com.engineeringwithramaa.fixeddepositmaturitymarker.batch;

import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FixedDepositAccountCSVWriter extends FlatFileItemWriter<FixedDepositAccount> {
    public FixedDepositAccountCSVWriter(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = sdf.format(new Date());

        setResource(new FileSystemResource("data/csv-export-"+stringDate+".csv"));
        setLineAggregator(getDelimitedLineAggregator());
        setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("id, accNo, accHolderName, fdBondNumber, fdStartDate," +
                       " fdMaturityDate, depositAmount, interestRate, matured");
            }
        });
        setFooterCallback(new FlatFileFooterCallback() {
            @Override
            public void writeFooter(Writer writer) throws IOException {
                writer.write("EOF - File Auto-generated on " + stringDate );
            }
        });
    }
    public DelimitedLineAggregator<FixedDepositAccount> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<FixedDepositAccount> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<FixedDepositAccount>();
        beanWrapperFieldExtractor.setNames(new String[] {"id","accNo","accHolderName","fdBondNumber",
                "fdStartDate","fdMaturityDate","depositAmount","interestRate","matured"});

        DelimitedLineAggregator<FixedDepositAccount> delimitedLineAggregator = new DelimitedLineAggregator<FixedDepositAccount>();
        delimitedLineAggregator.setDelimiter(",");
        delimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
        return delimitedLineAggregator;

    }
}
