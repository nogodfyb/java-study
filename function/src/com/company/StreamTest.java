package com.company;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        test7();
    }

    /**
     * 初识stream
     */
    private static void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌1");
        list.add("张无忌2");
        list.add("张无忌3");
        list.add("张无忌4");
        list.add("范延彬");
        list.add("张飞");
        list.stream()
            .filter(s -> s.startsWith("张"))
            .filter(s -> s.length()==4)
            .forEach(s -> System.out.println(s));
        System.out.println(list);
    }

    /**
     * foreach终结方法，意思是对最终结果做处理
     */
    private static void test2(){
        Stream<String> stream = Stream.of("asda", "adsa", "adsa");
        stream.forEach(s -> System.out.println(s));
    }

    /**
     * filter and count
     * 注意foreach和count都是终结方法,一旦调用,stream被关闭
     */
    private static void test3(){
        Stream<String> stream = Stream.of("asd1", "adsa2", "adsa3");
        Stream<String> newStream = stream.filter(s -> s.length() == 4);
       // newStream.forEach(s -> System.out.println(s));
        System.out.println(newStream.count());
    }
    /**
     * map 将流中的元素映射到另一个流
     */
    private static void test4(){
        Stream<String> stream = Stream.of("12", "13", "14");
        Stream<Integer> newStream = stream.map(s -> Integer.parseInt(s));
        newStream.forEach(integer -> System.out.println(integer));
    }

    /**
     * limit
     */
    private static void test5(){
        Stream<String> stream = Stream.of("asd1", "adsa2", "adsa3");
        Stream<String> newStream = stream.limit(2);
        newStream.forEach(s -> System.out.println(s));
    }

    /**
     * skip
     */
    private static void test6(){
        Stream<String> stream = Stream.of("asd1", "adsa2", "adsa3");
        Stream<String> newStream = stream.skip(2);
        newStream.forEach(s -> System.out.println(s));
    }
    /**
     * contact
     */
    private static void test7(){
        Stream<String> stream1 = Stream.of("12", "13", "14");
        Stream<String> stream2 = Stream.of("15", "16", "17");
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(s -> System.out.println(s));
    }
}
