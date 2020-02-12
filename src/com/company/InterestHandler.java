package com.company;

import java.util.ArrayList;

public class InterestHandler extends Thread {
    public void increment() {
        while(true) {
            UI.eTime++;
            if (UI.eTime % 10 == 0) {
                /*for (int i = 0; i < UI.acctList.size(); i++) {
                    UI.acctList.get(i).addInterest();
                }*/
                //UI.acctMap.get()
                for (Account key: UI.acctMap.values()) {
                    key.addInterest();

                }




                }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
                break;
            }

        }
    }
    public void run() { increment();}



}
