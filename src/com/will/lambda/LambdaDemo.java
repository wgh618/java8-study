package com.will.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:LambdaDemo
 * Description:Jdk8新特性-lambda表达式
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-11
 */
public class LambdaDemo {

    /**
     * 利用lambda表达式循环集合
     */
    public static void test1() {
        List<String> names = Arrays.asList("Jack","Tom","Jone","Will","Ray","Troy");
        names.forEach((final String name) -> System.out.print(name + " "));
        System.out.println();
        names.forEach((name) -> System.out.print(name + " "));
        System.out.println();
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
        names.forEach(System.out::print);
    }

    public static void main(String[] args) {
        test1();
    }
}
