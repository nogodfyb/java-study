package com.company;

public class Reference {
    public static void main(String[] args) {
        //test(msg -> System.out.println(msg));
        //方法引用，已有逻辑无需再写
        test(System.out::println);
    }

    private static void test(Printable printable){
            printable.print("hello");
    }
}
