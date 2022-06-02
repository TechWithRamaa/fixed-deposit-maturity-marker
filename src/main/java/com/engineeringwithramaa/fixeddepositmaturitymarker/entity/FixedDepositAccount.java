package com.engineeringwithramaa.fixeddepositmaturitymarker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fixed_deposit_table")
public class FixedDepositAccount {
    @Id
    private int id;
    private String accNo;
    private String accHolderName;
    private String fdBondNumber;
    private String fdStartDate;
    private String fdMaturityDate;
    private int depositAmount;
    private int interestRate;
    private boolean matured;

    public FixedDepositAccount() {
    }

    public FixedDepositAccount(int id, String accNo, String accHolderName,
                               String fdBondNumber, String fdStartDate, String fdMaturityDate,
                               int depositAmount, int interestRate, boolean matured) {
        this.id = id;
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.fdBondNumber = fdBondNumber;
        this.fdStartDate = fdStartDate;
        this.fdMaturityDate = fdMaturityDate;
        this.depositAmount = depositAmount;
        this.interestRate = interestRate;
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

    public String getFdStartDate() {
        return fdStartDate;
    }

    public void setFdStartDate(String fdStartDate) {
        this.fdStartDate = fdStartDate;
    }

    public String getFdMaturityDate() {
        return fdMaturityDate;
    }

    public void setFdMaturityDate(String fdMaturityDate) {
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
                ", matured=" + matured +
                '}';
    }
}
