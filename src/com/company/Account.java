package com.company;//********************************************************************
//  Account.java       Author: Lewis/Loftus
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.*;
import java.util.HashMap;

public abstract class Account implements Serializable {


    private long acctNumber;
    private double balance;
    private String name;
    private static Long latestAcctNum = (long) 100;

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------
    //  Sets up the account by defining its owner, account number,
    //  and initial balance.
    //-----------------------------------------------------------------


    public static void saveToFile(HashMap<Long, Account> accounts) {
        try {
            FileOutputStream fOut = new FileOutputStream(new File("acctDb"));
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(accounts);
        }
        catch (FileNotFoundException e) {
            System.out.println("Couldn't save to acctDb");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static HashMap<Long, Account> openFromFile() {
        try {
            FileInputStream fIn = new FileInputStream(new File("acctDb"));
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            HashMap<Long, Account> accounts = (HashMap<Long, Account>) oIn.readObject();

            return accounts;

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, creating new Account database");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }





    public Account(String owner, long account, double initial) {
        name = owner;
        acctNumber = account;
        balance = initial;

    }
    public static Long generateAcctNum() {
        for (Account key : UI.acctMap.values()) {
            latestAcctNum = key.getAcctNum();
        }
        latestAcctNum++;
        return latestAcctNum;
    }

    //-----------------------------------------------------------------
    //  Deposits the specified amount into the account. Returns the
    //  new balance.
    //-----------------------------------------------------------------
    public double deposit(double amount) {
        balance = balance + amount;

        return balance;
    }

    //-----------------------------------------------------------------
    //  Withdraws the specified amount from the account and applies
    //  the fee. Returns the new balance.
    //-----------------------------------------------------------------
    public double withdraw(double amount) {
        balance = balance - amount;

        return balance;
    }
    public String printAccount() {
        return "Kontonummer: " + getAcctNum() + " Namn: " + getOwner() + " Kontotyp: " + getAcctType();
    }

    //-----------------------------------------------------------------
    //  Adds interest to the account and returns the new balance.
    //-----------------------------------------------------------------
    public abstract void addInterest();

    //-----------------------------------------------------------------
    //  Returns the current balance of the account.
    //-----------------------------------------------------------------
    public double getBalance() {
        return balance;
    }
    public String getOwner() { return name; }

    public long getAcctNum() {
        return acctNumber;
    }
    public void setBalance() {
        balance += balance * getRate();
    };
    public abstract String printBalance();
    public abstract double getRate();
    public abstract String getAcctType();


}