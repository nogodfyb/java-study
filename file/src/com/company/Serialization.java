package com.company;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException {
        test2();
    }

    /**
     * 序列化对象到文件持久化存储
     * @throws IOException
     */
    private static void test() throws IOException {
         Person person = new Person();
         person.setName("fyb");
         person.setAge(18);
         person.setGender("男");
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\test\\person.txt"));
         objectOutputStream.writeObject(person);
         objectOutputStream.close();
    }

    /**
     * 反序列化
     * @throws IOException
     */
    private static void test2() throws IOException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\test\\person.txt"));
        try {
            Object o = objectInputStream.readObject();
            Person person=(Person)o;
            System.out.println(person);
            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
