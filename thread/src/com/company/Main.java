package com.company;

public class Main {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
    }

    private static void test1(){
        MyThread myThread1 = new MyThread("我的线程1");
        MyThread myThread2 = new MyThread("我的线程2");
        myThread1.start();
        myThread2.start();
    }

    private static void test2(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1= new Thread(myRunnable, "我的runnable1");
        Thread thread2 = new Thread(myRunnable, "我的runnable2");
        thread1.start();
        thread2.start();
    }

    private static void test3(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现");
            }
        };
        new Thread(runnable).start();
    }

    /**
     * 线程不安全
     * 同样的票数被卖了两回，甚至在一个窗口已经卖到剩98张，另一个窗口还剩99张
     */
    private static void test4(){
        Ticket ticket = new Ticket();
        //创建三个线程，都去操作ticket中的共享数据
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        //同时访问共享数据
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 同步代码块加同步锁保证线程安全
     */
    private static void test5(){
        Ticket2 ticket2 = new Ticket2();
        //创建三个线程，都去操作ticket中的共享数据
        Thread thread1 = new Thread(ticket2, "窗口1");
        Thread thread2 = new Thread(ticket2, "窗口2");
        Thread thread3 = new Thread(ticket2, "窗口3");
        //同时访问共享数据
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 同步方法
     */
    private static void test6(){
        Ticket3 ticket3 = new Ticket3();
        //创建三个线程，都去操作ticket中的共享数据
        Thread thread1 = new Thread(ticket3, "窗口1");
        Thread thread2 = new Thread(ticket3, "窗口2");
        Thread thread3 = new Thread(ticket3, "窗口3");
        //同时访问共享数据
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * lock锁
     */
    private static void test7(){
        Ticket4 ticket4 = new Ticket4();
        //创建三个线程，都去操作ticket中的共享数据
        Thread thread1 = new Thread(ticket4, "窗口1");
        Thread thread2 = new Thread(ticket4, "窗口2");
        Thread thread3 = new Thread(ticket4, "窗口3");
        //同时访问共享数据
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
