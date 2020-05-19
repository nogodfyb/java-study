package com.company;

public class Main {

    public static void main(String[] args) {
        //运行时期异常可以不处理
        //test();
        //当调用会产生受检异常的方法时，要么try catch处理，非则继续往上抛出，直到jvm层面
        try {
            test2();
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }
        System.out.println("继续往下执行");
    }

    //当抛出运行时异常，不是必须在方法throws
    private static void test() {
        for (int i = 0; i < 10; i++) {
            if(5==i){
                throw new MyRuntimeException("i等于5");
            }
        }
    }

    //当抛出受检异常，必须在方法throws
    private static void test2() throws MyCheckedException {
        for (int i = 0; i < 10; i++) {
            if(5==i){
                throw new MyCheckedException("i等于5");
            }
        }
    }
}
