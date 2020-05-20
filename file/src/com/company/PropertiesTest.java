package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        test2();
    }

    /**
     * properties
     */
    private static void test(){
        Properties properties = new Properties();
        properties.setProperty("name","fyb");
        properties.setProperty("age","18");
        properties.setProperty("gender","male");
        System.out.println(properties);
        Set<String> strings = properties.stringPropertyNames();
        for (String key:strings
             ) {
            System.out.println(properties.getProperty(key));
        }
    }

    /**
     * properties and inputStream
     */
    private static void test2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\test\\a.txt"));
        Set<String> strings = properties.stringPropertyNames();
        for (String key:strings
             ) {
            System.out.println(properties.getProperty(key));
        }
    }

}
