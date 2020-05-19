package com.company;

public class Ticket implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在卖:"+ticket--);
            }
        }
    }
}
