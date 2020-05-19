package com.company;

public class Ticket3 implements Runnable {

    private int ticket = 100;

    private Object lock=new Object();

    @Override
    public void run() {

        while (true) {
            sell();
        }
    }

    public synchronized void sell(){
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
