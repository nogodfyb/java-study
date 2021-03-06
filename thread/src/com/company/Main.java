package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        test9();
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

    /**
     * wait notify
     */
    private static void test8(){
        Object obj = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println(Thread.currentThread().getName()+"---获取对象锁，调用wait方法,进入waiting状态，释放对象锁");
                        try {
                            //无限等待
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"---从waiting状态醒来，获取到对象锁，继续执行");
                    }
                }
            }
        },"等待线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        //每隔三秒，唤醒一次
                        System.out.println(Thread.currentThread().getName()+"---等待三秒");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj){
                        System.out.println(Thread.currentThread().getName()+"---获取对象锁，调用notify方法,释放对象锁，唤醒其他线程");
                        obj.notify();
                    }
                }
            }
        },"唤醒线程").start();
    }

    /**
     * 线程池
     */
    private static void test9(){
        //创建线程池对象,包含两个线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        MyRunnable myRunnable = new MyRunnable();
        service.submit(myRunnable);
        service.submit(myRunnable);
        //当线程池中的线程对象已被耗尽时，其余任务等待,线程池中的对象被归还
        service.submit(myRunnable);
        service.submit(myRunnable);
        //关闭线程池，一般不做这个操作
        service.shutdown();
    }


}
