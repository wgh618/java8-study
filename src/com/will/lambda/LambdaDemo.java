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

    /**
     * Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话,它们会被隐含的转为final,这样效率更高）
     * 下面两种方式等效,static只是为了测试
     */
    static String separator = ",";
    static final String separator1 = ",";
    public static void test2() {
        List<String> names = Arrays.asList("Jack","Tom","Jone","Will","Ray","Troy");

        names.forEach(name -> System.out.print(name + separator));

        names.forEach(name -> System.out.print(name + separator1));
    }

    /**
     * 利用lambda表达式实现比较,之前是匿名内部类
     * 如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。下面两个代码片段是等价的
     */
    public static void test3() {
        List<String> names = Arrays.asList("Jack","Tom","Jone","Will","Ray","Troy");
        names.sort((name1, name2) -> name1.compareTo(name2));

        Arrays.asList("v","f","s","a","s").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        } );
    }

    public static void main(String[] args) {
        test1();
    }
}
