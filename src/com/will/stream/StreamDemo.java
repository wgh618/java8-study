package com.will.stream;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName:StreamDemo
 * Description:Jdk8新特性-stream API
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public class StreamDemo {
    public static void main(String[] args) {
        /**
         * Intermiate方法
         * filter过滤,接收一个Predicate
         * map将每一个元素进行 1<->1 映射并返回新元素（可以返回不同的类型），接收一个Function
         * flatmap,将一个元素进行1 -> *映射，多端结果用一个Stream保存
         * peek获得每一个元素，不能改变元素，接收一个Consumer
         * distinct去除重复元素
         *
         * limit（n）表示取前n個元素，skip(n)表示跳過前n個元素，這將#導致该操作前面#
         * Intermediate操作所對應的元素數量減少。除非前面有sorted操作（不知道排序后的顺序，无法应用short-cut）
         * eg:len(s) == 10,s.peek().sorted().peek().limit(5),则第一个peek以及sorted处理的元素个数为10，
         * 第二个peek处理的元素个数为5
         *
         * -*- Terminal方法 -*-
         * collect方法将其作为了个Collection返回
         *
         * reduce(start,Function),使用start作为初始种子，两两进行reduce操作
         * min，max,sum,findFirst,findAny,count,forEach,forEachOrdered
         * findFirst/findAny也是一个short-cut操作，可能skip后面的元素
         *
         * 以下三个Match方法并不一定遍历所有元素，只要足够返回条件，则skip剩余元素。
         * allMatch,判断是否全部符合
         * anyMatch,有一个符合即可
         * noneMatch,无符合
         *
         **/
        Stream<String> stringStream = Stream.of("a", "b", "c", "a");
        //此时由于都是Intermediate操作所以并不执行，所以peek操作不会打印
        Stream<Integer> ins = stringStream.
                filter(x -> x != null)
                .map(x -> x.hashCode())
                .distinct()
                .peek(x -> System.out.println(x));
        //此时调用了一个terminal方法，所以前面的Intermediate操作也被执行，所以peek打印hash值
        //anyMatch有skip功能，所以上面的peek不是打印全部元素。
        ins.anyMatch(x -> x == 98);

        /**
         * 自定义生成流，先实现Supplier接口，然后调用Stream.generate()来生成
         * 以下生成一个等差数列
         */
        Stream<Integer> dc = Stream.generate(new Supplier<Integer>() {
            int x = 0;

            @Override
            public Integer get() {
                x += 3;
                return x;
            }
        });
        //不是一个并行流返回false
        System.out.println(dc.isParallel());
        //count用于终结触发前面的中间方法。
        dc.limit(4).peek(x -> System.out.println(x)).count();

        /**
         * Collectors提供了很多有用的reduction方法，可以将stream通过collect转成集合
         * Person::getAge为lambda表达式的特殊用法，等价于 person -> person.getAge()
         */
        Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
                limit(100).
                collect(Collectors.groupingBy(Person::getAge));
        System.out.println(personGroups);
        System.out.println();
    }
}

class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonSupplier implements Supplier<Person> {
    private Random random = new Random();

    @Override
    public Person get() {
        Person p = new Person();
        p.setAge(random.nextInt(20));
        p.setName("sss");
        return p;
    }
}