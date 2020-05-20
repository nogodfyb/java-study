package com.company;

import java.io.*;

public class IO {
    public static void main(String[] args) throws Exception {
        test19();
    }

    /**
     * 文件输出流对象，继承自字节输出流
     *
     * @throws FileNotFoundException
     */
    private static void test() throws FileNotFoundException {
        File file = new File("C:\\test\\test.txt");
        //如果文件不存在，则会创建文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //使用文件名创建文件流对象
        FileOutputStream fileOutputStream2 = new FileOutputStream("C:\\test\\a.txt");

    }

    /**
     * 写出字节数据
     *
     * @throws IOException
     */
    private static void test2() throws IOException {
        //使用文件名创建文件流对象，对于已存在的文件会覆盖为空白内容
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\a.txt");
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);
        fileOutputStream.close();
    }

    /**
     * 写出字节数组
     *
     * @throws IOException
     */
    private static void test3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\a.txt");
        byte[] bytes = "my name is fyb".getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    /**
     * 将字节数组的指定长度字节写出
     *
     * @throws IOException
     */
    private static void test4() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\a.txt");
        byte[] bytes = "my name is fyb".getBytes();
        fileOutputStream.write(bytes, 2, 2);
        fileOutputStream.close();
    }

    /**
     * 数据追加续写，不清空数据
     *
     * @throws IOException
     */
    private static void test5() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\a.txt", true);
        byte[] bytes = "my name is fyb".getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    /**
     * 写出换行
     *
     * @throws IOException
     */
    private static void test6() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\a.txt");
        byte[] bytes = "my name is fyb".getBytes();
        for (Byte item : bytes
        ) {
            fileOutputStream.write(item);
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }

    /**
     * 文件输入流对象，继承自字节输入流
     *
     * @throws FileNotFoundException
     */
    private static void test7() throws FileNotFoundException {
        File file = new File("C:\\test\\test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //使用文件名创建输入流对象
        FileInputStream fileInputStream2 = new FileInputStream("C:\\test\\test.txt");
    }

    /**
     * 读取字节数据
     *
     * @throws FileNotFoundException
     */
    private static void test8() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\test\\a.txt");
        while (true) {
            int read = fileInputStream.read();
            if (read == -1) {
                break;
            }
            System.out.println((char) read);
        }
        fileInputStream.close();
    }

    /**
     * 使用字节数组读取
     *
     * @throws FileNotFoundException
     */
    private static void test9() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\test\\a.txt");
        byte[] bytes = new byte[2];
        while (true) {
            //read 为有效个数
            int read = fileInputStream.read(bytes);
            if (read == -1) {
                break;
            }
            //只取数组中有效个数读取
            System.out.println(new String(bytes, 0, read));
        }
        fileInputStream.close();
    }

    /**
     * 复制文件
     *
     * @throws FileNotFoundException
     */
    private static void test10() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\test\\123.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\123_copy.jpg");
        //定义读取的字节数组
        byte[] bytes = new byte[1024];
        while (true) {
            //read 为有效个数
            int read = fileInputStream.read(bytes);
            if (read == -1) {
                break;
            }
            //只取数组中有效个数读取，并写入到文件输出流对象
            fileOutputStream.write(bytes, 0, read);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * 字符流为解决一个中文字符占用多个字节存储的问题，专为处理文本文件
     */
    private static void test11() throws IOException {
        FileReader fileReader = new FileReader("C:\\test\\a.txt");
        while (true) {
            int read = fileReader.read();
            if (read == -1) {
                break;
            }
            System.out.println((char) read);
        }
        fileReader.close();
    }

    /**
     * 使用字符数组读取
     *
     * @throws IOException
     */
    private static void test12() throws IOException {
        FileReader fileReader = new FileReader("C:\\test\\a.txt");
        char[] chars = new char[2];
        while (true) {
            //实际读取的有效个数
            int read = fileReader.read(chars);
            if (read == -1) {
                break;
            }
            System.out.println(new String(chars, 0, read));
        }
        fileReader.close();
    }

    /**
     * 写出字符
     *
     * @throws IOException
     */
    private static void test13() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\test\\a.txt");
        fileWriter.write(97);
        fileWriter.write('a');
        fileWriter.write('b');
        fileWriter.write(30000);
        //如果不关闭，数据只是保存到缓冲区，并未保存到文件
        fileWriter.close();
    }


    /**
     * 关闭和刷新
     *
     * @throws IOException
     */
    private static void test14() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\test\\a.txt");
        fileWriter.write('刷');
        fileWriter.write('新');
        // 刷新之后可以继续操作字符输出流对象
        fileWriter.flush();
        fileWriter.write('关');
        fileWriter.write('闭');
        //如果不关闭，数据只是保存到缓冲区，并未保存到文件
        fileWriter.close();
    }

    /**
     * 写出字符数组
     *
     * @throws IOException
     */
    private static void test15() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\test\\a.txt");
        char[] chars = "我是范延彬".toCharArray();
        fileWriter.write(chars);
        fileWriter.write(chars, 0, 2);
        fileWriter.close();
    }

    /**
     * 写出字符串
     *
     * @throws IOException
     */
    private static void test16() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\test\\a.txt");
        String msg = "我是范延彬";
        fileWriter.write(msg);
        fileWriter.write(msg, 0, 2);
        fileWriter.close();
    }

    /**
     * 续写和换行
     *
     * @throws IOException
     */
    private static void test17() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\test\\a.txt", true);
        String msg = "我是范延彬";
        fileWriter.write(msg);
        fileWriter.write("\r\n");
        fileWriter.write("哈哈");
        fileWriter.close();
    }

    /**
     * 异常处理
     */
    private static void test18() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\test\\a.txt");
            fw.write("我是谁！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 异常处理,jdk7
     */
    private static void test19(){
        try (FileWriter fileWriter = new FileWriter("C:\\test\\a.txt")) {
            fileWriter.write("我是谁");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
