package com.company;

public class CheckingAccount extends Account {
    private double rate = 0.01;
    private double totalInterest;
    private String acctType = "Brukskonto";


    public CheckingAccount(String owner, long account, double initial){
        super(owner, account, initial);

    }
    public void addInterest() {
        setTotalInterest();
        setBalance();
    }
    public double getTotalInterest() {
        return totalInterest;
    }
    public void setTotalInterest() {
        totalInterest += getBalance() * rate;

    }
    public double getRate() {
        return rate;
    }
    public String getAcctType() {
        return acctType;
    }


    public String printBalance() {
        return "Saldo: " + getBalance() + "\n" + "Totala intäkter: " + getTotalInterest();
    }



}
