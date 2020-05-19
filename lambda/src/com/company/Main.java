package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	    //test();
        //test2();
        test3();
    }

    private static void test(){
        new Thread(()-> System.out.println("这是覆写runnable接口的run方法")).start();
    }

    /**
     * 对象按年龄排序
     */
    private static void test2(){
        Person[] persons={  new Person("fyb1",19),
                            new Person("fyb2",21), 
                            new Person("fyb3",18)};
        System.out.println(Arrays.toString(persons));
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        };
        Arrays.sort(persons,comparator);
        System.out.println(Arrays.toString(persons));
    }

    /**
     * 对象按年龄排序,lambda改造
     */
    private static void test3(){
        Person[] persons={  new Person("fyb1",19),
                new Person("fyb2",21),
                new Person("fyb3",18)};
        System.out.println(Arrays.toString(persons));
        Arrays.sort(persons,(p1,p2)->p1.getAge()-p2.getAge());
        System.out.println(Arrays.toString(persons));
    }


}
