package com.company;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	    //test(()-> System.out.println("初识函数式接口"));
        //test2(2,()-> System.out.println("lambda延迟"));
    /*    String[] arr={"asdad","adsa","adsaadsa"};
        Arrays.sort(arr,test3());
        System.out.println(Arrays.toString(arr));*/

    }

    /**
     * 函数式接口作为方法的参数
     * @param functionInterface
     */
    private static void test(FunctionInterface functionInterface){
        functionInterface.method();
    }

    /**
     * lambda延迟
     */
    private static void test2(int level,FunctionInterface functionInterface){
        if(level==1){
            functionInterface.method();
        }
    }
    /**
     * lambda作为返回值
     */
    private static Comparator<String> test3(){
        return (a,b)->a.length()-b.length();
    }
}
