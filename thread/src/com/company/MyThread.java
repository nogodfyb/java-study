package com.company;

public class MyThread extends Thread {

    //构造方法定义线程名
    public MyThread(String name) {
        super(name);
    }

    //重写run，定制线程的执行逻辑
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+":正在执行!"+i);
        }
    }
}
