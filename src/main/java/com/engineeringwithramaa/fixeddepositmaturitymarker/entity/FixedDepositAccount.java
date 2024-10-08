package com.engineeringwithramaa.fixeddepositmaturitymarker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="fixed_deposit_table")
public class FixedDepositAccount {
    @Id
    private int id;
    private String accNo;
    private String accHolderName;
    private String fdBondNumber;
    private Date fdStartDate;
    private Date fdMaturityDate;
    private int depositAmount;
    private int interestRate;

    private int maturedAmount;
    private boolean matured;

    public FixedDepositAccount() {
    }

    public FixedDepositAccount(int id, String accNo, String accHolderName,
                               String fdBondNumber, Date fdStartDate,
                               Date fdMaturityDate, int depositAmount,
                               int interestRate, int maturedAmount, boolean matured) {
        this.id = id;
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.fdBondNumber = fdBondNumber;
        this.fdStartDate = fdStartDate;
        this.fdMaturityDate = fdMaturityDate;
        this.depositAmount = depositAmount;
        this.interestRate = interestRate;
        this.maturedAmount = maturedAmount;
        this.matured = matured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getFdBondNumber() {
        return fdBondNumber;
    }

    public void setFdBondNumber(String fdBondNumber) {
        this.fdBondNumber = fdBondNumber;
    }

    public Date getFdStartDate() {
        return fdStartDate;
    }

    public void setFdStartDate(Date fdStartDate) {
        this.fdStartDate = fdStartDate;
    }

    public Date getFdMaturityDate() {
        return fdMaturityDate;
    }

    public void setFdMaturityDate(Date fdMaturityDate) {
        this.fdMaturityDate = fdMaturityDate;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getMaturedAmount() { return maturedAmount;}

    public void setMaturedAmount(int maturedAmount) { this.maturedAmount = maturedAmount;}

    public boolean isMatured() {
        return matured;
    }

    public void setMatured(boolean matured) {
        this.matured = matured;
    }

    @Override
    public String toString() {
        return "FixedDepositAccount{" +
                "id=" + id +
                ", accNo='" + accNo + '\'' +
                ", accHolderName='" + accHolderName + '\'' +
                ", fdBondNumber='" + fdBondNumber + '\'' +
                ", fdStartDate='" + fdStartDate + '\'' +
                ", fdMaturityDate='" + fdMaturityDate + '\'' +
                ", depositAmount=" + depositAmount +
                ", interestRate=" + interestRate +
                ", maturedAmount=" + maturedAmount +
                ", matured=" + matured +
                '}';
    }
}
