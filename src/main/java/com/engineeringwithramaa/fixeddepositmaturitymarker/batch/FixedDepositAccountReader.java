package com.engineeringwithramaa.fixeddepositmaturitymarker.batch;

import com.engineeringwithramaa.fixeddepositmaturitymarker.entity.FixedDepositAccount;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FixedDepositAccountReader
        extends JdbcCursorItemReader<FixedDepositAccount>
        implements ItemReader<FixedDepositAccount> {

    public FixedDepositAccountReader(@Autowired DataSource dataSource) {
        setDataSource(dataSource);
        setSql("SELECT * FROM `fixed_deposit_table` WHERE fdMaturityDate < CURDATE() and matured = 0;");
        setFetchSize(100);
        setRowMapper(new FixedDepositAccountRowMapper());
    }

    public class FixedDepositAccountRowMapper implements RowMapper<FixedDepositAccount> {
        @Override
        public FixedDepositAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
            FixedDepositAccount fdAccount  = new FixedDepositAccount();
            fdAccount.setId(rs.getInt("id"));
            fdAccount.setAccNo(rs.getString("accNo"));
            fdAccount.setAccHolderName(rs.getString("accHolderName"));
            fdAccount.setFdBondNumber(rs.getString("fdBondNumber"));
            fdAccount.setFdStartDate(rs.getDate("fdStartDate"));
            fdAccount.setFdMaturityDate(rs.getDate("fdMaturityDate"));
            fdAccount.setDepositAmount(rs.getInt("depositAmount"));
            fdAccount.setInterestRate(rs.getInt("interestRate"));
            fdAccount.setMatured(rs.getBoolean("matured"));
            return fdAccount;
        }

    }
}
