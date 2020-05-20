package com.company;

import java.io.File;

public class Recursion {
    public static void main(String[] args) {
        //System.out.println(test(10));
        //System.out.println(test2(5));
        test3("C:\\test2");
    }

    /**
     * 1-n的累计求和
     */
    private static int test(int n){
        if(n==1){
            return 1;
        }
        return n+test(n-1);
    }

    /**
     * n的阶乘
     */
    private static int test2(int n){
        if(n==1){
            return 1;
        }
        return n*test2(n-1);
    }

    /**
     * 递归打印多级目录
     */
    private static void test3(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File item:files
             ) {
            if(item.isDirectory()){
                test3(item.getAbsolutePath());
            }else System.out.println(item);
        }
    }

}
