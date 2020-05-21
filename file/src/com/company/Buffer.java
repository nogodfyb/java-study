package com.company;

import java.io.*;
import java.util.HashMap;

public class Buffer {
    public static void main(String[] args) throws IOException {
        test6();
    }

    /**
     * 普通流复制文件耗时
     */
    private static void test() {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fileInputStream = new FileInputStream("C:\\test\\123.mp3");
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\123_copy.mp3");
        ) {
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时毫秒:" + (end - start));
    }

    /**
     * 字节缓冲流复制文件耗时
     */
    private static void test2() {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fileInputStream = new FileInputStream("C:\\test\\123.mp3");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\123_copy.mp3");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            while (true) {
                int read = bufferedInputStream.read();
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时毫秒:" + (end - start));
    }

    /**
     * 字节数组和字节缓冲流复制文件
     */
    private static void test3() {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fileInputStream = new FileInputStream("C:\\test\\123.mp3");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\123_copy.mp3");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            byte[] bytes = new byte[8 * 1024];
            while (true) {
                //red是当前读取有效长度字节数
                int read = bufferedInputStream.read(bytes);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时毫秒:" + (end - start));
    }

    /**
     * 字符缓冲输入流基本方法和普通字符流一致，看看它的特有方法
     */
    private static void test4() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\test\\a.txt"))
        ) {
            while (true) {
                //一行一行的读取
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符缓冲输出流基本方法和普通字符流一致，看看它的特有方法
     */
    private static void test5() {
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\test\\a.txt"))

        ) {
            bufferedWriter.write("我是1");
            //换行
            bufferedWriter.newLine();
            bufferedWriter.write("我是2");
            bufferedWriter.write("我是3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 字符缓冲流给文本排序
     */
    private static void test6() throws IOException {
        //键存序号，值为文本
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\test\\a.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\test\\sort.txt"));
        while (true){
            String line = bufferedReader.readLine();
            if(line==null){
                break;
            }
            String[] split = line.split("\\.");
            map.put(split[0],split[1]);
        }
        bufferedReader.close();
        for (int i = 0; i < map.size(); i++) {
            String key=String.valueOf(i);
            String value = map.get(key);
            bufferedWriter.write(key+"."+value);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
