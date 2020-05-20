package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        test6();
    }

    /**
     * file实例构建
     */
    private static void test(){
        String pathName = "C:\\test.txt";
        String pathName2 = "C:\\test\\test.txt";
        File file = new File(pathName);
        File file2 = new File(pathName2);
        // 通过父路径和子路径字符串
        String parent = "C:\\test";
        String child = "bbb.txt";
        File file3 = new File(parent, child);
        // 通过父级File对象和子路径字符串
        File parentDir = new File("C:\\test");
        File file4 = new File(parentDir, child);
    }

    /**
     * 常用api
     */
    private static void test2(){
        File file = new File("C:\\test\\test.txt");
        System.out.println("文件绝对路径:"+file.getAbsolutePath());
        System.out.println("文件构造路径:"+file.getPath());
        System.out.println("文件名称:"+file.getName());
        System.out.println("文件长度:"+file.length()+"字节");
        File dir = new File("C:\\test");
        System.out.println("目录绝对路径:"+dir.getAbsolutePath());
        System.out.println("目录构造路径:"+dir.getPath());
        System.out.println("目录名称:"+dir.getName());
        System.out.println("目录长度:"+dir.length()+"字节");
    }

    /**
     * 相对路径 绝对路径
     */
    private static void test3(){
        //绝对路径
        File file = new File("C:\\test\\test.txt");
        System.out.println(file.getAbsolutePath());
        //相对路径
        File file2 = new File("test.txt");
        System.out.println(file2.getAbsolutePath());
    }

    /**
     * 文件和目录是否存在
     */
    private static void test4(){
        File file = new File("C:\\test\\test.txt");
        File file2 = new File("C:\\test");
        System.out.println("file是否存在:"+file.exists());
        System.out.println("file2目录是否存在:"+file2.exists());
        System.out.println("file是否是文件:"+file.isFile());
        System.out.println("file2是否是目录:"+file2.isDirectory());
    }

    /**
     * 文件和目录的创建
     */
    private static void test5(){
        File file = new File("C:\\test\\test.txt");
        //文件创建
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //目录创建
        File file2 = new File("C:\\test\\aaa");
        if(!file2.exists()){
            file2.mkdir();
        }
        //删除文件和目录
        file.delete();
        //空目录才能删除
        file2.delete();
    }
    /**
     * 目录的遍历
     */
    private static void test6(){
        File dir = new File("C:\\test");
        //获取当前目录下的文件及目录的名称
        String[] list = dir.list();
        System.out.println(Arrays.toString(list));
        //获取当前目录下的文件及目录的对象
        File[] files = dir.listFiles();
        System.out.println(Arrays.toString(files));
    }



}
