package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Scanner;

public class UI {

    static HashMap<Long, Account> acctMap = Account.openFromFile();

    Scanner reader = new Scanner(System.in);

    static int eTime;
    private InterestHandler ih;
        public UI() {
            ih = new InterestHandler();
            ih.start();
            cmdInterface();


}
    public void cmdInterface() {
            if (acctMap == null) {
                acctMap = new HashMap<>();
            }

        System.out.println("--------------------------------");


        while(true) {
            System.out.println("1. Skapa nytt konto");
            System.out.println("2. Ta ut pengar på givet konto");
            System.out.println("3. Sätt in pengar");
            System.out.println("4. Visa balansen");
            System.out.println("5. Visa kontolista");
            System.out.println("6. Avsluta");


            int input = Integer.valueOf(reader.nextLine());

            if (input == 1) {
                System.out.println("1. Sparkonto");
                System.out.println("2. Brukskonto");
                System.out.println("3. Kreditkonto");
                int acctType = Integer.valueOf(reader.nextLine());

                System.out.print("Namn: ");
                String name = reader.nextLine();
                Long account = Account.generateAcctNum();

                System.out.print("Balance: ");
                double balance = Double.valueOf(reader.nextLine());

                if (acctType == 1) {
                    acctMap.put(account, new SavingsAccount(name, account, balance));
                    System.out.println("Konto skapats med kontonummer: " + account);
                }
                if (acctType == 2) {
                    acctMap.put(account, new CheckingAccount(name, account, balance));
                    System.out.println("Konto skapats med kontonummer: " + account);

                }
                if (acctType == 3) {
                    if (balance >= -1000 && balance <= 0) {
                        acctMap.put(account, new CreditAccount(name, account, balance));
                        System.out.println("Konto skapats med kontonummer: " + account);
                    } else {
                        System.out.println("Kredit kan tas högst -1000 och minst 0 euro");
                    }

                }




            }
            if (input == 2) {
                System.out.print("Kontonummer: ");
                Long account = Long.valueOf(reader.nextLine());
                System.out.print("Summa: ");
                double sum = Double.valueOf(reader.nextLine());
                acctMap.get(account).withdraw(sum);





            }
            if (input == 3) {
                System.out.print("Kontonummer: ");
                Long account = Long.valueOf(reader.nextLine());
                System.out.print("Summa: ");
                double sum = Double.valueOf(reader.nextLine());
                acctMap.get(account).deposit(sum);


            }
            if (input == 4) {
                System.out.print("Kontonummer: ");
                Long account = Long.valueOf(reader.nextLine());
                System.out.println(acctMap.get(account).printBalance());

            }
            if (input == 5) {
                for (Account key : acctMap.values()) {
                    System.out.println("Kontonummer: " + key.getAcctNum() + " Namn: " + key.getOwner() + " Kontotyp: " + key.getAcctType());
                }


            }
            if (input == 6) {
                System.out.println("--------------------------------");
                System.out.println("Total time: " + eTime);
                ih.interrupt();
                Account.saveToFile(acctMap);

                break;
            }




        }

    }


}

