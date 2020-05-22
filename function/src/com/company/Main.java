package com.company;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	    //test(()-> System.out.println("初识函数式接口"));

        //test2(2,()-> System.out.println("lambda延迟"));

    /*    String[] arr={"asdad","adsa","adsaadsa"};
        Arrays.sort(arr,test3());
        System.out.println(Arrays.toString(arr));*/

    /*    int[] arr={12,13,34,23};
    int max=test4(() -> {
        int maxNum=arr[0];
        for (int i : arr) {
            if(i>maxNum){
                maxNum=i;
            }
        }
        return maxNum;
    });
        System.out.println(max);*/

    //test5(s -> System.out.println(s),"要消费的字符串");

    //test6(s -> System.out.println(s.toLowerCase()) ,s -> System.out.println(s.toUpperCase()) );

/*        String[] arr={"name,fyb","age,18","gender,male"};
        test7(s -> System.out.print(s.split(",")[0]),s -> System.out.println(s.split(",")[1]),arr);*/

   // test8(s -> s.length()>5);
        test9(s -> s.length()>5,s -> s.length()<11);

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
    /**
     * supplier接口
     */
    private static int test4(Supplier<Integer> supplier){
        return supplier.get();
    }
    /**
     * consumer
     */
    private static void test5(Consumer<String> consumer,String msg){
        consumer.accept(msg);
    }

    /**
     * consumer andThen
     * 链式操作
     */
    private static void test6(Consumer<String> one , Consumer<String> two){
        one.andThen(two).accept("hello");
    }

    /**
     * consumer andThen
     * 链式操作
     */
    private static void  test7(Consumer<String> one , Consumer<String> two,String[] arr){
        for (String info : arr) {
            one.andThen(two).accept(info);
        }
    }

    /**
     * predicate
     */
    private static void  test8(Predicate<String> predicate){
        boolean test = predicate.test("adsadasd");
        System.out.println("字符串是否过长:"+test);
    }

    /**
     * predicate and 表示两个条件&&
     * 同理 or ||
     * negate !
     *
     */
    private static void  test9(Predicate<String> one, Predicate<String> two ){
        boolean valid=one.and(two).test("adsadadads");
        System.out.println("字符串符合要求吗："+valid);
    }


}
