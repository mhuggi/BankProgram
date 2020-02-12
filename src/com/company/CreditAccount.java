package com.company;

public class CreditAccount extends Account {
    private double rate = 0.3;
    private String acctType = "Kreditkonto";

    public CreditAccount(String owner, long account, double initial){
        super(owner, account, initial);

    }
    public void addInterest() {
        setBalance();

    }
    public double getRate() {
        return rate;
    }
    public String getAcctType() {
        return acctType;
    }

    @Override
    public double deposit(double amount) {
        if (amount == getBalance() || -amount > getBalance()) {
            return super.deposit(amount);

        }
        System.out.println("Invalid amount");
        return -1;
    }

    @Override
    public double withdraw(double amount) {
        if (getBalance() - amount > -1000) {
            return super.withdraw(amount);
        }
        System.out.println("Invalid amount");
        return -1;

    }

    public String printBalance() {
        return "Saldo: " + getBalance();
    }




}
